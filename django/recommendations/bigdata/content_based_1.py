import pandas as pd
import numpy as np
from sklearn.metrics.pairwise import cosine_similarity

# 문제점 코사인 유사도 쓰면 숫자 크기가 반영됨 
# => 치즈1 입장에서 치즈3보다 치즈2랑 더 비슷한게 아닌데 어케해결하지
# 치즈1 = 짠맛2 + 고소함1 이런식으로 각 재료마다 맛을 부여하고 평점4 이상 준것에 대해 가중평균하면 메뉴에 대한 단 짠 고 컬럼 수치가 나올듯?

# 빵 => 부드러움/바삭, 열량
# 치즈 => 짠맛, 쫄깃함
# 소스 => 새콤, 달콤, 고소, 매콤, 밋밋

# 샌드위치이름 부드러움 짬 쫄깃함 새콤 달콤 고소 매콤 밋밋 열량(백의자리)
# JMT샌드위치     3    3    2    1    1   4    1    2    4 

ingredient_name = {'bread': {'1':'허니오트','2':'하티','3':'위트'},
                    'vegetable': {'a':'양상추','b':'토마토','c':'오이','d':'피망','e':'양파','f':'피클'},
                    'cheese': {'1':'아메리칸','2':'슈레드','3':'모차렐라'},
                    'sauce': {'a':'랜치','d':'마요네즈','e':'스위트 어니언','f':'허니 머스타드','g':'스위트 칠리','i':'핫 칠리'} }
def get_dummy_data():
    # 샌드위치 - 재료 테이블
    # combination_id = ['2,abcd,1,fgi','1,abdef,3,de'] # '2,abcd,1,fgi' 빵 2, 야채 abcd, 치즈 1, 소스 fgi
    # combination_name = ['JMT샌드위치', '치즈폭탄스테이크']
    ingredient_name = {'bread': {'1':'허니오트','2':'하티','3':'위트'},
                        'vegetable': {'a':'양상추','b':'토마토','c':'오이','d':'피망','e':'양파','f':'피클'},
                        'cheese': {'1':'아메리칸','2':'슈레드','3':'모차렐라'},
                        'sauce': {'a':'랜치','d':'마요네즈','e':'스위트 어니언','f':'허니 머스타드','g':'스위트 칠리','i':'핫 칠리'} }
    # 이후 카테고리, 이미지, 영양정보, 가격은 일단 생략   


    # 게시판에 있는 전체 꿀조합 데이터(10개)
    total_combination_id = ['2,abcd,1,fgi','1,abdef,3,de','3,abc,1,af','1,adef,3,ad','2,acd,1,ade','3,bdef,3,gi','1,adf,1,fi','2,abf,3,df','3,acde,1,fgi','1,abdf,3,de']
    combination_name = ['JMT샌드위치', '치즈폭탄스테이크','샌1','샌2','샌3','샌4','샌5','샌6','샌7','샌8']
    total_bread = [1,3,2,4,5,6,2,4,3,3] 
    total_cheese = [1,2,3,1,2,3,1,2,3,1]
    total_menu = [2,7,8,9,3,2,2,3,2,3]
    total_score = [4,4,1,2,3,5,5,3,2,1] 
    total_soft = [1,2,4,5,3,1,2,3,3,2]
    total_salty = [3,2,2,3,4,1,5,5,2,1]
    total_rows = [total_combination_id,combination_name,total_bread,total_cheese,total_menu, total_score, total_soft, total_salty]
    total_columns = ['combination_id','combination_name','bread','cheese','menu','score','soft','salty']
    total = pd.DataFrame(np.transpose(total_rows),columns=total_columns)
    print('꿀조합 게시판에 있는 꿀조합 목록')
    print(total,'\n')

    # 별점으로 필터링하고 soft, salty 열만 남기기
    total_filtered = total.loc[total['score']>='3'][['combination_id','combination_name','soft','salty']]
    print('꿀조합 게시판에 있는 꿀조합 목록(평점3이상만 필터링)')
    print(total_filtered,'\n')

    # 고객 주문 내역 (5개)
    user_combination_id = ['2,abcd,1,fgi','1,abdef,3,de','3,abc,1,af','1,adef,3,ad','2,acd,1,ade']
    user_combination_name =['JMT샌드위치','샌9','샌10','샌11','샌12']
    user_bread = [1,3,3,5,2] 
    user_cheese = [1,2,2,2,2]
    user_menu = [2,7,8,8,7]
    user_score = [4,4,5,3,5]
    user_soft = [1,4,5,2,1]
    user_salty = [3,1,2,3,4]
    user_rows = [user_combination_id,user_combination_name,user_bread,user_cheese,user_menu,user_score, user_soft, user_salty]
    user_columns = ['combination_id','combination_name','bread','cheese','menu','score','soft','salty']
    user = pd.DataFrame(np.transpose(user_rows),columns=user_columns)
    print('특정 고객이 주문한 내역')
    print(user,'\n')

    user_filtered = user.loc[user['score']>='4'][['combination_id','combination_name','soft','salty']]
    print('특정 고객이 주문한 내역(4점이상만 필터링)')
    print(user_filtered,'\n')

    return total_filtered, user_filtered

# 꿀조합 게시판 목록에서 유저 구매목록을 제외한 리스트를 반환
# 유저가 구매해본 샌드위치를 다시 추천해주지 않기 위함
def difference_of_sets(total,user):
    total_filtered = pd.merge(total, user, how='outer', indicator=True)
    total_filtered = total_filtered.query('_merge == "left_only"').drop(columns=['_merge']).reset_index(drop=True)
    print('꿀조합 게시판 목록 - 고객이 먹어본 목록')
    print(total_filtered,'\n')
    return total_filtered, user

def find_similar_sandwich(total,user):
    res = cosine_similarity(total[['soft','salty']],user[['soft','salty']])
    print('코사인 유사도(행:게시판, 열:주문내역)')
    print(res,'\n') # 각 열에서 1이 아닌 가장 높은 값의 인덱스
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
        combination_count[maxIdx] = combination_count.get(maxIdx, 0)+ 1
    print('가장 비슷한 샌드위치 카운트')
    print(combination_count,'\n') 

    return combination_count    

def get_content_based_filtering():
    total, user = get_dummy_data()
    total, user = difference_of_sets(total,user)
    combination_count = find_similar_sandwich(total,user)
    result = []
    for k,v in combination_count.items():
        partial = {}
        partial['combination_id'] = total.loc[k].combination_id
        partial['combination_name'] = total.loc[k].combination_name

        bread,vegetables,cheese,sauces = total.loc[k].combination_id.split(',')
        ingredients = {'bread':{},'vegetable':[],'cheese':{},'sauce':[]}
        ingredients['bread']['id'] = bread
        ingredients['bread']['name'] = ingredient_name['bread'][bread]
        
        for vegetable in vegetables:
            tmp = {}
            tmp['id'] = vegetable
            tmp['name'] = ingredient_name['vegetable'][vegetable]
            ingredients['vegetable'].append(tmp)

        ingredients['cheese']['id'] = cheese
        ingredients['cheese']['name'] = ingredient_name['cheese'][cheese]
        
        for sauce in sauces:
            tmp = {}
            tmp['id'] = sauce
            tmp['name'] = ingredient_name['sauce'][sauce]
            ingredients['sauce'].append(tmp)

        partial['ingredients'] = ingredients

        partial['count'] = v
        result.append(partial)
    print(result)
    return result

get_content_based_filtering()

# def get_content_based_filtering(reviews, compositions):
#     pass