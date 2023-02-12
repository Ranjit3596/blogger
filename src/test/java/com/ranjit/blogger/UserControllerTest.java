package com.ranjit.blogger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.ranjit.blogger.Exception.ResourceNotFoundException;
import com.ranjit.blogger.dto.Users;
import com.ranjit.blogger.entity.UsersEntity;
import com.ranjit.blogger.repository.UserRepository;
import com.ranjit.blogger.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserControllerTest {


	List<UsersEntity> listOfUsers = new ArrayList<UsersEntity>();
	UsersEntity user_1 = new UsersEntity(1, "Testing", "ranjit@gmail.com", "Ranjit", "ranjit@123");
	UsersEntity user_2 = new UsersEntity(1, "Testing", "ranjit@gmail.com", "Ranjit", "ranjit@123");
	UsersEntity user_3 = new UsersEntity(1, "Testing", "ranjit@gmail.com", "Ranjit", "ranjit@123");
	UsersEntity user_4 = new UsersEntity(1, "Testing", "ranjit@gmail.com", "Ranjit", "ranjit@123");

	@Mock
	UserRepository userRepo;

    @InjectMocks
    UserServiceImpl userService;
    
    @Spy
    ModelMapper mapper;

	@Test
	public void test_getAllUser() {

		Mockito.when(userRepo.findAll()).thenReturn(listOfUsers);
		assertEquals(listOfUsers.size(), userService.getAllUsers().size());
	}
	
	@ParameterizedTest
	@ValueSource(ints= {1})
	public void test_getUserById(Integer id) {
		 UsersEntity userEntity = new UsersEntity(1, "Testing", "abc@123", "ranjit", "Ranjit@123");
		 Optional<UsersEntity> ue = Optional.ofNullable(userEntity);
		 when(userRepo.findById(id)).thenReturn(ue);
		 assertEquals(ue.get().getUserid(), userService.getUserById(id).getUserid());
	}

	@BeforeAll
	public static void setup() {
		//mapper = new ModelMapper();
	}
}
