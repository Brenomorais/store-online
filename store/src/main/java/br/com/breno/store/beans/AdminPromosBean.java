package br.com.breno.store.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.breno.store.models.Promo;
import br.com.breno.store.websockets.PromosEndpoint;


@Model
public class AdminPromosBean {

	private Promo promo = new Promo();

	@Inject
	private PromosEndpoint promos;
	
	public void enviar() {
		promos.send(promo);	
		this.promo = new Promo();
	}
	
	public Promo getPromo() {
		return promo;
	}

	public void setPromo(Promo promo) {
		this.promo = promo;
	}
}