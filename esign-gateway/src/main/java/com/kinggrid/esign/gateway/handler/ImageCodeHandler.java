package com.kinggrid.esign.gateway.handler;

import com.google.code.kaptcha.Producer;
import com.kinggrid.esign.common.core.constant.CommonConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DefaultDataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 验证码生成逻辑处理类
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ImageCodeHandler implements HandlerFunction<ServerResponse> {

	private final Producer producer;

	private final RedisTemplate redisTemplate;

	@Override
	public Mono<ServerResponse> handle(ServerRequest serverRequest) {
		final String randomStr = serverRequest.queryParam("randomStr").get();

		return ServerResponse.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG)
				.body(BodyInserters.fromDataBuffers(Mono.create(monoSink -> {
					try {
						byte[] bytes = createCodeImage(randomStr);
						DefaultDataBuffer dataBuffer = new DefaultDataBufferFactory().wrap(bytes);

						monoSink.success(dataBuffer);
					}
					catch (IOException e) {
						log.error("ImageIO write err", e);
						monoSink.error(e);
					}
				})));
	}

	private byte[] createCodeImage(String randomStr) throws IOException {
		// 生成验证码
		String text = producer.createText();
		BufferedImage image = producer.createImage(text);

		// 保存验证码信息
		redisTemplate.opsForValue().set(CommonConstants.DEFAULT_CODE_KEY + randomStr, text, 60, TimeUnit.SECONDS);

		// 转换流信息写出
		FastByteArrayOutputStream os = new FastByteArrayOutputStream();
		ImageIO.write(image, "jpeg", os);
		return os.toByteArray();
	}

}
