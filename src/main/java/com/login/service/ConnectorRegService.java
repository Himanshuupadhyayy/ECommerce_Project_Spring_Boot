package com.login.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.login.models.ConnectorDocuments;
import com.login.models.ConnectorRegistration;
import com.login.repository.ConnectorRegRepo;

@Service
public class ConnectorRegService {

	@Autowired
	private ConnectorRegRepo connectorRegRepo;

	private String FOLDER_PATH = "C:\\Users\\Development\\All_Photos\\";

	public String createStudent(String connectorName, String connectorEmail, String connectorPassword,
			String connectorReEnterPassword, String connectorMobileNumber, String connectorDateOfBirth,
			String connectorAlternateMobileNumber, String connector_PermanentAddress, String connector_CurrentAddress,
			MultipartFile connectorPhoto, MultipartFile connectorAdhar, MultipartFile connectorPanCard)
			throws IOException {

		// get the fullly path of all files
		String connector_Photo_FilePath = FOLDER_PATH + connectorPhoto.getOriginalFilename();
		String connector_Adhar_FilePath = FOLDER_PATH + connectorAdhar.getOriginalFilename();
		String connector_PanCard_FilePath = FOLDER_PATH + connectorPanCard.getOriginalFilename();

		ConnectorRegistration saveDocuments = this.connectorRegRepo
				.save(ConnectorRegistration.builder().connectorName(connectorName).connectorEmail(connectorEmail)
						.connectorPassword(connectorPassword).connectorReEnterPassword(connectorReEnterPassword)
						.connectorMobileNumber(connectorMobileNumber).connectorDateOfBirth(connectorDateOfBirth)
						.connectorAlternateMobileNumber(connectorAlternateMobileNumber)

						.documents(ConnectorDocuments.builder().connector_CurrentAddress(connector_CurrentAddress)
								.connector_PermanentAddress(connector_PermanentAddress)

								.connector_Adhar_FileName(connectorPanCard.getOriginalFilename())

								.connector_Photo_FileName(connectorPhoto.getOriginalFilename())

								.connector_PanCard_FileName(connectorPanCard.getOriginalFilename()).build())
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
	}
}