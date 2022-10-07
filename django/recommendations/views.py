from django.shortcuts import render, get_list_or_404
from .models import User, Review, CombinationPost, Ingredient, Combination, Menu, Dib, Excluded

from rest_framework.decorators import api_view
from rest_framework.response import Response

from .serializers import UserSerializer

from .bigdata.content_based import get_content_based_filtering
from .bigdata.collaborative import get_collaborative_filtering

from .combination_data import make_combinations
from .bigdata.response_dto import response_dto
# Create your views here.

@api_view(['GET'])
def content_based_filtering(request): # user_id 파라미터 받기
    dibs = Dib.objects.all()
    combination_posts = CombinationPost.objects.all()
    combinations = Combination.objects.all()
    result = get_content_based_filtering(dibs,combination_posts,combinations,1)
    return Response(result)

@api_view(['GET'])
def collaborative_filtering(request):
    users = User.objects.all()
    reviews = Review.objects.all()
    combination_posts = CombinationPost.objects.all()
    ingredients = Ingredient.objects.all()
    combinations = Combination.objects.all()
    menus = Menu.objects.all()
    response = get_collaborative_filtering(2, users, reviews, combination_posts, ingredients, combinations, menus)
    return Response(response)

@api_view(['GET'])
def hybrid_recommendation(request, user_id):
    dibs = Dib.objects.all()
    combination_posts = CombinationPost.objects.all()
    combinations = Combination.objects.all()
    users = User.objects.all()
    reviews = Review.objects.all()
    ingredients = Ingredient.objects.all()
    menus = Menu.objects.all()
    excludeds = Excluded.objects.all()
    # 찜한 것도 없고 점수매긴 것도 없으면 걍 빈 리스트 반환 => 예외처리하기
    content_based_result = get_content_based_filtering(dibs,combination_posts,combinations,user_id)
    collaborative_result = get_collaborative_filtering(user_id, users, reviews, combination_posts, ingredients, combinations, menus)
    # 두개 결과 함수로 보내면 리스트 합치고 셋으로 중복 제거해서 json 형태로 변환
    response = response_dto(content_based_result,collaborative_result,combination_posts, ingredients, combinations, menus, excludeds, user_id)
    return Response(response)


@api_view(['GET'])
def create_dummy(request):
    ingredients = Ingredient.objects.all()
    menus = Menu.objects.all()
    combination = Combination.objects.all()
    make_combinations(ingredients,menus,combination)
    return Response({'boo':'far'})



