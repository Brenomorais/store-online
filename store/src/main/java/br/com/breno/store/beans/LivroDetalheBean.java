package br.com.breno.store.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.breno.store.daos.LivroDao;
import br.com.breno.store.models.Livro;

@Model
public class LivroDetalheBean {
	
	@Inject
	private LivroDao livroDao;
	
	private Livro livro;
	
	private Integer id;
	
	public void carregaDetalhe() {
		this.livro = livroDao.buscarPorId(id);
	}	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	

}
