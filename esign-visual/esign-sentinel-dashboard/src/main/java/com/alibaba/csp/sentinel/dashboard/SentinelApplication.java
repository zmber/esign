package com.alibaba.csp.sentinel.dashboard;

import com.alibaba.csp.sentinel.init.InitExecutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author nacos
 * <p>
 * sentinel console 源码运行，方便开发 生产建议从官网下载最新版配置运行
 */
@SpringBootApplication
public class SentinelApplication {

	public static void main(String[] args) {
		triggerSentinelInit();
		SpringApplication.run(SentinelApplication.class, args);
	}

	private static void triggerSentinelInit() {
		new Thread(InitExecutor::doInit).start();
	}

}
