package com.ranjit.blogger;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ranjit.blogger.controller.UserController;
import com.ranjit.blogger.dto.Users;
import com.ranjit.blogger.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class JUnit5Test {

	@ParameterizedTest
	@ValueSource(strings = { "cali", "bali", "dani" })
	void endsWithI(String str) {
		// System.out.println("STr:" + str);
		assertTrue(str.endsWith("i"));
	}

	@RepeatedTest(1)
	public void repeatedTest() {
		// System.out.println("Ranjit..");
	}

	@BeforeEach
	public void beforeEachtTest() {
		System.out.println("BeforeEach....");
	}

	@BeforeAll
	public static void beforeAllTest() {
		System.out.println("Before All....");
	}
}
