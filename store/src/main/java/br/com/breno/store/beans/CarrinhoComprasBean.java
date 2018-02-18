package br.com.breno.store.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.breno.store.daos.LivroDao;
import br.com.breno.store.models.CarrinhoCompras;
import br.com.breno.store.models.CarrinhoItem;
import br.com.breno.store.models.Livro;

@Model
public class CarrinhoComprasBean {

    @Inject
    private LivroDao livroDao;

    @Inject
    private CarrinhoCompras carrinho;

    public String adicionaItemCarrinho(Integer id) {
        Livro livro = livroDao.buscarPorId(id);
        CarrinhoItem item = new CarrinhoItem(livro);
        carrinho.adicionar(item);        
       
        return "carrinho?faces-redirect=true";
    }  
    
    public void removeItemCarrinho(CarrinhoItem item) {
    	carrinho.remover(item);    	   	
    }
    
}
