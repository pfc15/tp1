package visual;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import  modelo.*;
import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaginaArtista implements ActionListener {
	JTextField idade_f, gênero_f, nome_f;
	JLabel prompt_idade, prompt_gênero, prompt_nome, jlabContents;
	Biblioteca_artista biblioteca;
	JTextArea mostra_artista;
	JScrollPane scroll;
	JFrame jfrm;
	
	PaginaArtista(Biblioteca_artista biblioteca) { 
		this.biblioteca = biblioteca;
		// Cria um novo container JFrame. 
		jfrm = new JFrame("Letras de Música - Página de Artistas"); 
		jfrm.pack();
		
		// Especifica o uso do FlowLayout.  
		jfrm.setLayout(new FlowLayout()); 

		// Define o tamanho do frame. 
		jfrm.setSize(700, 650); 
		jfrm.setLocationRelativeTo(null);

		//Cria um campo de texto. 
		idade_f = new JTextField(10); 
		gênero_f = new JTextField(10); 
		nome_f = new JTextField(10); 

		// Define uma ação pata o campo de texto. 
		idade_f.setActionCommand("idade");
		gênero_f.setActionCommand("gênero");
		nome_f.setActionCommand("nome");

		// Cria o botão com para transformar todas as letras em maiúsculo. 
		JButton add_artista = new JButton("Adicione o artista");
		JButton btn_artista = new JButton("mostrar artistas");
		
		
		// Adiciona eventos.
		add_artista.addActionListener(this);
		btn_artista.addActionListener(this);

		// Cria rótulos. 
		prompt_idade = new JLabel("Digite a idade do artista: "); 
		prompt_gênero = new JLabel("Digite o gênero do artista: "); 
		prompt_nome = new JLabel("Digite o nome do artista: "); 
		jlabContents = new JLabel(""); 
		mostra_artista = new JTextArea(25, 50);

		Font fonte = mostra_artista.getFont();
		mostra_artista.setFont(fonte.deriveFont(fonte.getSize() + 2.0f));
		scroll = new JScrollPane(mostra_artista);
		
		
		// Adiciona os componentes ao painel de conteúdo. 
		jfrm.add(prompt_nome);
		jfrm.add(nome_f);
		jfrm.add(prompt_gênero);
		jfrm.add(gênero_f);
		jfrm.add(prompt_idade);
		jfrm.add(idade_f);
		jfrm.add(add_artista);
		jfrm.add(btn_artista);
		jfrm.add(jlabContents);
		
		// localizar o pessoal
		
		// Mostra o frame construído. 
		jfrm.setVisible(true); 
	}
	
	/**
	 * Método para gerência de eventos
	 * evento 1: adicione artista
	 * adiciona ao programa o artista desde que as informações sejam fornecidas
	 * corretamente
	 * 
	 * evento 2: mostrar artistas
	 * mostra a lista de artistas que já foram adicionados ao programa e as suas
	 * informações
	 */
	//Método para gerência de eventos
	public void actionPerformed(ActionEvent ae) { 

		if(ae.getActionCommand().equals("Adicione o artista")) { 
			// Converte as letras para maiúsculo caso o botão seja pressionado.  
			String nome = nome_f.getText();
			String gênero = gênero_f.getText();
			int idade = Integer.parseInt(idade_f.getText());
			Artista novo = new Artista(idade, gênero, nome);
			biblioteca.add_artista(novo);
			jlabContents.setText(novo.toStringHTML());
		} else if (ae.getActionCommand().equals("mostrar artistas")) {
			System.out.println("ola");
			jfrm.add(scroll);
			jfrm.setVisible(true);
			mostra_artista.setText(biblioteca.toString());
			
		}
	}
}
