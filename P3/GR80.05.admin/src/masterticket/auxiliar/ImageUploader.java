package masterticket.auxiliar;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

public class ImageUploader {

	public static InputStream uploadImage(Part foto) {
		InputStream inputStream = null;
		long fileSize = foto.getSize();
		String fileContent = foto.getContentType();
			try {
				inputStream = foto.getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("INPUTSTREAM DE IMAGEN GENERADO CORRECTAMENTE");
		return inputStream;
	}	
}
