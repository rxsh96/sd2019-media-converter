import cv2

def convertJPGtoPNG(path,nombre,quality):
    img=cv2.imread(path+nombre)
    cv2.imwrite(path+nombre.split('.')[0]+'.png',img,[cv2.IMWRITE_PNG_COMPRESSION,quality])

def convertPNGtoJPG(path,nombre,quality):
    img=cv2.imread(path+nombre)
    cv2.imwrite(path+nombre.split('.')[0]+'.jpg',img,[cv2.IMWRITE_JPEG_QUALITY,quality])

def convertWHITEandBLACK(path,nombre):
    img=cv2.imread(path+nombre)
    img_gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
    cv2.imwrite(path+'gray_'+nombre,img_gray)

