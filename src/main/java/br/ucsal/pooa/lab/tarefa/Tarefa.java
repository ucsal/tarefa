package br.ucsal.pooa.lab.tarefa;

import br.ucsal.pooa.lab.tarefa.anotacao.Coluna;
import br.ucsal.pooa.lab.tarefa.gui.Linha;

public class Tarefa implements Linha {

	private String titulo;
	private String descricao;
	private Boolean concluida;

	/**
	 * Crio tarefa e concluida = false
	 * 
	 * @param titulo
	 * @param descricao
	 */
	public Tarefa(String titulo, String descricao) {
		this(titulo, descricao, false);
	}

	/**
	 * 
	 * @param titulo
	 * @param descricao
	 * @param concluida
	 */
	public Tarefa(String titulo, String descricao, Boolean concluida) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.concluida = concluida;
	}

	@Coluna(texto = "Titulo", posicao = 1)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Coluna(texto = "Descrição", posicao = 2)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	@Override
	public String toString() {
		return "Tarefa [titulo=" + titulo + ", descricao=" + descricao +
				", concluida=" + concluida + "]";
	}

	@Override
	public String coluna1() {
		return this.titulo;
	}

	@Override
	public String coluna2() {
		return this.descricao;
	}

	@Coluna(texto = "STATUS", posicao = 3)
	@Override
	public String coluna3() {
		return this.concluida ? "OK" : "";
	}

}
