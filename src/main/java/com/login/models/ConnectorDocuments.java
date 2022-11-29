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
	
	private String connectorPermanentAddress;
	private String connectorCurrentAddress;
	
	private String connectorPhotoFileName;	

	private String connectorAdharFileName;

	private String connectorPanCardFileName;
	
	@OneToOne(mappedBy = "documents")
	@JsonIgnore
	private ConnectorRegistration connectorRegistration;
}
