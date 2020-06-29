package com.kinggrid.esign.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kinggrid.esign.common.security.component.EsignAuth2ExceptionSerializer;

@JsonSerialize(using = EsignAuth2ExceptionSerializer.class)
public class InvalidException extends EsignAuth2Exception {

	public InvalidException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "invalid_exception";
	}

	@Override
	public int getHttpErrorCode() {
		return 426;
	}

}
