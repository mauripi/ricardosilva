package br.com.mauripi.ricardosilva.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mauripi.ricardosilva.modelo.Tarefa;

public class TarefaDAO {
	private EntityManager manager;
	
	public TarefaDAO(EntityManager manager) {
		this.manager=manager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> lista(){
		return manager.createQuery("From tarefa").getResultList();		
	}
}
