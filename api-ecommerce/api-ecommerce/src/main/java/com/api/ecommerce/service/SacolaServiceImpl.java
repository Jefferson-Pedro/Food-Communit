package com.api.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.ecommerce.dto.ItemDto;
import com.api.ecommerce.enumeration.FormaPagamento;
import com.api.ecommerce.model.Item;
import com.api.ecommerce.model.Restaurante;
import com.api.ecommerce.model.Sacola;
import com.api.ecommerce.repository.ItemRepository;
import com.api.ecommerce.repository.ProdutoRepository;
import com.api.ecommerce.repository.SacolaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SacolaServiceImpl implements SacolaService {
	
	private final SacolaRepository sacolaRepository;
	private final ProdutoRepository produtoRepository;
	private final ItemRepository itemrepository;
	private Sacola sacola;
	
	
	@Override
	public Item addItemSacola(ItemDto itemDto) {
		
		Sacola sacola = verSacola(itemDto.getIdSacola());
		
		if(sacola.isFechada()) {
			throw new RuntimeException("Esta sacola está fechada!");
		}
		
		Item itemParaInserir = Item.builder()
		.quantidade(itemDto.getQuantidade())
		.sacola(sacola)
		.produto(produtoRepository.findById(itemDto.getIdProduto()).orElseThrow(
				
				() -> {	throw new RuntimeException("Este produto não existe!");	}
				
		)).build();
		
		List<Item> itensDaSacola =  sacola.getItens();
		if(itensDaSacola.isEmpty()) {
			itensDaSacola.add(itemParaInserir);
		}else {
			Restaurante restauranteAtual = itensDaSacola.get(0).getProduto().getRestaurante();
			Restaurante restauranteDoItemParaAdd = itemParaInserir.getProduto().getRestaurante();
			if(restauranteAtual.equals(restauranteDoItemParaAdd)) {
				itensDaSacola.add(itemParaInserir);
			}else {
				throw new RuntimeException("Não é possivel adicionar produtos de restaurantes diferentes. "
						+ "Encerre ou limpe o seu pedido!");
			}			
		}
		
		List<Double> valorDosItens = new ArrayList<>();
		for(Item itemDaSacola: itensDaSacola) {
			double valorTotalItem = itemDaSacola.getProduto().getValorUnitario() * itemDaSacola.getQuantidade();
			valorDosItens.add(valorTotalItem);
		}
		
		double valorTotalSacola = valorDosItens.stream()
		.mapToDouble(valorTotalDeCadaItem -> valorTotalDeCadaItem)
		.sum();
		
		sacola.setValorTotal(valorTotalSacola);		
		sacolaRepository.save(sacola);	
		//return itemrepository.save(itemParaInserir);
		return itemParaInserir;
	}

	@Override
	public Sacola verSacola(Long id) {
		
		return sacolaRepository.findById(id).orElseThrow(
			() -> {
				throw new RuntimeException("Essa sacola não existe!");
		}
	  );
	}

	@Override
	public Sacola fecharSacola(Long id, int formaPagamento) {
		
		sacola = verSacola(id);
		
		if(sacola.getItens().isEmpty()) {
			throw new RuntimeException("Inclua itens na sacola!");
		}
		
		FormaPagamento formaDePagamento = formaPagamento == 0 ? FormaPagamento.DINHEIRO:
			FormaPagamento.MAQUINA;
		
		sacola.setFormaPagamento(formaDePagamento);
		sacola.setFechada(true);
		
		return sacolaRepository.save(sacola);
		
	}

	

}
