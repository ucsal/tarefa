package br.ucsal.pooa.lab.tarefa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ucsal.pooa.lab.tarefa.gui.Linha;



public class Lista {

	private List<Linha> tarefas = new ArrayList<>();

	/**
	 * Retornando a lista de tarefas imutavel
	 * 
	 * @return
	 */
	public List<Linha> getTarefas() {
		return Collections.unmodifiableList(tarefas);
	}

	public void setTarefas(List<Linha> tarefas) {
		this.tarefas = tarefas;
	}

	public void adicionarTarefa(Tarefa tarefa) {
		this.tarefas.add(tarefa);
	}

	public void adicionarTarefa(String titulo, String descricao) {
		this.adicionarTarefa(titulo, descricao, false);
	}

	public void adicionarTarefa(String titulo, String descricao, Boolean concluida) {
		Tarefa tarefa = new Tarefa(titulo, descricao, concluida);
		this.adicionarTarefa(tarefa);
	}


}
