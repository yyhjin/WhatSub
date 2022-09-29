from itertools import combinations
# from .models import Ingredient
import pandas as pd

pd.set_option('display.max_columns', 20)

def fill_df(df_ingredients,df_menus,df_combination,total):
    # 빈 데이터 프레임 mysql이랑 똑같이 만들고 csv 파일로 받아서 넣기
    columns = df_combination.columns[1:]
    df = pd.DataFrame(index=total, columns=columns)
    cnt = 0
    for i, row in df[:1000].iterrows():
        allergies = set()
        bland = chewy = fat = kcal = nutty = price = protein = salty =sodium = soft = sour = spicy = sugar = sweet = 0
        img_url = ''

        menu = i[0]
        price += df_menus.loc[menu]['price']
        img_url = df_menus.loc[menu]['img_url']
        allergies.update(df_menus.loc[menu]['allergies'].split(','))
        for j in range(1,len(i),2):
            ingredient = i[j:j+2]
            bland += df_ingredients.loc[ingredient]['bland']
            chewy += df_ingredients.loc[ingredient]['chewy']
            fat += df_ingredients.loc[ingredient]['fat']
            kcal += df_ingredients.loc[ingredient]['kcal']
            nutty += df_ingredients.loc[ingredient]['nutty']
            protein += df_ingredients.loc[ingredient]['protein']
            price += df_ingredients.loc[ingredient]['price']
            salty += df_ingredients.loc[ingredient]['salty']
            sodium += df_ingredients.loc[ingredient]['sodium']
            soft += df_ingredients.loc[ingredient]['soft']
            sour += df_ingredients.loc[ingredient]['sour']
            spicy += df_ingredients.loc[ingredient]['spicy']
            sugar += df_ingredients.loc[ingredient]['sugar']
            sweet += df_ingredients.loc[ingredient]['sweet']

            allergies.update(df_ingredients.loc[ingredient]['allergies'].split(','))

        allergies.remove('')
        df.at[i,'allergies'] = ','.join(allergies) 
        df.at[i,'img_url'] = img_url
        
        df.at[i, 'bland'] = bland
        df.at[i, 'chewy'] = chewy
        df.at[i, 'fat'] = fat
        df.at[i, 'kcal'] = kcal
        df.at[i, 'nutty'] = nutty
        df.at[i, 'price'] = price
        df.at[i, 'protein'] = protein
        df.at[i, 'salty'] = salty
        df.at[i, 'sodium'] = sodium
        df.at[i, 'soft'] = soft
        df.at[i, 'sour'] = sour
        df.at[i, 'spicy'] = spicy
        df.at[i, 'sugar'] = sugar
        df.at[i, 'sweet'] = sweet
        cnt+=1
        if cnt % 100 == 0:
            print(cnt)  
    print(df[:5])
    df[:1000].to_csv("C:\\Users\\SSAFY\\Desktop\\df.csv",sep=',',na_rep='NaN',encoding="utf-8-sig")
    pass

def make_combinations(ingredients,menus,combination):
    ingredients = pd.DataFrame(list(ingredients.values()))
    df_ingredients = ingredients.set_index(keys=['ingredient_id'], inplace=False, drop=True)
    menus = pd.DataFrame(list(menus.values()))
    df_menus = menus.set_index(keys=['menu_id'], inplace=False, drop=True)
    df_combination = pd.DataFrame(list(combination.values()))
    
    # 20 * 6 * 3 * (8C8 + 8C7) * (14C1 + 14C2) = 340200 가지
    menus = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t'] # 메뉴 20개
    breads = ['1a','1b','1c','1d','1e','1f'] # 빵 6개
    cheeses = ['2a','2b','2c'] # 치즈 3개
    vegetables = ['3a','3b','3c','3d','3e','3f','3g','3h'] # 야채 8개
    sauces = ['4a','4b','4c','4d','4e','4f','4g','4h','4i','4j','4k','4l','4m','4n'] # 소스 14개

    vegetables7 = list(map(lambda x: ''.join(x), combinations(vegetables,7)))
    vegetables8 = list(map(lambda x: ''.join(x), combinations(vegetables,8)))
    vegetable_comb = vegetables7 + vegetables8

    sauces2 = list(map(lambda x: ''.join(x), combinations(sauces,2)))
    sauce_comb = sauces + sauces2

    total = []
    name = ''
    for menu in menus:
        for bread in breads:
            for cheese in cheeses:
                for vegetable in vegetable_comb:
                    for sauce in sauce_comb:
                        name = menu+bread+cheese+vegetable+sauce
                        total.append(name)
    # print(len(total))
    fill_df(df_ingredients,df_menus,df_combination,total)

    pass


    

if __name__ == '__main__':
    print(20*6*3*9*(14+91))
