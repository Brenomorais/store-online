package br.com.breno.store.service;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import br.com.breno.store.daos.CompraDao;
import br.com.breno.store.infra.MailSender;
import br.com.breno.store.models.Compra;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(
				propertyName = "destinationLookup",
				propertyValue = "java:/jms/topics/CarrinhoComprasTopico"),
		@ActivationConfigProperty(
				propertyName="destinationType",
				propertyValue="javax.jms.Topic")
})
public class EnviaEmailCompra implements MessageListener {

	@Inject
	private CompraDao compraDao;

	@Inject
	private MailSender mailSender;

	public void onMessage(Message message) {		

		try {
			TextMessage textMessage = (TextMessage) message;

			Compra compra;
			
			compra = compraDao.buscaPorUuid(textMessage.getText());

			String messageBody = "Sua compra foi realizada com sucesso," 
					+ "com número de pedido : " + compra.getUuid();

			mailSender.send("email@gmail.com", compra.getUsuario().getEmail(), 
					"Nova compra na House Code",messageBody);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
