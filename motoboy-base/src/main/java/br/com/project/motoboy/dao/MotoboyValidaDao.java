package br.com.project.motoboy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.project.motoboy.model.Motoboy;

@Repository
@Transactional
public class MotoboyValidaDao {

	@PersistenceContext
	private EntityManager manager;

	public boolean validaEmail(Motoboy motoboy) {
		try {
			TypedQuery<Motoboy> query = manager.createQuery("from Motoboy c where c.email = :email", Motoboy.class)
					.setParameter("email", motoboy.getEmail());
			return validaMotoboy(query);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validaCpf(Motoboy motoboy) {
		try {
			TypedQuery<Motoboy> query = manager.createQuery("from Motoboy c where c.cpf = :cpf", Motoboy.class)
					.setParameter("cpf", motoboy.getCpf());
			return validaMotoboy(query);
		} catch (Exception e) {
			return false;
		}
	}

	private boolean validaMotoboy(TypedQuery<Motoboy> query) {
		List<Motoboy> c = query.getResultList();
		if (c.size() == 0) {
			return false;
		}
		return true;
	}

}
