package com.kinggrid.esign.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kinggrid.esign.common.security.component.EsignAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

@JsonSerialize(using = EsignAuth2ExceptionSerializer.class)
public class UnauthorizedException extends EsignAuth2Exception {

	public UnauthorizedException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "unauthorized";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.UNAUTHORIZED.value();
	}

}
