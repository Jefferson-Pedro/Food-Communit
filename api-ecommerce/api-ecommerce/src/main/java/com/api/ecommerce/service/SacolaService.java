package com.api.ecommerce.service;

import com.api.ecommerce.dto.ItemDto;
import com.api.ecommerce.model.Item;
import com.api.ecommerce.model.Sacola;

public interface SacolaService {
	//ver sacola
	public Sacola verSacola(Long id);
	//fechar sacola
	public Sacola fecharSacola(Long id, int formaPagamento);
	//Inserir um item na sacola
	public Item addItemSacola(ItemDto itemDto); 
}
