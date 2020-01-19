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
	
	
	public BufferedImage convertToPNG(MultipartFile file) {
		File myFile = FileConverter.convertMultiPartToFile(file);
		Mat image = Imgcodecs.imread(myFile.getPath());
		
		MatOfByte matOfByte = new MatOfByte();
		Imgcodecs.imencode(".png", image, matOfByte);
		
		Imgcodecs.imwrite(myFile.getAbsolutePath()+".png", image);
		
		FileConverter.deleteFile(myFile);
		try {
			return ImageIO.read(new ByteArrayInputStream(matOfByte.toArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public BufferedImage convertToJPG(MultipartFile file) {
		File myFile = FileConverter.convertMultiPartToFile(file);
		Mat image = Imgcodecs.imread(myFile.getPath());
		
		MatOfByte matOfByte = new MatOfByte();
		Imgcodecs.imencode(".jpg", image, matOfByte);
		
		Imgcodecs.imwrite(myFile.getAbsolutePath()+".jpg", image);
		
		FileConverter.deleteFile(myFile);
		try {
			return ImageIO.read(new ByteArrayInputStream(matOfByte.toArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public BufferedImage convertToBMP(MultipartFile file) {
		File myFile = FileConverter.convertMultiPartToFile(file);
		Mat image = Imgcodecs.imread(myFile.getPath());
		
		MatOfByte matOfByte = new MatOfByte();
		Imgcodecs.imencode(".bmp", image, matOfByte);
		
		Imgcodecs.imwrite(myFile.getAbsolutePath()+".bmp", image);
		
		FileConverter.deleteFile(myFile);
		try {
			return ImageIO.read(new ByteArrayInputStream(matOfByte.toArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public BufferedImage convertToTIFF(MultipartFile file) {
		File myFile = FileConverter.convertMultiPartToFile(file);
		Mat image = Imgcodecs.imread(myFile.getPath());
		
		MatOfByte matOfByte = new MatOfByte();
		Imgcodecs.imencode(".tiff", image, matOfByte);
		
		Imgcodecs.imwrite(myFile.getAbsolutePath()+".tiff", image);
		
		FileConverter.deleteFile(myFile);
		try {
			return ImageIO.read(new ByteArrayInputStream(matOfByte.toArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
}
