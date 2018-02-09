package br.com.breno.store.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.breno.store.daos.AutorDao;
import br.com.breno.store.daos.LivroDao;
import br.com.breno.store.models.Autor;
import br.com.breno.store.models.Livro;

//CDI
@Named
@RequestScoped
public class AdminLivrosBean {
	
	private Livro livro = new Livro();	
	
	@Inject
	private LivroDao livroDao;
	
	@Inject 
	private AutorDao autorDao;
	
	private List<Integer> autoresId = new ArrayList<>();;
	
	public void limparCampos() {
		this.livro = new Livro();
		this.autoresId = new ArrayList<>();
	}

	@Transactional
	public void salvar() {
		for(Integer autorId : autoresId) {
			livro.getAutores().add(new Autor(autorId));
		}
		
		livroDao.salvar(livro);		
		
		System.out.println("Livro salvo com sucesso! "+livro+" - Autor: "+autoresId);
		
		limparCampos();
	}

	public List<Autor> getAutores(){
		return  autorDao.listar();
		
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Integer> getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}
	
	

}
