package br.ucsal.pooa.lab.tarefa.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD) 
public @interface Coluna {
    String texto();
    int posicao();
}
