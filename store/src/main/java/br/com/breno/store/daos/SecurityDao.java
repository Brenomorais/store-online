package br.com.breno.store.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.breno.store.models.SystemUser;

public class SecurityDao {

	@PersistenceContext
	private EntityManager manager;

	public SystemUser findByEmail(String login) {
		return manager.createQuery("select su from SystemUser su "
				+ "where su.login = :login", SystemUser.class)
					.setParameter("login", login)
					.getSingleResult();
	}

}
