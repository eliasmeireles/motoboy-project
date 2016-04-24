package br.com.project.motoboy.dao;

import java.util.List;

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
		try {
			TypedQuery<Cliente> query = manager.createQuery("from Cliente c where c.email = :email and c.senha = :senha", Cliente.class)
					.setParameter("email", cliente.getEmail())
					.setParameter("senha", cliente.getSenha());
			return (Cliente) query.getSingleResult();
		} catch (Exception e) {
			return new Cliente();
		}
	}
	public List<Cliente> localizaTodos(Cliente cliente) {
		TypedQuery<Cliente> query = manager.createQuery("from Cliente", Cliente.class);
		return (List<Cliente>) query.getResultList();
	}
}