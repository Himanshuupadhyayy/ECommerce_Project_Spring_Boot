
/*

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.login.models.ConnectorDocuments;
import com.login.repository.ConnectorDocuRepo;
import com.login.service.ConnectorDocService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.login.dto.ConnectorRegDto;


package com.login;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.login.dto.ConnectorRegDto;
import com.login.models.ConnectorRegistration;

public class temp {

	
//service
	
	@Autowired
	private ModelMapper mapper;
	

	public ConnectorRegDto createStudent(ConnectorRegDto connectorRegDto) {
		ConnectorRegistration connectorRegistration = this.dtoToConnector(connectorRegDto);
		ConnectorRegistration saveStudent = this.connectorRegRepo.save(connectorRegistration);
		return this.connectorToDto(saveStudent);
	}

	public ConnectorRegistration dtoToConnector(ConnectorRegDto connectorRegDto) {
		ConnectorRegistration connectorRegistration = this.mapper.map(connectorRegDto, ConnectorRegistration.class);
		return connectorRegistration;
	}

	public ConnectorRegDto connectorToDto(ConnectorRegistration connectorRegistration) {
		ConnectorRegDto connectorRegDto = this.mapper.map(connectorRegistration, ConnectorRegDto.class);
		return connectorRegDto;
	}

	
//controller
 		@PostMapping("/connector")
	public ResponseEntity<ConnectorRegDto> addStudent(@RequestBody ConnectorRegDto connectorRegDto) {
		ConnectorRegDto createConnector = this.connectorRegService.createStudent(connectorRegDto);
		return new ResponseEntity<ConnectorRegDto>(createConnector, HttpStatus.CREATED);
	}
	
	
	
	
	
//connector doc controller
 * 	@Autowired
	private ConnectorDocService connectorDocService;

	@PostMapping("/connectorDoc")
	public ResponseEntity<?> addStudent(
			@RequestParam String connector_PermanentAddress,
			@RequestParam String connector_CurrentAddress,
			@RequestParam("photo") MultipartFile connectorPhoto,
			@RequestParam("adhar") MultipartFile connectorAdhar,
			@RequestParam("panCard") MultipartFile connectorPanCard)throws IOException {
		String createConnector = this.connectorDocService.createStudent(connector_PermanentAddress, connector_CurrentAddress, connectorPhoto, connectorAdhar, connectorPanCard);
		return ResponseEntity.status(HttpStatus.OK).body("File is uploaded successfully");
		}	
	
	
	
//doc service	
	
	
	@Autowired
	private ConnectorDocuRepo connectorDocuRepo;

	private String FOLDER_PATH="C:\\Users\\Development\\All_Photos\\";
	
	
	public String createStudent(String connector_PermanentAddress, 
			String connector_CurrentAddress, MultipartFile connectorPhoto,
			MultipartFile connectorAdhar, MultipartFile connectorPanCard)throws IOException {
		// get the fullly path of all files
		String connector_Photo_FilePath = FOLDER_PATH + connectorPhoto.getOriginalFilename();
		String connector_Adhar_FilePath = FOLDER_PATH + connectorAdhar.getOriginalFilename();
		String connector_PanCard_FilePath= FOLDER_PATH + connectorPanCard.getOriginalFilename();
		// will check the file type is it jpg or pdf
		String photoFileType = connectorPhoto.getContentType();
		String adharFileType = connectorAdhar.getContentType();
		String panCardFileType= connectorPanCard.getContentType();
		
		if (photoFileType.equals("image/png") || photoFileType.equals("image/jpeg")) {
			if (adharFileType.equals("application/pdf") && panCardFileType.equals("application/pdf")) {

		ConnectorDocuments saveDocuments = this.connectorDocuRepo.save(ConnectorDocuments.builder()
				.connector_CurrentAddress(connector_CurrentAddress)
				.connector_PermanentAddress(connector_PermanentAddress)
		
				.connector_Adhar_FileName(connectorPanCard.getOriginalFilename())
				.connector_Adhar_FilePath(connector_Adhar_FilePath)
				.connector_Adhar_FileType(adharFileType)
				
				.connector_Photo_FileName(connectorPhoto.getOriginalFilename())
				.connector_Photo_FileType(photoFileType)
				.connector_Photo_FilePath(connector_Photo_FilePath)
				
				.connector_PanCard_FileName(connectorPanCard.getOriginalFilename())
				.connector_PanCard_FilePath(connector_PanCard_FilePath)
				.connector_PanCard_FileType(panCardFileType).build());
		
				// take file from source path and paste it to the destination path
				connectorPhoto.transferTo(new File(connector_Photo_FilePath));
				connectorAdhar.transferTo(new File(connector_Adhar_FilePath));
				connectorPanCard.transferTo(new File(connector_PanCard_FilePath));
		if (saveDocuments != null) {
			return "file uploaded successfully : ";
		}
	}
}else{
	return"image in jpg or png formate";
	}
		return"photo and aadhar file is uploaded";}
}
	
	}
 */
	
	
