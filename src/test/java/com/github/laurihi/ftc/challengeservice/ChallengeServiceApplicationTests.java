package com.github.laurihi.ftc.challengeservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeServiceApplicationTests {


	@Test
	public void contextLoads() {
	}

}
