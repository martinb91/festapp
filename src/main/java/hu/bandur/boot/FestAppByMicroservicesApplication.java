package hu.bandur.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import hu.bandur.boot.pictureHandler.storage.StorageService;

import javax.annotation.Resource;

@SpringBootApplication
public class FestAppByMicroservicesApplication implements CommandLineRunner {

	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(FestAppByMicroservicesApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
//		storageService.deleteAll(); Kész a mappa, így majd csak, ha újra szeretnénk inicializálni akkor érdemes ezt használni
//		storageService.init();
	}
}
