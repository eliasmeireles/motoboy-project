package br.com.project.motoboy.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	public Moto localiza(Moto moto) {

		TypedQuery<Moto> query = manager.createQuery("from Moto m where m.cliente_id = :pCliente_id", Moto.class)
				.setParameter("pEmail", moto.getCliente_id());
		return (Moto) query.getSingleResult();
	}
}
