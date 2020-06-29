package com.kinggrid.esign.admin;

import com.kinggrid.esign.common.security.annotation.EnableEsignFeignClients;
import com.kinggrid.esign.common.security.annotation.EnableEsignResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 *  用户统一管理系统
 */
@EnableEsignResourceServer
@EnableEsignFeignClients
@SpringCloudApplication
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}
