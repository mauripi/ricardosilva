package br.com.mauripi.ricardosilva.dao;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class GenericDAO implements Dao{
	private EntityManager manager;
	
	public GenericDAO(EntityManager manager) {
		this.manager=manager;
	}

	@Override
	public <T> void adiciona(T t) {		
		manager.persist(t);	
	}

	@Override
	public <T> void atualiza(T t) {
		manager.merge(t);		
	}

	@Override
	public <T> void exclui(T t) {
		manager.remove(t);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> T findById(Class classe, Object id){
		try{
			Field[] fields = classe.getDeclaredFields();
			String chave = "";
			for(Field field: fields){
				if(field.getAnnotation(Id.class)!= null){
					chave = field.getName();
					break;
				}			
			}
			Query query = this.manager.createQuery(" From "+classe.getName() + " Where "+ chave + " = :id");
			query.setParameter("id", id);
			query.setMaxResults(1);
			return (T) query.getSingleResult();		
		}catch(PersistenceException e){
			System.out.println("Erro: "+e.getLocalizedMessage()+"  em: GenericDao<T>.findById(Class classe, Object id) "+classe.getName() );
			return null;
		}
	}
}
