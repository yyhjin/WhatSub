from django.urls import path
from . import views

urlpatterns = [
    path('', views.test),
    path('api', views.api_test),
    path('content-based-filtering', views.content_based_filtering)
]