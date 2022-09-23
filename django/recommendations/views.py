from django.shortcuts import render, get_list_or_404
from .models import User, Review

from rest_framework.decorators import api_view
from rest_framework.response import Response

from .serializers import UserSerializer

from .bigdata.content_based_1 import get_content_based_filtering
# Create your views here.

def test(request):
    users = User.objects.all()
    reviews = Review.objects.all()
    context = {
        "users": users,
        "reviews": reviews
    }
    return render(request, 'index.html', context)

@api_view(['GET'])
def api_test(request):
    users = User.objects.all()
    serializer = UserSerializer(users, many=True)
    return Response(serializer.data)

@api_view(['GET'])
def content_based_filtering(request): # user_id 파라미터 받기
    # mysql에서 데이터 가져와서 content_based.py로 넘겨주기

    # reviews = get_list_or_404(Review, user_id=user_id)
    # compositions = []
    # for review in reviews:
    #     compositions.append(get_list_or_404(Composition, combination_id=review.combination_id))
    result = get_content_based_filtering()
    return Response(result)
