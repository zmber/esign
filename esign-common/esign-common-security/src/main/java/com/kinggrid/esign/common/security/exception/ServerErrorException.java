package com.kinggrid.esign.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kinggrid.esign.common.security.component.EsignAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

@JsonSerialize(using = EsignAuth2ExceptionSerializer.class)
public class ServerErrorException extends EsignAuth2Exception {

	public ServerErrorException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "server_error";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

}
