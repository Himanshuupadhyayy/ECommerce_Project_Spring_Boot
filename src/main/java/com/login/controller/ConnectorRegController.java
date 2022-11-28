package com.login.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.login.service.ConnectorRegService;

@RestController
public class ConnectorRegController {

	@Autowired
	private ConnectorRegService connectorRegService;

	

	@PostMapping("/connector")
	public ResponseEntity<?> addStudent(
			@RequestParam String connectorName,
			@RequestParam String connectorEmail,
			@RequestParam String connectorPassword,
			@RequestParam String connectorReEnterPassword,
			@RequestParam String connectorMobileNumber,
			@RequestParam String connectorDateOfBirth,
			@RequestParam String connectorAlternateMobileNumber,
			@RequestParam String connector_PermanentAddress,
			@RequestParam String connector_CurrentAddress,
			@RequestParam("photo") MultipartFile connectorPhoto,
			@RequestParam("adhar") MultipartFile connectorAdhar,
			@RequestParam("panCard") MultipartFile connectorPanCard)throws IOException {
		if(connectorPassword.equals(connectorReEnterPassword)) {
		String createConnector = this.connectorRegService.createStudent(connectorName, connectorEmail, connectorPassword,
				connectorReEnterPassword, connectorMobileNumber,connectorDateOfBirth, connectorAlternateMobileNumber, 
				connector_PermanentAddress, connector_CurrentAddress, connectorPhoto, connectorAdhar, connectorPanCard);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter the same password at both places");
		}
		return ResponseEntity.status(HttpStatus.OK).body("File is uploaded successfully");
		}	

}
