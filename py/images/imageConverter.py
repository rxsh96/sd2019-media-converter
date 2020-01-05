from PIL import Image

def convert_image_to_bmp(image, new_name = 'new_image'):
	Image.open(image).save(new_name+'.bmp')

def convert_image_to_png(image, new_name = 'new_image'):
	Image.open(image).save(new_name+'.png')

def convert_image_to_jpg(image, new_name = 'new_image'):
	Image.open(image).convert('RGB').save(new_name+'.jpg')

def convert_image_to_tiff(image, new_name = 'new_image'):
	Image.open(image).save(new_name+'.tiff', save_all = True, compression = None)

def convert_image_to_gif(image, new_name = 'new_image'):
	return
	

'''
# SECCION DE PRUEBAS 

# PARA CONVERTIR A BMP
convert_image_to_bmp('samples/test.gif', 'converted/bmp/gif')
convert_image_to_bmp('samples/test.jpg', 'converted/bmp/jpg')
convert_image_to_bmp('samples/test.png', 'converted/bmp/png')
convert_image_to_bmp('samples/test.tiff', 'converted/bmp/tiff')

# PARA CONVERTIR A PNG
convert_image_to_png('samples/test.gif', 'converted/png/gif')
convert_image_to_png('samples/test.jpg', 'converted/png/jpg')
convert_image_to_png('samples/test.bmp', 'converted/png/bmp')
convert_image_to_png('samples/test.tiff', 'converted/png/tiff')

# PARA CONVERTIR A JPG
convert_image_to_jpg('samples/test.gif', 'converted/jpg/gif')
convert_image_to_jpg('samples/test.bmp', 'converted/jpg/bmp')
convert_image_to_jpg('samples/test.png', 'converted/jpg/png')
convert_image_to_jpg('samples/test.tiff', 'converted/jpg/tiff')

# PARA CONVERTIR A TIFF
convert_image_to_tiff('samples/test.gif', 'converted/tiff/gif')
convert_image_to_tiff('samples/test.bmp', 'converted/tiff/bmp')
convert_image_to_tiff('samples/test.png', 'converted/tiff/png')
convert_image_to_tiff('samples/test.jpg', 'converted/tiff/jpg')

# PARA CONVERTIR A GIF
convert_image_to_gif('samples/test.tiff', 'converted/gif/tiff')
convert_image_to_gif('samples/test.bmp', 'converted/gif/bmp')
convert_image_to_gif('samples/test.png', 'converted/gif/png')
convert_image_to_gif('samples/test.jpg', 'converted/gif/jpg')
'''