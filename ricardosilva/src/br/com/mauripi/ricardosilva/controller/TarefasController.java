package br.com.mauripi.ricardosilva.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.mauripi.ricardosilva.cnn.Conexao;
import br.com.mauripi.ricardosilva.dao.GenericDAO;
import br.com.mauripi.ricardosilva.dao.TarefaDAO;
import br.com.mauripi.ricardosilva.modelo.Tarefa;

@Controller
public class TarefasController {
	  private EntityManager manager;
	
	  @RequestMapping("novaTarefa")
	  public String form() {
	    return "tarefa/formulario";
	  }
	  
	  @RequestMapping("adicionaTarefa")
	  public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
	
		  if(result.hasFieldErrors("descricao")) {
			  return "tarefa/formulario";
		  }else{
			  GenericDAO dao = new GenericDAO(abrirConexao());	
			  tarefa.setFinalizado(false);
			  dao.adiciona(tarefa);
			  fecharConexao();
			  return "redirect:listaTarefas";
		  }
	  }
	  
	  @RequestMapping("alteraTarefa")
	  public String altera(Tarefa tarefa) {
		  GenericDAO dao = new GenericDAO(abrirConexao());

		  dao.atualiza(tarefa);
		  fecharConexao();
		  return "redirect:listaTarefas";
	  }
	  
	  @RequestMapping("mostraTarefa")
	  public String mostra(int id, Model model) {
		  GenericDAO dao = new GenericDAO(abrirConexao());	
	      model.addAttribute("tarefa", dao.findById(Tarefa.class, id));
	      fecharConexao();
	      return "tarefa/mostra";
	  }
	  
	  @RequestMapping("removeTarefa")
	  public String remove(Tarefa tarefa) {
		GenericDAO dao = new GenericDAO(abrirConexao());
	    dao.exclui(dao.findById(Tarefa.class, tarefa.getId()));
	    fecharConexao();
	    return "redirect:listaTarefas";
	  }
	  
	  @RequestMapping("listaTarefas")
	  public String lista(Model model) {
		  TarefaDAO dao = new TarefaDAO(abrirConexao());
		  List<Tarefa> tarefas = dao.lista(); 
		  fecharConexao();
		  model.addAttribute("tarefas", tarefas);
		  return "tarefa/lista";
	  }
	  
	  private EntityManager abrirConexao(){
		  manager = Conexao.getEntityManager();		  	
		  manager.getTransaction().begin();
		  return manager;
	  }
	  
	  private void fecharConexao(){
		  manager.getTransaction().commit();
		  Conexao.closeEntityManager();		  
	  }
}
