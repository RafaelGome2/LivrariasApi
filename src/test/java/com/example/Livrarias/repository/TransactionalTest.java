package com.example.Livrarias.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.Livrarias.service.TransactionalService;

@SpringBootTest
public class TransactionalTest {
	@Autowired
	TransactionalService transactionalService;
	
	@Test
public void transaçaoSimples() {
 transactionalService.executar();	
}
	}
	 

