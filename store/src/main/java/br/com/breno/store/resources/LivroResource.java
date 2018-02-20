package br.com.breno.store.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.breno.store.daos.LivroDao;
import br.com.breno.store.models.Livro;

@Path("livros")
public class LivroResource {
	
	@Inject
	private LivroDao livroDao;
	
	@GET
	@Path("json")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Livro> ultimosLancamentosJson() {
		return livroDao.ultimosLancamentos();
	}
	
	@GET
	@Path("xml")
	@Produces({MediaType.APPLICATION_XML})
	public List<Livro> ultimosLancamentosXml() {
		return livroDao.ultimosLancamentos();
	}

}
