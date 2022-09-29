import pandas as pd
def response_dto(content_based_result,collaborative_result,combination_posts, ingredients, combinations, menus):
    result = list(set(content_based_result+collaborative_result))

    df_combination_posts = pd.DataFrame(list(combination_posts.values()))[['combination_id','comb_name','content']]
    df_combinations = pd.DataFrame(list(combinations.values()))[['combination_id','kcal','protein','sodium','fat','sugar','allergies','price','img_url']]
    df_ingredients = pd.DataFrame(list(ingredients.values()))[['ingredient_id','category','name','img_url']]
    df_menus = pd.DataFrame(list(menus.values()))[['menu_id', 'menu_name']]
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
        partial['img_url'] = df_combinations[df_combinations['combination_id']==sandwich]['img_url'].values[0]
        
        menu = sandwich[0]
        partial['menu'] = {'menu_id': menu, 
                            'menu_name': df_menus[df_menus['menu_id']==menu]['menu_name'][0]}

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
    # print(response)
    return response
    