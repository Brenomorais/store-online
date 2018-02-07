package br.com.breno.store.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.breno.store.models.Livro;

public class LivroDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Livro livro) {
		manager.persist(livro);
	}

}
