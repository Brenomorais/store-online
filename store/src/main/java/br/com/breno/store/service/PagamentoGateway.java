package br.com.breno.store.service;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import br.com.breno.store.models.Pagamento;

public class PagamentoGateway  implements Serializable{
		
	private static final long serialVersionUID = 1L;

	public String pagar(BigDecimal total) {
		Client client = ClientBuilder.newClient();
		Pagamento pagamento = new Pagamento(total);
		String target = "https://book-payment.herokuapp.com/payment";
		
		return  client.target(target).request().post(Entity.json(pagamento), String.class);		
	}
}
