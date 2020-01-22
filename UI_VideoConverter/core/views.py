from django.shortcuts import render
from django.views.generic.list import ListView
from django.views.generic.base import TemplateView
from django.contrib.auth.decorators import login_required
from django.utils.decorators import method_decorator
from django.urls import reverse_lazy
from django.http import HttpResponseRedirect
from .forms import *
import requests

'''class HomePageView(TemplateView):
    template_name = "core/index.html"

    def get(self, request, *args, **kwargs):
        return render(request, self.template_name,{'title':"Mi web admin"})'''
def convertirImagen(request):
    if request.method=="POST":
        form=ConvertirImagenForm(request.POST or None,request.FILES or None)
        if form.is_valid():
            img_publicacion=request.FILES['archivo']
            print(img_publicacion)
            url="http://08786c79.ngrok.io/pngimage1"
            payload={}
            files=[('image',img_publicacion)]
            headers = {'Content-Type': 'application/x-www-form-urlencoded'}
            response = requests.request("POST", url, headers=headers, data = payload, files = files)
            print(response.text.encode('utf8'))
    else:
        form=ConvertirImagenForm()
    return render(request,'core/index.html',{'form':form})