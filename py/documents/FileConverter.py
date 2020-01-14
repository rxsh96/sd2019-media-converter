'''import comtypes.client
import os


def convertDOCtoPdf(nombre):
    in_file=os.path.abspath(nombre)
    out_file=os.path.abspath(nombre.split('.')[0]+'pdf')
    wdFormatPDF = 17 
    word = comtypes.client.CreateObject('Word.Application') 
    doc = word.Documents.Open(in_file) 
    doc.SaveAs(out_file, FileFormat=wdFormatPDF) 
    word.Quit() 

convertDOCtoPdf("../prueba/LabGoogleCloudPubSub.docx")
'''

import pypandoc

output = pypandoc.convert_file('somefile.txt', 'rst', format='md')