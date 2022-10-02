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
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Produto produto;
	private int quantidade;
	
	@ManyToOne
	@JsonIgnore
	private Sacola sacola;
}
