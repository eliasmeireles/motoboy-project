package br.com.project.motoboy.infra;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	@Autowired
	private HttpServletRequest request;

	public String write(String userImageName, String baseFolder, MultipartFile file) {

		try {

			String realPath = request.getServletContext().getRealPath("/" + baseFolder);
			String path = realPath + "/" +  userImageName + ".jpg";
			file.transferTo(new File(path));

			return baseFolder + "/" + userImageName + ".jpg";

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
