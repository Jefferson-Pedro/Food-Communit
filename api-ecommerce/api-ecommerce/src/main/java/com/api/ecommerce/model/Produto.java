package com.api.ecommerce.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor //Construtor c/ parametros
@NoArgsConstructor	//Construtor s/ parametros
@Data				//Trás os Gets e Sets, Equals e Hashmaps
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private Double valorUnitario;
	
	@Builder.Default
	private Boolean disponivel = true;
	
	@ManyToOne
	@JsonIgnore
	private Restaurante restaurante;
}
