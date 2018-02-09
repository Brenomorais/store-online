package br.com.breno.store.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.breno.store.daos.LivroDao;
import br.com.breno.store.models.Livro;

@Model
public class AdminListaLivrosBean {
	
	@Inject
	private LivroDao livroDao;
	
	private List<Livro> livros = new ArrayList<>();	
	

	public List<Livro> getLivros() {
		this.livros = livroDao.listar();
		return livros;
	}	

}
