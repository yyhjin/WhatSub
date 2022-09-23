from django.db import models

# Create your models here.
class User(models.Model):
    user_id = models.AutoField(primary_key=True)
    auth_id = models.CharField(max_length=255, blank=True, null=True)     
    birth_year = models.IntegerField()
    email = models.CharField(max_length=255, blank=True, null=True)       
    gender = models.CharField(max_length=255, blank=True, null=True)
    is_diet = models.TextField()  # This field type is a guess.
    profile_img = models.CharField(max_length=255, blank=True, null=True)
    refresh_token = models.CharField(max_length=255, blank=True, null=True)
    subti = models.CharField(max_length=255, blank=True, null=True)
    user_name = models.CharField(unique=True, max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'user'

class Review(models.Model):
    review_id = models.AutoField(primary_key=True)
    content = models.TextField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    score = models.IntegerField()

    class Meta:
        managed = False
        db_table = 'review'