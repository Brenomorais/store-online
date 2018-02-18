package br.com.breno.store.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.breno.store.models.CarrinhoCompras;
import br.com.breno.store.models.Usuario;

@Model
public class CheckoutBean {

	private Usuario usuario = new Usuario();

	@Inject
	private CarrinhoCompras carrinho;

	@Transactional
	public String finalizar() {
		carrinho.finalizar(usuario);		
		return "index?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public CarrinhoCompras getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoCompras carrinho) {
		this.carrinho = carrinho;		
	}

}
