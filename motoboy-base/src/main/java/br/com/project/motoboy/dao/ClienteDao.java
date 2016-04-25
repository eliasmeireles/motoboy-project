package br.com.project.motoboy.dao;

import java.util.ArrayList;
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

	public List<Cliente> localiza(Cliente cliente) {
		List<Cliente> clienteLista = new ArrayList<Cliente>();
		try {
			TypedQuery<Cliente> query = manager
					.createQuery("from Cliente c where c.email = :email and c.senha = :senha", Cliente.class)
					.setParameter("email", cliente.getEmail())
					.setParameter("senha", cliente.getSenha());
			
			clienteLista = query.getResultList();
			return clienteLista;
		} catch (Exception e) {
			return clienteLista;
		}
	}

	public List<Cliente> localizaTodos(Cliente cliente) {
		TypedQuery<Cliente> query = manager.createQuery("from Cliente", Cliente.class);
		return (List<Cliente>) query.getResultList();
	}

	public List<Cliente> localizaEmail(String email) {
		List<Cliente> clienteLista = new ArrayList<Cliente>();
		try {
			TypedQuery<Cliente> query = manager.createQuery("from Cliente c where c.email = :email", Cliente.class)
					.setParameter("email", email);

			clienteLista = query.getResultList();
			return clienteLista;
		} catch (Exception e) {
			return clienteLista;
		}
	}

	public List<Cliente> validaCpf(Cliente cliente) {
		List<Cliente> clienteLista = new ArrayList<Cliente>();
		try {
			TypedQuery<Cliente> query = manager.createQuery("from Cliente c where c.cpf = :cpf", Cliente.class)
					.setParameter("cpf", cliente.getCpf());
			clienteLista = query.getResultList();
			return clienteLista;
		} catch (Exception e) {
			return clienteLista;
		}
	}
}