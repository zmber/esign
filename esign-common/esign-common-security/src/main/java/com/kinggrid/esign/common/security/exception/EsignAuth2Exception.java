package com.kinggrid.esign.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kinggrid.esign.common.security.component.EsignAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 自定义OAuth2Exception
 */
@JsonSerialize(using = EsignAuth2ExceptionSerializer.class)
public class EsignAuth2Exception extends OAuth2Exception {

	@Getter
	private String errorCode;

	public EsignAuth2Exception(String msg) {
		super(msg);
	}

	public EsignAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}

}
