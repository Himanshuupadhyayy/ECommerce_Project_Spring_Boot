package com.login.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConnectorRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int connectorId;
	private String connectorName;
	private String connectorEmail;
	private String connectorPassword;
	private String connectorReEnterPassword;
	private String connectorMobileNumber;
	private String connectorDateOfBirth;
	private String connectorAlternateMobileNumber;
	
	@CreationTimestamp
	private LocalDateTime regDateTime;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "document_id")
	private ConnectorDocuments documents;
	
}