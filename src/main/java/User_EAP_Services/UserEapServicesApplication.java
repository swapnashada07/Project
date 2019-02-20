package User_EAP_Services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import User_EAP_Services.property.FileStorageProperties;


@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})

public class UserEapServicesApplication {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(UserEapServicesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UserEapServicesApplication.class, args);

		logger.info("--Userconfiguration_EAP_Services Started--");
	}

}

