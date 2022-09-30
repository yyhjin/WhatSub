import pandas as pd
import random
def make_response(result, combination_posts, ingredients, combinations, menus):
    df_combination_posts = pd.DataFrame(list(combination_posts.values()))[['combination_id','comb_name','content']]
    df_combinations = pd.DataFrame(list(combinations.values()))[['combination_id','kcal','protein','sodium','fat','sugar','allergies','price']]
    df_ingredients = pd.DataFrame(list(ingredients.values()))[['ingredient_id','category','name','img_url']]
    df_menus = pd.DataFrame(list(menus.values()))[['menu_id', 'menu_name', 'img_url']]
    response = []
    for sandwich in result: # 순회하면서 json 만들기
        partial = {}
        partial['combination_id'] = sandwich
        partial['comb_name'] = df_combination_posts[df_combination_posts['combination_id']==sandwich]['comb_name'].values[0]
        partial['content'] =  df_combination_posts[df_combination_posts['combination_id']==sandwich]['content'].values[0]
        partial['kcal'] = df_combinations[df_combinations['combination_id']==sandwich]['kcal'].values[0]
        partial['protein'] = df_combinations[df_combinations['combination_id']==sandwich]['protein'].values[0]
        partial['sodium'] = df_combinations[df_combinations['combination_id']==sandwich]['sodium'].values[0]
        partial['fat'] = df_combinations[df_combinations['combination_id']==sandwich]['fat'].values[0]
        partial['sugar'] = df_combinations[df_combinations['combination_id']==sandwich]['sugar'].values[0]
        partial['allergies'] = df_combinations[df_combinations['combination_id']==sandwich]['allergies'].values[0]
        partial['price'] = df_combinations[df_combinations['combination_id']==sandwich]['price'].values[0]
        # partial['img_url'] = df_combinations[df_combinations['combination_id']==sandwich]['img_url'].values[0]
        
        menu = sandwich[0]
        partial['menu'] = {'menu_id': menu, 
                            'menu_name': df_menus[df_menus['menu_id']==menu]['menu_name'][0],
                            'img_url': df_menus[df_menus['menu_id']==menu]['img_url'][0]}

        elements = []
        for i in range(1,len(sandwich),2):
            part = {}
            element = sandwich[i:i+2]
            # print(df_ingredients[df_ingredients['ingredient_id']==element]['category'].index)
            # print(df_ingredients[df_ingredients['ingredient_id']==element]['category'].values[0])
            part['ingredient_id'] = element
            part['category'] = df_ingredients[df_ingredients['ingredient_id']==element]['category'].values[0]
            part['name'] = df_ingredients[df_ingredients['ingredient_id']==element]['name'].values[0]
            part['img_url'] = df_ingredients[df_ingredients['ingredient_id']==element]['img_url'].values[0]

            elements.append(part)
        partial['ingredients'] = elements

        response.append(partial)

    return response
    
def response_dto(content_based_result,collaborative_result,combination_posts, ingredients, combinations, menus, excludeds, user_id):
    total_result = list(set(content_based_result+collaborative_result))
    
    # user_id에 따른 excluded 리스트
    df_excludeds = pd.DataFrame(list(excludeds.values()))
    df_excludeds = df_excludeds[df_excludeds['user_id']==user_id]
    # 추천된 샌드위치 목록 result에서 사용자의 제외재료를 포함한 샌드위치들 제거
    result = []
    for sandwich in total_result:
        for ingredient in df_excludeds['ingredient_id'].values:
            if ingredient in sandwich:
                break
        else:
            result.append(sandwich)
    # 제거했는데 남은 샌드위치가 없거나, 원래 넘어온 결과가 없으면 꿀조합 게시판에서 상위 10개 중에 랜덤 한개 리턴
    if len(result) == 0:
        df_combination_posts = pd.DataFrame(list(combination_posts.values()))[['combination_id','comb_name','content','likes_cnt']]
        # order by likes_cnt 위에서 10개 뽑아서 combination_id만 리스트로
        df_combination_posts = df_combination_posts.sort_values(by=['likes_cnt'], axis=0, ascending=False)
        result = df_combination_posts[:10]['combination_id'].values
        response = make_response(result, combination_posts, ingredients, combinations, menus)
        return response

    # hybrid로 추천된 리스트가 있으면
    result = random.sample(result,1)
    response = make_response(result, combination_posts, ingredients, combinations, menus)
    # print(response)
    return response
    