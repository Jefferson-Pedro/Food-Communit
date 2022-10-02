package com.api.ecommerce.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor //Construtor c/ parametros
@NoArgsConstructor	//Construtor s/ parametros
@Data				//Trás os Gets e Sets, Equals e Hashmaps
@Builder
@Embeddable
public class Endereco {
	
	private String cep;
	private String complemento;
}
