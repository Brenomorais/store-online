package br.com.breno.store.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.breno.store.models.Livro;

//@Stateful usado para resolver lazy sem precisar usar query planeded 
public class LivroDao {
	
	//@PersistenceContext(type=PersistenceContextType.EXTENDED)
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

	public Livro buscarPorId(Integer id) {
		
		//realiza um queru para o livro e query para o autor(s)
		//return manager.find(Livro.class, id);

		//planed query planejada fetch para evitar lazy 
		String jpql = "select distinct(l) from Livro l "
				+ " join fetch l.autores where l.id = :id";					
		return manager.createQuery(jpql, Livro.class)
				.setParameter("id",id)				
				.getSingleResult();
	}

}
