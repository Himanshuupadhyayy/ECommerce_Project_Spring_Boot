package com.login.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConnectorDocuments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int documentId;
	
	private String connector_PermanentAddress;
	private String connector_CurrentAddress;
	
	private String connector_Photo_FileName;	

	private String connector_Adhar_FileName;

	private String connector_PanCard_FileName;
	
	@OneToOne(mappedBy = "documents")
	@JsonIgnore
	private ConnectorRegistration connectorRegistration;
}
