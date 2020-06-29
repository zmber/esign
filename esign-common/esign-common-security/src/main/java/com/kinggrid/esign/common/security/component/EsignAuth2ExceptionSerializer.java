package com.kinggrid.esign.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.kinggrid.esign.common.core.constant.CommonConstants;
import com.kinggrid.esign.common.security.exception.EsignAuth2Exception;
import lombok.SneakyThrows;

/**
 * OAuth2 异常格式化
 */
public class EsignAuth2ExceptionSerializer extends StdSerializer<EsignAuth2Exception> {

	public EsignAuth2ExceptionSerializer() {
		super(EsignAuth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(EsignAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
		gen.writeStartObject();
		gen.writeObjectField("code", CommonConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}

}
