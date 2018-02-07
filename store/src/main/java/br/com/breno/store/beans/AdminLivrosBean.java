package br.com.breno.store.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.breno.store.models.Livro;

//CDI
@Named
@RequestScoped
public class AdminLivrosBean {
	
	private Livro livro = new Livro();
	
	public void salvar() {		
		System.out.println("Livro salvo com sucesso! "+livro);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
