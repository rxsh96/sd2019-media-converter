package MyImageConverterWeb;

import java.awt.Image;
import java.awt.image.BufferedImage;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javacv.ImageConverter;

@RestController
public class ImageEndPoint  {
	
	
	@PostMapping("/imagepng")
	public Image pngFile(@RequestParam("png") MultipartFile file, RedirectAttributes redirectAttributes) {
		BufferedImage bimage = new ImageConverter().convertToPNG(file);
		Image image = (Image)bimage;
		return image;
	}
	
	@PostMapping("/imagejpg")
	public Image jpgFile(@RequestParam("jpg") MultipartFile file, RedirectAttributes redirectAttributes) {
		BufferedImage bimage = new ImageConverter().convertToJPG(file);
		Image image = (Image)bimage;
		return image;
	}
	
	@PostMapping("/imagebmp")
	public Image bmpFile(@RequestParam("bmp") MultipartFile file, RedirectAttributes redirectAttributes) {
		BufferedImage bimage = new ImageConverter().convertToBMP(file);
		Image image = (Image)bimage;
		return image;
	}
	
	@PostMapping("/imagetiff")
	public Image tifFile(@RequestParam("tiff") MultipartFile file, RedirectAttributes redirectAttributes) {
		BufferedImage bimage = new ImageConverter().convertToTIFF(file);
		Image image = (Image)bimage;
		return image;
	}

	
}
