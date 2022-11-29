package com.login.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.login.models.ConnectorDocuments;
import com.login.models.ConnectorRegistration;
import com.login.repository.ConnectorRegRepo;

@Service
public class ConnectorRegService {

	@Autowired
	private ConnectorRegRepo connectorRegRepo;

	@Autowired
	private ObjectMapper objectMapper;
	
	private String FOLDER_PATH = "C:\\Users\\Development\\All_Photos\\";

	public String createStudent(String connectorDetails, MultipartFile connectorPhoto, 
			MultipartFile connectorAdhar, MultipartFile connectorPanCard)
			throws IOException {

		// get the fullly path of all files
		String connector_Photo_FilePath = FOLDER_PATH + connectorPhoto.getOriginalFilename();
		String connector_Adhar_FilePath = FOLDER_PATH + connectorAdhar.getOriginalFilename();
		String connector_PanCard_FilePath = FOLDER_PATH + connectorPanCard.getOriginalFilename();
		
		ConnectorRegistration doc=objectMapper.readValue(connectorDetails, ConnectorRegistration.class);
		if(doc.getConnectorPassword().equals(doc.getConnectorReEnterPassword())) {
		ConnectorRegistration saveDocuments = this.connectorRegRepo
				.save(ConnectorRegistration.builder()
						.connectorName(doc.getConnectorName())
						.connectorEmail(doc.getConnectorEmail())
						.connectorPassword(this.passwordEncoder().encode(doc.getConnectorPassword()))
						.connectorReEnterPassword(this.passwordEncoder().encode(doc.getConnectorReEnterPassword()))
						.connectorMobileNumber(doc.getConnectorMobileNumber())
						.connectorDateOfBirth(doc.getConnectorDateOfBirth())
						.connectorAlternateMobileNumber(doc.getConnectorAlternateMobileNumber())

						.documents(ConnectorDocuments.builder()
								.connectorCurrentAddress(doc.getDocuments().getConnectorCurrentAddress())
								.connectorPermanentAddress(doc.getDocuments().getConnectorPermanentAddress())

								.connectorAdharFileName(connectorAdhar.getOriginalFilename())

								.connectorPhotoFileName(connectorPhoto.getOriginalFilename())

								.connectorPanCardFileName(connectorPanCard.getOriginalFilename()).build())
						.build());

		// take file from source path and paste it to the destination path
		connectorPhoto.transferTo(new File(connector_Photo_FilePath));
		connectorAdhar.transferTo(new File(connector_Adhar_FilePath));
		connectorPanCard.transferTo(new File(connector_PanCard_FilePath));
		if (saveDocuments != null) {
			return "file uploaded successfully : ";
		} else {
			return "something went wrong";
		}
		}else {
			return "please enter the same password at the both places";
		}
	}
	

	
	
	/*
	public ConnectorRegistration findByData(ConnectorRegistration registration) {
		String connectorEmail=registration.getConnectorEmail();
		String connectorPassword=registration.getConnectorPassword();
		ConnectorRegistration con	=this.connectorRegRepo.findByconnectorEmailconnectorPassword(connectorEmail, connectorPassword);
		return con;
	}
	*/
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	

}