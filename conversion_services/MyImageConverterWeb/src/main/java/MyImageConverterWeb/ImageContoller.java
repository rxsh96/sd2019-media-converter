package MyImageConverterWeb;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javacv.ImageConverter;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;



@RestController
public class ImageContoller  {
		
	
	/**
	 * POST controller to handle PNG images conversion
	 * @param multipartFile from post request data
	 * @param redirectAttributes
	 * @return the ResponseEntity
	 * @throws IOException
	 */
	@PostMapping("/pngimage")
	public ResponseEntity<Resource> pngFile(@RequestParam("png") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException {
		
		String convertedFilePath = new ImageConverter().pngConversion(multipartFile);
		
		if(convertedFilePath != null) {
			File convertedFile = new File(convertedFilePath);
			InputStreamResource resource = new InputStreamResource(new FileInputStream(convertedFile));
			HttpHeaders header = new HttpHeaders();
	        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=img.png");
	        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
	        header.add("Pragma", "no-cache");
	        header.add("Expires", "0");
	        
	        return ResponseEntity.ok()
		    		.headers(header)
		            .contentLength(convertedFile.length())
		            .contentType(MediaType.parseMediaType("image/png"))
		            .body(resource);
		}
		return null;
	}

	
	@PostMapping("/jpgimage")
	public ResponseEntity<Resource> jpgFile(@RequestParam("jpg") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException {
		
		String convertedFilePath = new ImageConverter().jpgConversion(multipartFile);
		
		if(convertedFilePath != null) {
			File convertedFile = new File(convertedFilePath);
			InputStreamResource resource = new InputStreamResource(new FileInputStream(convertedFile));
			HttpHeaders header = new HttpHeaders();
	        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=img.jpg");
	        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
	        header.add("Pragma", "no-cache");
	        header.add("Expires", "0");
	        
	        return ResponseEntity.ok()
		    		.headers(header)
		            .contentLength(convertedFile.length())
		            .contentType(MediaType.parseMediaType("image/jpeg"))
		            .body(resource);
		}
		return null;
	}
	
	
}
