from django.shortcuts import render
from .models import User
# Create your views here.

def test(request):
    users = User.objects.all()
    context = {
        "users": users
    }
    return render(request, 'index.html', context)