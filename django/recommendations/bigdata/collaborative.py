import pandas as pd
from sklearn.metrics.pairwise import cosine_similarity


# mysql => dataframe
def get_data_frame(users, reviews, combination_posts):
    df_user = pd.DataFrame(list(users.values()))[['user_id']]
    df_review = pd.DataFrame(list(reviews.values()))[['combination_post_id','user_id','score']]
    df_combination_posts = pd.DataFrame(list(combination_posts.values()))[['combination_post_id','combination_id']]
    # print(df_user)
    # print(df_review)
    # print(df_combination_posts)
    combination_post_dict = df_combination_posts.set_index('combination_post_id').T.to_dict('list') # combination_post_id : combination_id 딕셔너리

    # review 테이블에 combination_id 추가하고 post_id는 떨구고 
    df_review['combination_id']=df_review.apply(lambda x:  combination_post_dict[x['combination_post_id']][0],axis=1)
    df_review = df_review[['combination_id','user_id','score']]
    # print('리뷰테이블')
    # print(df_review,'\n')
    # print(list(set(df_review['combination_id'])))
    columns = list(set(df_review['combination_id']))

    # user_id 행 combination_id 열로 하는 거 빈 테이블 만들어놓고 review 순회하면서 채워넣고
    df = pd.DataFrame(index=df_user['user_id'],columns=columns) # 빈 테이블 생성
    for i, row in df_review.iterrows():
        df.at[row['user_id'], row['combination_id']] = row['score']
        # df.loc[row['user_id']][row['combination_id']] = row['score']
    df = df.fillna(0)
    # print('고객-메뉴-점수 테이블')
    # print(df,'\n')
    return df


# 유저는 1-5까지 점수를 줄 수 있으며 0은 null이라고 생각
def get_cosine_similarity(df, user):
    # user 'A'를 받았으면 'A'가 평가하지 않은 item은 제외하고 각각의 유저와 유사도를 구해야함

    # df에서 'A'가 평가하지 않은 샌드위치 column 제거
    scored = [] # user가 평가한 샌드위치 
    not_scored = [] # user가 아직 평가하지 않은 샌드위치
    for col in df.columns:
        if df.loc[user][col] != 0:
            scored.append(col)
        else:
            not_scored.append(col)
    
    df = df[scored]
    cosine_sim = cosine_similarity(df,df.loc[[user]])
    # print(f'--유저{user}와 다른 유저들의 코사인 유사도--')
    # print(cosine_sim)
    # print()

    return not_scored, cosine_sim

def get_expected_score(df,not_scored, cosine_sim, user): 
    
    # print(f'--유저{user}의 평가하지 않은 샌드위치 예상점수 채우기 전--')
    # print(df[not_scored])
    df = df.astype('float') # 소수를 넣기 위해 df 타입 변환

    # 코사인 유사도 이용해서 user가 아직 평가하지 않은 샌드위치에 대해 예상점수 채워넣기
    for sandwich in not_scored:
        weighted_score = total_sim = 0
        for score, sim  in zip(list(df[sandwich]),cosine_sim):
            sim = sim[0]
            if score != 0 :
                weighted_score += score*sim
                total_sim += sim
        df.loc[user][sandwich] = round(weighted_score / total_sim,2) if total_sim != 0 else 0
    # print()
    # print(f'--유저{user}의 평가하지 않은 샌드위치 예상점수 채운 후--')
    # print(df[not_scored])
    # print()

    # 예상점수가 가장 높은 것들 중에 상위 n개 뽑아서 리턴 or 예상점수가 일정기준(4점?)을 넘는 것들 리턴
    result = []
    for sandwich in not_scored:
        if df.loc[user][sandwich] >= 4:
            result.append(sandwich)

    return result


def get_collaborative_filtering(user, users, reviews, combination_posts, ingredients, combinations, menus): # user 인자로 넣기 
    df = get_data_frame(users,reviews,combination_posts)
    not_scored, cosine_sim =get_cosine_similarity(df,user)
    result = get_expected_score(df,not_scored, cosine_sim, user)
    return result

#USER = 'B' # 변수로 받기
# print('협업 필터링 결과: ',get_collaborative_filtering(USER))