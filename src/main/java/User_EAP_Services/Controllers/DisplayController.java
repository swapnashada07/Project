package User_EAP_Services.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import User_EAP_Services.documents.ImageModel;
import User_EAP_Services.services.FileStorageService;
import User_EAP_Services.services.ImageService;

@RestController
@RequestMapping("productapi")
@CrossOrigin(origins = "http://localhost:4200")

public class DisplayController {

	private static final Logger logger = LoggerFactory.getLogger(DisplayController.class);

	@Autowired
	private FileStorageService fileStorageService;
	@Autowired
	private ImageService imgservice;

	@GetMapping("/downloadFile")
	public ResponseEntity<Resource> downloadFile(@RequestParam String fileName, HttpServletRequest request) {

		Resource resource = fileStorageService.loadFileAsResource(fileName);

		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			logger.info("Could not determine file type.");
		}

		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);

	}

	@GetMapping("/getData")
	public List<ImageModel> getData() 
	{
		return imgservice.getAll();
	}

}
