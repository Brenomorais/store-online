package br.com.breno.store.beans;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import br.com.breno.store.models.CarrinhoCompras;
import br.com.breno.store.models.Compra;
import br.com.breno.store.models.Usuario;

@Model
public class CheckoutBean {

	private Usuario usuario = new Usuario();

	@Inject
	private CarrinhoCompras carrinho;

	@Inject
	private FacesContext facesContext;
	
	@Transactional
	public void finalizar() {
		Compra compra = new Compra();
		compra.setUsuario(usuario);
		carrinho.finalizar(compra);
		
		String contextName = facesContext.getExternalContext().getRequestContextPath();
		HttpServletResponse response = (HttpServletResponse) 
				facesContext.getExternalContext().getResponse();
		
		response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT); //redirect temporario
		response.setHeader("Location", contextName +"/"+ "services/pagamento?uuid="+compra.getUuid());		
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
