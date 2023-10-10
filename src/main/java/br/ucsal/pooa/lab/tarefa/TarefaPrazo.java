package br.ucsal.pooa.lab.tarefa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import br.ucsal.pooa.lab.tarefa.anotacao.Coluna;

public class TarefaPrazo extends Tarefa {

	
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate data;

	public TarefaPrazo(String titulo, String descricao, LocalDate data) {
		super(titulo, descricao);
		this.data = data;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	

	@Override
	public String toString() {
		return super.toString()+" TarefaPrazo [data=" + data.format(formatter) + "]";
	}
	

	@Coluna(texto = "TITULO", posicao = 1)
	public String getTitulo() {
		return super.getTitulo();
	}


	@Coluna(texto = "DESCRICAO", posicao = 2)
	public String getDescricao() {
		return super.getDescricao();
	}


	@Coluna(texto = "STATUS", posicao = 3)
	@Override
	public String coluna3() {
		return this.data.format(formatter);
	}
	
 
	
	
}
