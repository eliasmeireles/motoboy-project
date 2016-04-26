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
		List<Cliente> c = manager.createQuery("from Cliente c where c.email = :email and c.senha = :senha", Cliente.class)
				.setParameter("email", cliente.getEmail()).setParameter("senha", cliente.getSenha()).getResultList();
		
		return c.size() > 0 ? c.get(0) : null;
	}

	public List<Cliente> localizaTodos() {
		return manager.createQuery("from Cliente", Cliente.class).getResultList();
	}

	public Cliente localizaPorEmail(String email) {
		TypedQuery<Cliente> query = manager.createQuery("from Cliente c where c.email = :email", Cliente.class).setParameter("email", email);
		
		List<Cliente> list = query.getResultList();
		
		return list.size() > 0 ? list.get(0) : null;
	}

	public Cliente localizaPorCpf(Cliente cliente) {
		TypedQuery<Cliente> query = manager.createQuery("from Cliente c where c.cpf = :cpf", Cliente.class)
				.setParameter("cpf", cliente.getCpf());
		
		List<Cliente> list = query.getResultList();
		
		return list.size() > 0 ? list.get(0) : null;
	}
}