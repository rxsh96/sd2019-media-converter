from django.urls import path
from .views import convertirImagen

urlpatterns = [
    #path('', HomePageView.as_view(), name="home"),
    path('',convertirImagen,name='home')
]