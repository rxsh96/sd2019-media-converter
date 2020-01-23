package javacv;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.web.multipart.MultipartFile;

public class ImageConverter {


	public ImageConverter() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}	
	
	/**
	 * Method that converts an image to PNG format
	 * @param multipartFile from post request data
	 * @return the new converted image path
	 */
	public String pngConversion(MultipartFile multipartFile) {
		File myFile = FileConverter.convertMultiPartToFile(multipartFile);
		Mat image = Imgcodecs.imread(myFile.getPath());
		String convertedFilePath = myFile.getPath()+".png";
		FileConverter.deleteFile(myFile);
		if(Imgcodecs.imwrite(convertedFilePath, image)) {
			return convertedFilePath;
		}
		return null;
	}
	
	
	/**
	 * Method that converts an image to JPG format
	 * @param multipartFile from post request data
	 * @return the new converted image path
	 */
	public String jpgConversion(MultipartFile multipartFile) {
		File myFile = FileConverter.convertMultiPartToFile(multipartFile);
		Mat image = Imgcodecs.imread(myFile.getPath());
		String convertedFilePath = myFile.getPath()+".jpg";
		FileConverter.deleteFile(myFile);
		if(Imgcodecs.imwrite(convertedFilePath, image)) {
			return convertedFilePath;
		}
		return null;
	}
	

}
