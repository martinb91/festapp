package hu.bandur.boot.pictureHandler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import hu.bandur.boot.pictureHandler.storage.StorageService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UploadController {

	@Autowired
	StorageService storageService;

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@CrossOrigin
	@GetMapping("/file/{name}.json")
	public ResponseEntity<List<String>> getFile(Model model, @PathVariable String name) {
		List<String> fileNames = new ArrayList<>();
		fileNames.add(MvcUriComponentsBuilder
						.fromMethodName(UploadController.class, "getFile", name).build().toString());
		return ResponseEntity.ok().body(fileNames);
	}
}
