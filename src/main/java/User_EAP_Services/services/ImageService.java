package User_EAP_Services.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import User_EAP_Services.documents.ImageModel;
import User_EAP_Services.repositories.ImageRepositories;

@Service
public class ImageService {
	MongoTemplate mongoTemplate;

	@Autowired
	private ImageRepositories imageRepository;
	public void insert(ImageModel imageModel) {
		imageRepository.insert(imageModel);
	}
	public List<ImageModel> getAll() {
		
		 return imageRepository.findAll();
		
		}
	
	
	}
