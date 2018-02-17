package br.com.breno.store.models;

import java.util.HashSet;
import java.util.Set;


public class CarrinhoCompras {
	
	private Set<CarrinhoItem> itens =
			new HashSet<>();
	
	public void adicionar(CarrinhoItem item) {
		itens.add(item);
	}
}
