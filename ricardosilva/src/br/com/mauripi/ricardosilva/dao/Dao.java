package br.com.mauripi.ricardosilva.dao;

public interface Dao {
	public <T> void adiciona(T t);
	public <T> void atualiza(T t);
	public <T> void exclui(T t);
}
