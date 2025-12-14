package com.example.Livrarias.controller;

import java.net.URI;
import java.util.UUID;

import org.hibernate.dialect.VarcharUUIDJdbcType;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.Servlet;

public interface GenericControllers {
default URI gerarHeaderLocation(UUID id) {
	return ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(id)
			.toUri();
}
}
