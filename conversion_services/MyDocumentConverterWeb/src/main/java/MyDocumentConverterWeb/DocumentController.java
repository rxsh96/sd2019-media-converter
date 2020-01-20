package MyDocumentConverterWeb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javapoi.DocumentConverter;


@RestController
public class DocumentController {

	/**
	 * Method that converts a .doc file into .pdf file.
	 * @param multipartFile the data from the post request. 
	 * @param redirectAttributes
	 * @return a response as a PDF document. 
	 * @throws IOException
	 */
	@PostMapping("/docfile")
	public ResponseEntity<Resource> convert(@RequestParam("file") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws IOException {
		String convertedFilePath = new DocumentConverter().docToPdfConversion(multipartFile);
		if(convertedFilePath != null) {
			File convertedFile = new File(convertedFilePath);
			InputStreamResource resource = new InputStreamResource(new FileInputStream(convertedFile));
			HttpHeaders header = new HttpHeaders();
	        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf");
	        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
	        header.add("Pragma", "no-cache");
	        header.add("Expires", "0");
	        
	        return ResponseEntity.ok()
		    		.headers(header)
		            .contentLength(convertedFile.length())
		            .contentType(MediaType.parseMediaType("application/octet-stream"))
		            .body(resource);
		}
		return null;
	}
	
}
