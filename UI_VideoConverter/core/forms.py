from django import forms

class ConvertirImagenForm(forms.Form):
    
    archivo=forms.FileField()

