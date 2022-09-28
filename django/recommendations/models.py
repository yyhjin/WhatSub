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
    menu_id = models.CharField(primary_key=True, max_length=255)
    allergies = models.CharField(max_length=255, blank=True, null=True)
    bland = models.IntegerField()
    chewy = models.IntegerField()
    fat = models.FloatField()
    img_url = models.CharField(max_length=255)
    ingredients = models.CharField(max_length=255)
    kcal = models.FloatField()
    menu_desc = models.CharField(max_length=255)
    menu_name = models.CharField(max_length=255)
    nutty = models.IntegerField()
    price = models.IntegerField()
    protein = models.FloatField()
    salty = models.IntegerField()
    sodium = models.FloatField()
    soft = models.IntegerField()
    sour = models.IntegerField()
    spicy = models.IntegerField()
    sugar = models.FloatField()
    sweet = models.IntegerField()

    class Meta:
        managed = False
        db_table = 'menu'

class Combination(models.Model):
    combination_id = models.CharField(primary_key=True, max_length=255)
    allergies = models.CharField(max_length=255, blank=True, null=True)
    bland = models.IntegerField()
    chewy = models.IntegerField()
    fat = models.FloatField()
    img_url = models.CharField(max_length=255)
    kcal = models.FloatField()
    nutty = models.IntegerField()
    price = models.IntegerField()
    protein = models.FloatField()
    salty = models.IntegerField()
    sodium = models.FloatField()
    soft = models.IntegerField()
    sour = models.IntegerField()
    spicy = models.IntegerField()
    sugar = models.FloatField()
    sweet = models.IntegerField()

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
    img_url = models.CharField(max_length=255)

    class Meta:
        managed = False
        db_table = 'combination_post'

class Dib(models.Model):
    dib_id = models.IntegerField(primary_key=True)
    combination_post_id = models.IntegerField()
    state = models.TextField()  # This field type is a guess.
    user = models.ForeignKey('User', models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'dib'

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
    ingredient_id = models.CharField(primary_key=True, max_length=255)
    allergies = models.CharField(max_length=255, blank=True, null=True)
    bland = models.IntegerField()
    category = models.CharField(max_length=255)
    chewy = models.IntegerField()
    fat = models.FloatField(blank=True, null=True)
    img_url = models.CharField(max_length=255)
    kcal = models.FloatField(blank=True, null=True)
    name = models.CharField(max_length=255)
    nutty = models.IntegerField()
    price = models.IntegerField()
    protein = models.FloatField(blank=True, null=True)
    salty = models.IntegerField()
    sodium = models.FloatField(blank=True, null=True)
    soft = models.IntegerField()
    sour = models.IntegerField()
    spicy = models.IntegerField()
    sugar = models.FloatField(blank=True, null=True)
    sweet = models.IntegerField()

    class Meta:
        managed = False
        db_table = 'ingredient'