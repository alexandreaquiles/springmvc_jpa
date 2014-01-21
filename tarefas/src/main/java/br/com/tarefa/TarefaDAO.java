package br.com.tarefa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.tarefa.entidades.Tarefa;

@Repository
public class TarefaDAO {

	@PersistenceContext
	private EntityManager manager;

	public void adiciona(Tarefa tarefa) {
		manager.persist(tarefa);
		manager.flush();
	}

	public void altera(Tarefa tarefa) {
		manager.merge(tarefa);
	}

	public List<Tarefa> lista() {
		return manager.createQuery("select t from Tarefa t").getResultList();
	}

	public Tarefa buscaPorId(Long id) {
		return manager.find(Tarefa.class, id);
	}

	public void remove(Tarefa tarefa) {
		Tarefa tarefaARemover = buscaPorId(tarefa.getId());
		manager.remove(tarefaARemover);
	}

}
