package com.api.ecommerce.dto;

import javax.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@Builder
@Data
@Embeddable
@NoArgsConstructor
public class ItemDto {
	private Long idProduto;
	private int quantidade;
	private Long idSacola;
}
