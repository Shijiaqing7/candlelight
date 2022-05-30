package com.shi.candlelight;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
@Slf4j
@SpringBootApplication
@MapperScan("com.shi.candlelight.mapper")
public class CandlelightApplication {
	private static final Logger LOG = LoggerFactory.getLogger(CandlelightApplication.class);


	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CandlelightApplication.class);
		Environment env = app.run(args).getEnvironment();
		LOG.info("启动成功！！");
		LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
	}

}
