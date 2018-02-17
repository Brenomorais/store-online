package br.com.breno.store.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CarrinhoCompras {
	
	private Set<CarrinhoItem> itens =
			new HashSet<>();
	
	public void adicionar(CarrinhoItem item) {
		itens.add(item);
	}

	public List<CarrinhoItem> getItens() {		
		return new ArrayList<CarrinhoItem>(itens);
	}
}
