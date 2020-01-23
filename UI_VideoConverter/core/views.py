from django.shortcuts import render
from django.views.generic.list import ListView
from django.views.generic.base import TemplateView
from django.contrib.auth.decorators import login_required
from django.utils.decorators import method_decorator
from django.urls import reverse_lazy
from django.http import HttpResponseRedirect
from .forms import *
from django.core.files.images import ImageFile
import requests
from django.http import HttpResponse


'''class HomePageView(TemplateView):
    template_name = "core/index.html"

    def get(self, request, *args, **kwargs):
        return render(request, self.template_name,{'title':"Mi web admin"})'''

def convertirImagen(request):
    if request.method=="POST":
        form = ConvertirImagenForm(request.POST, request.FILES)
        if form.is_valid():
            url = "http://1b337416.ngrok.io/pngimage"
            files = [
              ('image', request.FILES['archivo'].read())
            ]
            response = requests.request("POST", url, files = files)
            resp = HttpResponse(response.content, content_type="image/jpeg")
            resp['Content-Disposition'] = 'attachment; filename=%s.png' % request.FILES['archivo']
            return resp
    else:
        form=ConvertirImagenForm()
    return render(request,'core/index.html',{'form':form})