package br.com.mauripi.ricardosilva.cnn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	
	public static EntityManager getEntityManager(){
		factory = Persistence.createEntityManagerFactory("ricardosilva");
		manager = factory.createEntityManager();		
		
		return manager;		
	}
	
	public static void closeEntityManager(){
        manager.close();
        factory.close();
	}
}
