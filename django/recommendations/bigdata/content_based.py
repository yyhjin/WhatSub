import pandas as pd
from sklearn.metrics.pairwise import cosine_similarity

def get_data_frame(dibs,combination_posts,combinations,user_id):
    combination_posts = pd.DataFrame(list(combination_posts.values()))[['combination_post_id','combination_id']]
    combinations = pd.DataFrame(list(combinations.values()))[['combination_id','bland','chewy','nutty','soft','sour','spicy','sweet']]
    dibs = pd.DataFrame(list(dibs.values()))[['combination_post_id','user_id']]

    # dibs에 combination_id 추가
    dibs = dibs[dibs['user_id']==user_id][['combination_post_id']]
    dibs['combination_id'] = dibs.apply(lambda x: '', axis=1)
    for i, row in dibs.iterrows():
        dibs.at[i,'combination_id'] = combination_posts[combination_posts['combination_post_id']==row['combination_post_id']]['combination_id'].values[0]

    columns = ['bland','chewy','nutty','soft','sour','spicy','sweet']
    df = pd.DataFrame(index=list(set(combination_posts['combination_id'])-set(dibs['combination_id'])), columns=columns)

    for i, row in df.iterrows(): # 나중에 score 열 추가해야함
        for col in columns:
            df.at[i,col] = combinations[combinations['combination_id']==i][col].values[0]
    # print(df)

    df_dibs = pd.DataFrame(index=dibs['combination_id'], columns=columns)

    for i, row in df_dibs.iterrows(): # 나중에 score 열 추가해야함
        df_dibs.at[i,'bland'] = combinations[combinations['combination_id']==i]['bland'].values[0]
        df_dibs.at[i,'chewy'] = combinations[combinations['combination_id']==i]['chewy'].values[0]
        df_dibs.at[i,'nutty'] = combinations[combinations['combination_id']==i]['nutty'].values[0]
        df_dibs.at[i,'soft'] = combinations[combinations['combination_id']==i]['soft'].values[0]
        df_dibs.at[i,'sour'] = combinations[combinations['combination_id']==i]['sour'].values[0]
        df_dibs.at[i,'spicy'] = combinations[combinations['combination_id']==i]['spicy'].values[0]
        df_dibs.at[i,'sweet'] = combinations[combinations['combination_id']==i]['sweet'].values[0]
    # print(df_dibs)
   
    return df, df_dibs

# 꿀조합 게시판 목록에서 유저 구매목록을 제외한 리스트를 반환
# 유저가 구매해본 샌드위치를 다시 추천해주지 않기 위함
def difference_of_sets(total,user):
    total_filtered = pd.merge(total, user, how='left', indicator=True, left_index=True, right_index=True)
    total_filtered = total_filtered.query('_merge == "left_only"').drop(columns=['_merge']).reset_index(drop=True)
    # print('꿀조합 게시판 목록 - 고객이 먹어본 목록')
    # print(total_filtered,'\n')
    return total_filtered, user

def find_similar_sandwich(total,user):
    try:
        res = cosine_similarity(total,user)
        # print('코사인 유사도(행:게시판, 열:주문내역)')
        # print(res,'\n') # 각 열에서 1이 아닌 가장 높은 값의 인덱스
        combination_count = {} # 샌드위치별 count
        # 열을 순회하면서 가장 비슷한 샌드위치를 찾아서 combination_count에 반영
        for j in range(len(res[0])):
            maxV = maxIdx = 0
            for i in range(len(res)):
                # print(res[i][j])
                if res[i][j] == 1:
                    continue
                if res[i][j] > maxV:
                    maxV = res[i][j]
                    maxIdx = i
            combination_count[total.index[maxIdx]] = combination_count.get(maxIdx, 0)+ 1
        # print('가장 비슷한 샌드위치 카운트')
        # print(combination_count,'\n') 
        result = sorted(combination_count.items(), key=lambda x: x[1], reverse=True)[:5]
        result = list(map(lambda x: x[0], result))
    except:
        return []
    return result  

def get_content_based_filtering(users,reviews,combination_posts,combinations):
    total, user = get_data_frame(users,reviews,combination_posts,combinations)
    # total, user = get_dummy_data()
    # total, user = difference_of_sets(total,user)
    result = find_similar_sandwich(total,user)

    return result