from django.shortcuts import render
from django.views.generic.list import ListView
from django.views.generic.base import TemplateView
from django.contrib.auth.decorators import login_required
from django.utils.decorators import method_decorator
from django.urls import reverse_lazy


class HomePageView(TemplateView):
    template_name = "core/index.html"

    def get(self, request, *args, **kwargs):
        return render(request, self.template_name,{'title':"Mi web admin"})