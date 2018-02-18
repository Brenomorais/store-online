package br.com.breno.store.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.breno.store.daos.UsuarioDao;
import br.com.breno.store.models.Usuario;

@Model
public class CheckoutBean {
	
	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Transactional
	public void finalizar() {		
		usuarioDao.salvar(usuario);
		limpar();
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void limpar() {
		this.usuario = new Usuario();
	}
	

}
