package br.com.breno.store.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.breno.store.models.Livro;

public class LivroDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Livro livro) {
		manager.persist(livro);
	}

	public List<Livro> listar() {
		String jpql = "select distinct(l) from Livro l "
				+ " join fetch l.autores order by l.id";	
		
		return manager.createQuery(jpql,Livro.class).getResultList();
	}

	public List<Livro> ultimosLancamentos() {
		String jpql = "select l from Livro l order by l.dataPublicacao desc";
		return manager.createQuery(jpql, Livro.class)
				.setMaxResults(5)
				.getResultList();
	}

	public List<Livro> demaisLivros() {
		String jpql = "select l from Livro l order by l.dataPublicacao desc";
		return manager.createQuery(jpql, Livro.class)
				.setFirstResult(5)
				.getResultList();
	}

}
