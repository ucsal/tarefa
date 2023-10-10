package br.ucsal.pooa.lab.tarefa.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.ucsal.pooa.lab.tarefa.Lista;
import br.ucsal.pooa.lab.tarefa.anotacao.Coluna;


public class InterfaceGrafica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField titulo = new JTextField();
	private JTextField descricao = new JTextField();
	private JCheckBox concluida = new JCheckBox();
	private JButton adicionar = new JButton("Adicionar");

	private JButton salvar = new JButton("Salvar");
	private JButton atualizar = new JButton("Atualizar");

	private Vector<String> colunas = new Vector<String>();
	private Vector<Vector<String>> dados = new Vector<>();

	private Lista listaTarefas;

	public InterfaceGrafica(Lista lista) {
		super("Tarefas");
		this.listaTarefas = lista;

		JPanel formulario = new JPanel(new GridLayout(4, 2));
		formulario.add(new JLabel("Titulo:"));
		formulario.add(titulo);
		formulario.add(new JLabel("Descrição:"));
		formulario.add(descricao);
		formulario.add(new JLabel("Concluida:"));
		formulario.add(concluida);
		formulario.add(new JLabel(""));
		formulario.add(salvar);

		JPanel botoes = new JPanel(new GridLayout(1, 3));
		botoes.add(atualizar);
		botoes.add(adicionar);

		this.add(botoes, BorderLayout.SOUTH);

		final JDialog frame = new JDialog(this, "ADICIONAR", true);
		frame.getContentPane().add(formulario);
		frame.pack();
		frame.setLocationRelativeTo(null);

		colunas.add("TITULO");
		colunas.add("DESCRIÇÃO");
		colunas.add("");

		JTable tabela = new JTable(dados, colunas);
		JScrollPane centro = new JScrollPane(tabela);
		this.add(centro);

		adicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
			}
		});

		atualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dados.clear();

				// Lista para armazenar os nomes das colunas
   				List<String> colunasList = new ArrayList<>();

				TreeMap<Integer, String> orderedResults = new TreeMap<>();
    			TreeMap<Integer, String> orderedColumns = new TreeMap<>();

				System.out.println(listaTarefas.getTarefas().size());
			    for (Object obj : listaTarefas.getTarefas()) {
					Vector<String> linha = new Vector<String>();
					Method[] methods = obj.getClass().getDeclaredMethods();
					//List methods and filter the ones with @Coluna annotation
					Arrays.stream(methods).filter( m -> m.isAnnotationPresent(Coluna.class)).toList();

        
					for (Method method : methods) {
						if (method.isAnnotationPresent(Coluna.class)) {
							try {
								Coluna coluna = method.getAnnotation(Coluna.class);
								// Adicionando o nome da coluna à lista
								orderedColumns.put(coluna.posicao(), coluna.texto());
								String result = (String) method.invoke(obj);
								orderedResults.put(coluna.posicao(), result);
							} catch (IllegalAccessException | InvocationTargetException ex) {
								ex.printStackTrace();
							}
						}
					}
					// Adicionando os resultados ordenados ao vetor linha
					for (String result : orderedResults.values()) {
						linha.add(result);
					}		
					dados.add(linha);
				}

				// Convertendo o TreeMap para uma lista
				for (String columnName : orderedColumns.values()) {
					colunasList.add(columnName);
				}
					
				// Convertendo a lista de colunas em um vetor para usar no DefaultTableModel
				Vector<String> colunasVector = new Vector<>(colunasList);

				tabela.setModel( new DefaultTableModel( dados , colunasVector ) );

			}
		});

		salvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String t = titulo.getText();
				String d = descricao.getText();
				Boolean c = concluida.isSelected();
				listaTarefas.adicionarTarefa(t, d, c);
				frame.setVisible(false);
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 400);
		this.setLocationRelativeTo(null);

		// INSERIR O CODIGO DO MENU AQUI


		this.setVisible(true);

	}

}
