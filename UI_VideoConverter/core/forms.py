from django import forms

class ConvertirImagenForm(forms.Form):
    archivo=forms.FileField()

"""class ConvertirDocumentoForm(forms.Form):
    documento=forms.FileField()"""