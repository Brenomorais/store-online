package br.com.breno.store.conf;

import javax.ejb.Singleton;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;

@JMSDestinationDefinitions({
	@JMSDestinationDefinition(
		name="java:/jms/topics/CarrinhoComprasTopico",
		interfaceName="jaxa.jms.Topic",
		destinationName="java:/jms/topics/CarrinhoComprasTopico"
	)
})
@Singleton
public class ConfigureJMSDestination {

}
