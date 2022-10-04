from django.urls import path
from . import views

urlpatterns = [
    # path('content-based-filtering/', views.content_based_filtering),
    # path('collaborative/', views.collaborative_filtering),
    path('hybrid/<int:user_id>/', views.hybrid_recommendation),
    path('hybrid/dummy/', views.create_dummy),
]