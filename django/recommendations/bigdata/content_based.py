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

def get_dummy_data():
    # 샌드위치 - 재료 테이블
    combination_id = ['2,abcd,1,fgi','1,abdef,3,de'] # '2abcd1fgi' 빵 2, 야채 abcd, 치즈 1, 소스 fgi
    combination_name = ['JMT샌드위치', '치즈폭탄스테이크']
    ingredient_name = {'bread': {'1':'허니오트','2':'하티','3':'위트'},
                        'vegetable': {'a':'양상추','b':'토마토','c':'오이','d':'피망','e':'양파','f':'피클'},
                        'cheese': {'1':'아메리칸','2':'슈레드','3':'모차렐라'},
                        'sauce': {'a':'랜치','d':'마요네즈','e':'스위트 어니언','f':'허니 머스타드','g':'스위트 칠리','i':'핫 칠리'} }
    # 이후 카테고리, 이미지, 영양정보, 가격은 일단 생략   


    # 게시판에 있는 전체 꿀조합 데이터(10개)
    total_combination_id = [x for x in range(1,11)]
    total_bread = [1,3,2,4,5,6,2,4,3,3] 
    total_cheese = [1,2,3,1,2,3,1,2,3,1]
    total_menu = [2,7,8,9,3,2,2,3,2,3]
    total_score = [4,4,1,2,3,5,5,3,2,1]
    total_rows = [total_combination_id,total_bread,total_cheese,total_menu,total_score]
    total_columns = ['combination_id','bread','cheese','menu','score']
    total = pd.DataFrame(np.transpose(total_rows),columns=total_columns)
    # print(total)

    # 고객 주문 내역 (5개)
    user_combination_id = [x for x in range(1,6)]
    user_bread = [1,3,3,5,2] 
    user_cheese = [1,2,2,2,2]
    user_menu = [2,7,8,8,7]
    user_score = [4,4,5,3,5]
    user_rows = [user_combination_id,user_bread,user_cheese,user_menu,user_score]
    user_columns = ['combination_id','bread','cheese','menu','score']
    user = pd.DataFrame(np.transpose(user_rows),columns=user_columns)
    # print(user)

    return total, user


def find_similar_sandwich(total,user):
    res = cosine_similarity(total,user)
    print(res) # 각 열에서 1이 아닌 가장 높은 값의 인덱스
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
        print(maxIdx)
        combination_count[maxIdx] = combination_count.get(maxIdx, 0)+ 1
    print(combination_count) 

    return combination_count    

def get_content_based_filtering():
    total, user = get_dummy_data()
    combination_count = find_similar_sandwich(total,user)

    return combination_count

get_content_based_filtering()
# def get_content_based_filtering(reviews, compositions):
#     pass