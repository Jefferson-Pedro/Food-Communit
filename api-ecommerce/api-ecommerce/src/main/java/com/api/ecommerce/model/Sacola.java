package com.api.ecommerce.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import com.api.ecommerce.enumeration.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor //Construtor c/ parametros
@NoArgsConstructor	//Construtor s/ parametros
@Data				//Trás os Gets e Sets, Equals e Hashmaps
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
@Entity
public class Sacola {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> itens;
	
	private Double valortotal;
	
	@Enumerated
	private FormaPagamento formaPagamento;
	private boolean fechada;
	
	
		
}
