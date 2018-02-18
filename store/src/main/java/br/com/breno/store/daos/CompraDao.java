package br.com.breno.store.daos;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.breno.store.models.Compra;

public class CompraDao implements Serializable{
	
	private static final long serialVersionUID = -3007761796745298670L;
	
	@PersistenceContext
	private EntityManager manager;	

    public void salvar(Compra compra) {
        manager.persist(compra);
    }

}
