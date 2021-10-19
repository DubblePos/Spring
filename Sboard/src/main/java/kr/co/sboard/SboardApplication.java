package kr.co.sboard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("kr.co.sboard.dao") // 제일먼저 실행되는거!!! 스캔하는거 mapper를 ... 
@SpringBootApplication
public class SboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SboardApplication.class, args);
	}

}
