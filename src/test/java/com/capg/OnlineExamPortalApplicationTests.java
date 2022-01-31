package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.model.AdminLogin;
import com.capg.repository.AdminRepository;
import com.capg.service.AdminService;


//@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineExamPortalApplicationTests {
	
	@Autowired
	private AdminService service;

	@MockBean
	private AdminRepository repository;

	//fetchAdmin by id
	
	@Test
	public void getAdminByCity() {
		int admin_id = 49;
		when(repository.findById(admin_id));
			//	.thenReturn(Stream.of(new AdminLogin(49,"Aishwarya", "bangalore", "ash@gmail.com")).collect(Collectors.toList()));

		assertEquals(1, service.findByAdminId(admin_id));
		
	}
	
	
	
}

	
