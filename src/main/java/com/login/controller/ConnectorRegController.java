package com.login.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.login.models.ConnectorRegistration;
import com.login.service.ConnectorRegService;

@RestController
public class ConnectorRegController {

	@Autowired
	private ConnectorRegService connectorRegService;

	

	@PostMapping("/connector")
	public ResponseEntity<?> addStudent(
			@RequestParam String connectorDetails,
			@RequestParam("photo") MultipartFile connectorPhoto,
			@RequestParam("adhar") MultipartFile connectorAdhar,
			@RequestParam("panCard") MultipartFile connectorPanCard)throws IOException {
		String createConnector = this.connectorRegService.createStudent(connectorDetails,
				connectorPhoto, connectorAdhar, connectorPanCard);
		return ResponseEntity.status(HttpStatus.OK).body(createConnector);
		}	
	
	
	
	
	
	@GetMapping("/hello")
	public String helo() {
		return "this is hello page";
	}
}
