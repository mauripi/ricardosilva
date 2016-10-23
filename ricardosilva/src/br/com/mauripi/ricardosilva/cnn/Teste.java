package br.com.mauripi.ricardosilva.cnn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.mauripi.ricardosilva.modelo.Usuario;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ricardosilva");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();

		Usuario u = new Usuario();
		u.setAtivo(false);
		u.setNome("Mauricio Cruz");
		u.setUser("mauripi");
		u.setSenha("1234");
		u.setEmail("mauripi2005@hotmail.com");
		
		manager.persist(u);

        manager.getTransaction().commit();
        manager.close();
        factory.close();		
	}

}
