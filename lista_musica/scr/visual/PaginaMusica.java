package visual;
import javax.swing.*;

import dados.Cadastro;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import  modelo.*;

public class PaginaMusica implements ActionListener {
	JTextField letra_f, nome_música_f, ano_f;
	JButton criar_música; 
	JLabel prompt_letra, prompt_música, prompt_ano, prompt_artista, jlabContents;
	JList artistas;
	Biblioteca_artista biblioteca;

	PaginaMusica(Biblioteca_artista biblioteca) { 
		this.biblioteca = biblioteca;
		// Cria um novo container JFrame. 
		JFrame jfrm = new JFrame("Letras de Música - Página de músicas"); 
		jfrm.pack();
		// Especifica o uso do FlowLayout.  
		jfrm.setLayout(new FlowLayout()); 
		
		// Define o tamanho do frame. 
		jfrm.setSize(650, 400);
		jfrm.setLocationRelativeTo(null);
		
		
		//Cria um campo de texto. 
		letra_f = new JTextField(20);
		nome_música_f = new JTextField(20);
		ano_f = new JTextField(20);
		artistas = new JList(biblioteca.getListaArtista().toArray());
		

		// Define uma ação pata o campo de texto. 
		letra_f.setActionCommand("f_letra"); 
		nome_música_f.setActionCommand("f_nome_múisca"); 
		ano_f.setActionCommand("f_ano"); 

		// Cria o botão com para transformar todas as letras em maiúsculo. 
		JButton criar_música = new JButton("adicione a música"); 
		JButton mostrar_músicas = new JButton("mostrar músicas");
		
		// Adiciona eventos. 
		letra_f.addActionListener(this); 
		nome_música_f.addActionListener(this); 
		ano_f.addActionListener(this); 
		criar_música.addActionListener(this);
		mostrar_músicas.addActionListener(this);

		// Cria rótulos. 
		prompt_letra = new JLabel("Digite a letra: ");
		prompt_música = new JLabel("Digite o nome da música: ");
		prompt_artista = new JLabel("ache o artista: ");
		prompt_ano = new JLabel("Digite o ano da música: ");
		jlabContents = new JLabel(""); 

		// Adiciona os componentes ao painel de conteúdo. 
		jfrm.add(prompt_música); 
		jfrm.add(nome_música_f);  
		jfrm.add(prompt_letra);  
		jfrm.add(letra_f); 
		jfrm.add(prompt_ano);
		jfrm.add(ano_f);
		jfrm.add(prompt_artista);
		jfrm.add(artistas);
		jfrm.add(criar_música);
		jfrm.add(mostrar_músicas);
		jfrm.add(jlabContents);
		
		
		
		// localizar o pessoal
		
		// Mostra o frame construído. 
		jfrm.setVisible(true); 
	} 
	
	
	/**
	 * Gerencia os eventos da tela
	 * evento 1: adicione uma música
	 * Adiciona a música ao programa, desde que as informações sejam colocadas corretamente
	 * 
	 * evento 2: Mostrar músicas
	 * mostra todas as músicas já cadastradas no programa
	 */
	//Método para gerência de eventos
	public void actionPerformed(ActionEvent ae) {

		if(ae.getActionCommand().equals("adicione a música")) { 
			// Converte as letras para maiúsculo caso o botão seja pressionado. ]
			String letra = Cadastro.read_file(letra_f.getText());
			if (letra.equals("Erro")) {
				letra = letra_f.getText();
			}
			
			if (artistas.getSelectedValue() != null) {
				String nome_artista = artistas.getSelectedValue().toString();
				String nome_música = nome_música_f.getText();
				int ano = Integer.parseInt(ano_f.getText());
				Musica novo = new Musica(letra, nome_artista, nome_música, ano);
				Artista autor = biblioteca.busca_artista_byString(nome_artista);
				autor.add_musica(novo);
				jlabContents.setText(novo.toStringHTML());
			}	else {
				jlabContents.setText("<html>você não selecionou o artista!"
						+ "<br> se ele não esta entre as opções adicione um novo artista na página de artistas ");
			}
			
			
			
		} else if (ae.getActionCommand().equals("mostrar músicas")) {
			jlabContents.setText(biblioteca.mostrar_musica());
		}
	}
}
