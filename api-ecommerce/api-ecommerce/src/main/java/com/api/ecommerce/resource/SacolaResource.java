package com.api.ecommerce.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.dto.ItemDto;
import com.api.ecommerce.model.Item;
import com.api.ecommerce.model.Sacola;
import com.api.ecommerce.service.SacolaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ifood-community/sacolas")
@RequiredArgsConstructor
public class SacolaResource {
	
	private final SacolaService sacolaService;
	
	// Inserir um item na sacola
	@PostMapping
	public Item addItemSacola(@RequestBody ItemDto itemDto) {
		return sacolaService.addItemSacola(itemDto);
	}
	
	// Ver sacola
	@GetMapping("/{id}")
	public Sacola verSacola(@PathVariable("id") Long id) {
		return sacolaService.verSacola(id);
	}
	
	// Fechar sacola
	@PatchMapping("/fecharSacola/{idSacola}")
	public Sacola fecharSacola(@PathVariable("idSacola") Long idSacola, 
							   @RequestParam("formaPagamento") int formaPagamento) {
		
		return sacolaService.fecharSacola(idSacola, formaPagamento);
	}
}
