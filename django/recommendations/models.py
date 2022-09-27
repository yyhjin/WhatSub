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

class Menu(models.Model):
    menu_id = models.AutoField(primary_key=True)
    allergies = models.CharField(max_length=255, blank=True, null=True)
    fat = models.FloatField()
    img_url = models.CharField(max_length=255, blank=True, null=True)
    kcal = models.IntegerField()
    length = models.IntegerField()
    menu_desc = models.CharField(max_length=255, blank=True, null=True)
    menu_name = models.CharField(max_length=255, blank=True, null=True)
    price = models.IntegerField()
    protein = models.FloatField()
    sodium = models.FloatField()
    sugar = models.FloatField()
    weight = models.IntegerField()
    ingredients = models.CharField(max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'menu'

class Combination(models.Model):
    combination_id = models.CharField(primary_key=True, max_length=255)
    allergies = models.CharField(max_length=255, blank=True, null=True)
    fat = models.FloatField()
    img_url = models.CharField(max_length=255, blank=True, null=True)
    kcal = models.IntegerField()
    price = models.IntegerField()
    protein = models.FloatField()
    sodium = models.FloatField()
    sugar = models.FloatField()
    weight = models.IntegerField()
    menu = models.ForeignKey('Menu', models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'combination'

class CombinationPost(models.Model):
    combination_post_id = models.AutoField(primary_key=True)
    comb_name = models.CharField(max_length=255, blank=True, null=True)
    content = models.CharField(max_length=255, blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    likes_cnt = models.IntegerField()
    statistics = models.JSONField(blank=True, null=True)
    combination = models.ForeignKey(Combination, models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'combination_post'

class Review(models.Model):
    review_id = models.AutoField(primary_key=True)
    content = models.TextField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    score = models.IntegerField()
    combination_post = models.ForeignKey(CombinationPost, models.DO_NOTHING, blank=True, null=True)
    user = models.ForeignKey('User', models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'review'

class Ingredient(models.Model):
    ingredient_id = models.AutoField(primary_key=True)
    allergies = models.CharField(max_length=255, blank=True, null=True)
    category = models.CharField(max_length=255, blank=True, null=True)
    fat = models.FloatField()
    img_url = models.CharField(max_length=255, blank=True, null=True)
    kcal = models.IntegerField()
    name = models.CharField(max_length=255, blank=True, null=True)
    price = models.IntegerField()
    protein = models.FloatField()
    sodium = models.FloatField()
    sugar = models.FloatField()
    weight = models.IntegerField()

    class Meta:
        managed = False
        db_table = 'ingredient'