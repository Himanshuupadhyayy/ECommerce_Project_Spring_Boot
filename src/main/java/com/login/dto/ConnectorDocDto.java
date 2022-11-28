package com.login.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConnectorDocDto {

	private int documentId;
	@NotEmpty
	private String connector_PermanentAddress;
	@NotEmpty
	private String connector_CurrentAddress;
		
	private String connector_Photo_FileName;	

	private String connector_Adhar_FileName;

	private String connector_PanCard_FileName;

}
