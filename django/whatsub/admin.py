from django.contrib import admin
from django.contrib.auth.models import User, Group, Permission

admin.site.unregister(User)
admin.site.unregister(Group)
admin.site.unregister(Permission)