package com.login.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.login.models.ConnectorDocuments;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConnectorRegDto {

	
	private int connectorId;
	@NotEmpty
	private String connectorName;
	@Email
	private String connectorEmail;
	@NotEmpty
	private String connectorPassword;
	@NotEmpty
	private String connectorReEnterPassword;
	@NotEmpty
	private String connectorMobileNumber;
	@NotEmpty
	private String connectorDateOfBirth;
	@NotEmpty
	private String connectorAlternateMobileNumber;

	private ConnectorDocuments documents;
}