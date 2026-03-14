package com.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateConnection {
	private static final EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("Tom");
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static void close() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}

	public static void closeFactory() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}

}
