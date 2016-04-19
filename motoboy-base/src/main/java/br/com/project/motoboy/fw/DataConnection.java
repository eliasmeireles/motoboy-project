package br.com.project.motoboy.fw;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataConnection {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fast_motoboy");

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
