package br.com.project.motoboy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		List<Motoboy> m = manager.createQuery("from Motoboy m where m.email = :email and m.senha = :senha", Motoboy.class)
				.setParameter("email", motoboy.getEmail()).setParameter("senha", motoboy.getSenha()).getResultList();
		
		return m.size() > 0 ? m.get(0) : null;
	}

	public List<Motoboy> localizaTodos() {
		return manager.createQuery("from Motoboy order by nome", Motoboy.class).getResultList();
	}

	public List<Motoboy> motoboyEmail(String email) {
		return manager.createQuery("from Motoboy c where c.email = :email", Motoboy.class).setParameter("email", email)
				.getResultList();
	}

	public List<Motoboy> motoboyCpf(String cpf) {
		return manager.createQuery("from Motoboy c where c.cpf = :cpf", Motoboy.class).setParameter("cpf", cpf)
				.getResultList();
	}

}
