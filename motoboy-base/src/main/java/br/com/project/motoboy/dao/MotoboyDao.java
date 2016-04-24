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
public class MotoboyDao {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Motoboy motoboy) {
		manager.persist(motoboy);
	}

	public Motoboy localiza(Motoboy motoboy) {
		try {
			TypedQuery<Motoboy> query = manager.createQuery("from Motoboy m where m.email = :email and m.senha = :senha", Motoboy.class)
					.setParameter("email", motoboy.getEmail())
					.setParameter("senha", motoboy.getSenha());
			return (Motoboy) query.getSingleResult();
		} catch (Exception e) {
			return new Motoboy();
		}
	}
	
	public List<Motoboy> localizaTodos(Motoboy motoboy) {
		TypedQuery<Motoboy> query = manager.createQuery("from Motoboy order by nome", Motoboy.class);
		return (List<Motoboy>) query.getResultList();
	}
}
