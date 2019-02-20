package User_EAP_Services.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import User_EAP_Services.documents.ImageModel;


@Repository("imageRepository")
public interface ImageRepositories extends MongoRepository<ImageModel, UUID> {

}
