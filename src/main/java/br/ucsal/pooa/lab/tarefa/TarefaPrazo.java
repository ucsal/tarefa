package br.ucsal.pooa.lab.tarefa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

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
	
	@Override
	public String coluna3() {
		return this.data.format(formatter);
	}
	
 
	
	
}
