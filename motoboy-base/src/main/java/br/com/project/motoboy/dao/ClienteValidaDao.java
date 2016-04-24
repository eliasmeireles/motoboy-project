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
public class ClienteValidaDao {

	@PersistenceContext
	private EntityManager manager;
	
	public boolean validaEmail(Cliente cliente) {
		try {
			TypedQuery<Cliente> query = manager.createQuery("from Cliente c where c.email = :email", Cliente.class)
					.setParameter("email", cliente.getEmail());
			List<Cliente> c = query.getResultList();
			
			for (Cliente cliente2 : c) {
				System.out.println(cliente2);
			}
			
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean validaCpf(Cliente cliente) {
		try {
			manager.createQuery("from Cliente c where c.cpf = :cpf", Cliente.class)
					.setParameter("cpf", cliente.getEmail());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
