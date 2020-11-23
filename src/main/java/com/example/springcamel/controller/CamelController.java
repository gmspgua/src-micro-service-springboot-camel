package com.example.springcamel.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcamel.model.Cidade;
import com.example.springcamel.model.Endereco;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CamelController {
	
	final static String CAMEL_START_URI ="direct:start";
	//@Autowired
	//ProducerTemplate producerTemplate;
	
	@Autowired
	@EndpointInject(uri=CAMEL_START_URI)
	ProducerTemplate producerTemplate;
	
	@Autowired
	CamelContext camelContext;
	
	@Autowired
	ObjectMapper mapper;
	

	@RequestMapping(value = "/endereco", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> startCamel(@RequestBody Cidade cidade) throws Exception {
		 producerTemplate.sendBody("direct:start", cidade.getCep());
		 
		 return ResponseEntity.ok("Hello World!");
	}
	

		
			/*
			 * Exchange sendExchange =
			 * ExchangeBuilder.anExchange(camelContext).withBody(cidade.getCep()).build();
			 * Exchange outExchange = producerTemplate.send(sendExchange); Endereco endereco
			 * = outExchange.getMessage().getBody(Endereco.class); try { return
			 * mapper.writeValueAsString(endereco); } catch (JsonProcessingException e) {
			 * e.printStackTrace(); } return "";
			 */
}
	

	

 	
		
		