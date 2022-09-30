from django.db import models

# Create your models here.
class Branch(models.Model):
    branch_id = models.AutoField(primary_key=True)
    branch_name = models.CharField(max_length=255, blank=True, null=True)
    contact_no = models.CharField(max_length=255, blank=True, null=True)
    lat = models.FloatField()
    lng = models.FloatField()
    street_address = models.CharField(max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'branch'


class Collection(models.Model):
    collection_id = models.AutoField(primary_key=True)
    menu_name = models.CharField(max_length=255, blank=True, null=True)
    rank_date = models.DateTimeField(blank=True, null=True)
    ranking = models.IntegerField()
    user = models.ForeignKey('User', models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'collection'


class Combination(models.Model):
    combination_id = models.CharField(primary_key=True, max_length=255)
    allergies = models.CharField(max_length=255, blank=True, null=True)
    bland = models.IntegerField()
    chewy = models.IntegerField()
    fat = models.FloatField()
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
    img_url = models.CharField(max_length=255, blank=True, null=True)
    user = models.ForeignKey('User', models.DO_NOTHING, blank=True, null=True)
    score_avg = models.FloatField()

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


class Excluded(models.Model):
    excluded_id = models.IntegerField(primary_key=True)
    ingredient = models.ForeignKey('Ingredient', models.DO_NOTHING, blank=True, null=True)
    user = models.ForeignKey('User', models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'excluded'


class HibernateSequence(models.Model):
    next_val = models.BigIntegerField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'hibernate_sequence'


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


class OrderHistory(models.Model):
    order_history_id = models.AutoField(primary_key=True)
    count = models.IntegerField()
    order = models.ForeignKey('Orders', models.DO_NOTHING, blank=True, null=True)
    combination = models.ForeignKey(Combination, models.DO_NOTHING, blank=True, null=True)
    birth_year = models.IntegerField()
    gender = models.CharField(max_length=255, blank=True, null=True)
    subti = models.CharField(max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'order_history'

class Orders(models.Model):
    order_id = models.AutoField(primary_key=True)
    order_price = models.IntegerField()
    ordered_at = models.DateTimeField(blank=True, null=True)
    branch = models.ForeignKey(Branch, models.DO_NOTHING, blank=True, null=True)
    user = models.ForeignKey('User', models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'orders'
        
class Review(models.Model):
    review_id = models.AutoField(primary_key=True)
    content = models.CharField(max_length=255)
    created_at = models.DateTimeField(blank=True, null=True)
    score = models.IntegerField()
    combination_post = models.ForeignKey(CombinationPost, models.DO_NOTHING, blank=True, null=True)
    user = models.ForeignKey('User', models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'review'


class TodaySurvey(models.Model):
    today_survey_id = models.AutoField(primary_key=True)
    response = models.CharField(max_length=255, blank=True, null=True)      
    menu = models.ForeignKey(Menu, models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'today_survey'


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