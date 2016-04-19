package br.com.project.motoboy.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.project.motoboy.model.Cliente;

@Repository
@Transactional
public class ClienteDao {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Cliente cliente) {
		manager.persist(cliente);

	}

	public Cliente localiza(Cliente cliente) {

		TypedQuery<Cliente> query = manager.createQuery("from Cliente c where email = :pEmail", Cliente.class)
				.setParameter("pEmail", cliente.getEmail());
		return (Cliente) query.getSingleResult();
	}
}