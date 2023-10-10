package br.ucsal.pooa.lab.tarefa;

import br.ucsal.pooa.lab.tarefa.anotacao.Coluna;

public class TarefaEmail extends Tarefa {

	private String email;

	public TarefaEmail(String titulo, String descricao, String email) {
		super(titulo, descricao, false);
		this.email = email;
	}

	@Coluna(texto = "STATUS", posicao = 3)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return super.toString() + " TarefaEmail [email=" + email + "]";
	}

	@Override
	public String coluna3() {
		return this.email;
	}

}
