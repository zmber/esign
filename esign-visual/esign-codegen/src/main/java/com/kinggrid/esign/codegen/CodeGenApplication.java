package com.kinggrid.esign.codegen;

import com.kinggrid.esign.common.datasource.annotation.EnableDynamicDataSource;
import com.kinggrid.esign.common.security.annotation.EnableEsignFeignClients;
import com.kinggrid.esign.common.security.annotation.EnableEsignResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 代码生成模块
 */
@EnableDynamicDataSource
@EnableEsignFeignClients
@SpringCloudApplication
@EnableEsignResourceServer
public class CodeGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeGenApplication.class, args);
	}

}
