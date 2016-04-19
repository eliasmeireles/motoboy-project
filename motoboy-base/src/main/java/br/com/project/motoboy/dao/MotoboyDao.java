package br.com.project.motoboy.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.project.motoboy.model.Motoboy;

@Repository
@Transactional
public class MotoboyDao {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Motoboy motoboy) {
		manager.persist(motoboy);

	}

	public Motoboy localiza(Motoboy motoboy) {
		TypedQuery<Motoboy> query = manager.createQuery("from Motoboy m where email = :pEmail", Motoboy.class)
				.setParameter("pEmail", motoboy.getEmail());
		return query.getSingleResult();
	}
}
