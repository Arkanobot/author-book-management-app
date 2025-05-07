package com.example.demo;

import com.example.demo.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestConfig.class)
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
