package com.example.pdf;

import com.example.pdf.Entity.PdfDemo;
import com.example.pdf.Service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.channels.MulticastChannel;

@SpringBootApplication
@RestController
@RequestMapping("/kk")
public class PdfApplication {

	@Autowired
	PdfService pdfService;
@PostMapping
	public ResponseEntity<?>up(@RequestParam("kj") MultipartFile file) throws IOException {
		String  d=pdfService.uploading(file);
		return ResponseEntity.status(HttpStatus.OK).body(d);
	}

	@GetMapping("/{name}")

	public ResponseEntity<?>dow(@PathVariable String name){
	byte[]pdd=pdfService.dowling(name);
	return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_PDF)
			.body(pdd);
	}
	@PostMapping("/file")
	public ResponseEntity<?>dow(@RequestParam("kj") MultipartFile file) throws Exception {
		String  d=pdfService.uploadFileData(file);
		return ResponseEntity.status(HttpStatus.OK).body(d);
	}
	@GetMapping("/file/{name}")

	public ResponseEntity<?>dowfile(@PathVariable String name) throws IOException {
		byte[]pdd=pdfService.dowloadFile(name);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_PDF)
				.body(pdd);
	}



	public static void main(String[] args) {
		SpringApplication.run(PdfApplication.class, args);
	}

}
