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

import dados.Cadastro;

import static org.junit.jupiter.api.Assertions.*;

public class Main implements ActionListener { 

	JTextField jtf; 
	JButton jbtnRev, delete, critico; 
	JLabel jlabPrompt, nome_musica;
	JTextArea jlabContents;
	Biblioteca_artista biblioteca;
	Musica música_analisada = null;
	JScrollPane scroll;
	JFrame jfrm;
	String orgStr = "";
//	Toolkit toolkit = Toolkit.getDefaultToolkit();  
//	Dimension screenSize = toolkit.getScreenSize();
	
	
	Main(Biblioteca_artista biblioteca) { 
		this.biblioteca = biblioteca;
		// Cria um novo container JFrame. 
		jfrm = new JFrame("Letras de Música - Página Principal"); 
		jfrm.pack();
		jfrm.setSize(700, 650);
		
		// Especifica o uso do FlowLayout.  
		jfrm.setLayout(new FlowLayout()); 

		
		jfrm.setLocationRelativeTo(null);
		
		// Encerra o programa caso o usuário feche a aplicação. 
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		//Cria um campo de texto. 
		jtf = new JTextField(10);
//		jtf.resize(400, 300);

		// Define uma ação pata o campo de texto. 
		jtf.setActionCommand("myTF"); 

		// Cria o botão com para transformar todas as letras em maiúsculo. 
		JButton jbtnRev = new JButton("faça sua pesquisa");
		JButton  artista = new JButton("página de artistas");
		JButton musica = new JButton("página de músicas");
		critico = new JButton("veja crítica!");
		delete = new JButton("delete");
		
		
		// Adiciona eventos. 
		jtf.addActionListener(this); 
		jbtnRev.addActionListener(this); 
		artista.addActionListener(this);
		musica.addActionListener(this);
		delete.addActionListener(this);
		critico.addActionListener(this);

		// Cria rótulos. 
		jlabPrompt = new JLabel("Procure por músicas ou artistas: ");
		nome_musica = new JLabel("");
		
		jlabContents = new JTextArea(25, 50);
		Font fonte = jlabContents.getFont();
		jlabContents.setFont(fonte.deriveFont(fonte.getSize() + 2.0f));
		scroll = new JScrollPane(jlabContents);
		
		// Adiciona os componentes ao painel de conteúdo. 
		jfrm.add(jlabPrompt); 
		jfrm.add(jtf);  
		jfrm.add(jbtnRev); 
		jfrm.add(musica);
		jfrm.add(artista);
		jfrm.add(scroll);
		jfrm.add(nome_musica);
		
		// Mostra o frame construído. 
		jfrm.setVisible(true); 
	} 
	
	
	/**
	 * lida com os eventos da página criada no construtor
	 * evento 1: Procure sua música
	 * procura pela música pelo nome dela, e mostra na tela a sua letra
	 * 
	 * evento 2: Página de Artistas
	 * abre a página de Artistas que permite adicionar mais artistas
	 * e conferir a lista de artistas já adicionados
	 * 
	 * evento 3: Página de Músicas
	 * abre a página de músicas que permite adicionar músicas e ter
	 * uma lista das músicas já adicionadas
	 */
	//Método para gerência de eventos
	public void actionPerformed(ActionEvent ae) {
//		System.out.println(ae.getActionCommand());
		 if(ae.getActionCommand().equals("página de artistas")) {
			new PaginaArtista(biblioteca);
		} else if (ae.getActionCommand().equals("página de músicas")) {
			new PaginaMusica(biblioteca);
		} else if (ae.getActionCommand().equals("veja crítica!")) {
			if (biblioteca.busca_musica(orgStr) != null) {
				música_analisada = biblioteca.busca_musica(orgStr);
				new PaginaCritico(biblioteca, música_analisada );
			} else {
				jlabContents.setText("desculpe, não encontramos essa música no sistema.\n"
						+ "Lembrando que só analisamos músicas");
			}
			
			
		}else if(ae.getActionCommand().equals("delete")) {
			if (biblioteca.busca_musica(orgStr) != null) {
				música_analisada = biblioteca.busca_musica(orgStr);
				Artista artista = biblioteca.busca_artista_byMusica(música_analisada);
				artista.del_musica(música_analisada);
				nome_musica.setText("Música deletada: " + música_analisada.getNome_musica());
				jlabContents.setText("");
			}else if (biblioteca.busca_artista_byString(orgStr) != null){
				Artista artista = biblioteca.busca_artista_byString(orgStr);
				biblioteca.del_artista(artista);
				jlabContents.setText("Artísta deletado: \n\n" + artista.toString());
			} else {
				jlabContents.setText("Não existe elemento para ser deletado");
			}
		}
		
		else  {
			nome_musica.setText("");
			// Converte as letras para maiúsculo caso o botão seja pressionado.  
			orgStr = jtf.getText().toLowerCase();
			if (biblioteca.busca_musica(orgStr) != null) {
				música_analisada = biblioteca.busca_musica(orgStr);
				String letra = música_analisada.getLetra();
				jlabContents.setText(letra);
				nome_musica.setText("<html>Música: " + música_analisada.getNome_musica() + "<br>"
			+ "Artísta: " +música_analisada.getNome_artista());
				jfrm.add(delete);
				jfrm.add(critico);
				jfrm.setVisible(true);
			}else if (biblioteca.busca_artista_byString(orgStr) != null){
				Artista artista = biblioteca.busca_artista_byString(orgStr);
				jlabContents.setText(artista.toString());
				jfrm.add(delete);
				jfrm.add(critico);
				jfrm.setVisible(true);
			}	else {
				jlabContents.setText("Desculpe, mas '" + orgStr + "' não esta no nosso sistema");
			} 
			jtf.setText("");
			
		}
	}
	

	public static void main(String args[]) { 
		Biblioteca_artista biblioteca = new Biblioteca_artista();
		Cadastro.cadastrar(biblioteca);
		new Main(biblioteca);
		
	} 
}
