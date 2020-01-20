package javapoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileConverter {

	
	public static File convertMultiPartToFile(MultipartFile file) {
        File convFile = new File("..\\temp\\files\\"+file.getOriginalFilename());
        FileOutputStream fos;
		try {
			fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
	        fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return convFile;
    }
	
	public static boolean deleteFile(File file) {
		return file.delete();
	}
	
}
