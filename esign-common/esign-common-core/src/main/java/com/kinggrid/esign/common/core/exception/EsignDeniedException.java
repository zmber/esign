package com.kinggrid.esign.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * 授权拒绝
 */
@NoArgsConstructor
public class EsignDeniedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EsignDeniedException(String message) {
		super(message);
	}

	public EsignDeniedException(Throwable cause) {
		super(cause);
	}

	public EsignDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public EsignDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
