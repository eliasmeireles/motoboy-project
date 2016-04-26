package br.com.project.motoboy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.project.motoboy.model.Moto;

@Repository
@Transactional
public class MotoDao {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Moto moto) {
		manager.persist(moto);
	}

	public List<Moto> localiza(Moto moto) {
		return manager.createQuery("from Moto m where m.motoboy_id = :pMotoboy_id", Moto.class)
				.setParameter("pEmail", moto.getMotoboy_id()).getResultList();
	}

	public List<Moto> localizaTodos() {
		return manager.createQuery("from Moto", Moto.class).getResultList();
	}
}
