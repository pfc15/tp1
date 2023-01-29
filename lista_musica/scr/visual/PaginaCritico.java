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


public class PaginaCritico implements ActionListener {
	JLabel nome_musica, jlabContents;
	JList críticos;
	Biblioteca_artista biblioteca;
	Musica musica_analisada;
	
	PaginaCritico(Biblioteca_artista biblioteca, Musica analisada) { 
		this.biblioteca = biblioteca;
		this.musica_analisada = analisada;
		// Cria um novo container JFrame. 
		JFrame jfrm = new JFrame("Exemplo uso JTextField"); 
		jfrm.pack();
		// Especifica o uso do FlowLayout.  
		jfrm.setLayout(new FlowLayout()); 

		// Define o tamanho do frame. 
		jfrm.setSize(400, 300); 
		jfrm.setLocationRelativeTo(null);
		//Cria um campo de texto. 
		String[] lista = {"avô robô", "mãe robô", "crítico pedante robô"};
		críticos = new JList(lista);

		// Define uma ação pata o campo de texto. 

		// Cria o botão com para transformar todas as letras em maiúsculo. 
		JButton ver_crítica = new JButton("ver crítica");
		
		
		// Adiciona eventos.
		ver_crítica.addActionListener(this);

		// Cria rótulos. 
		jlabContents = new JLabel(""); 
		nome_musica = new JLabel("<html><br>Escolha seu crítico:<br>" +analisada.toStringHTML());
		
		// Adiciona os componentes ao painel de conteúdo.
		jfrm.add(nome_musica);
		jfrm.add(críticos);
		jfrm.add(ver_crítica);
		jfrm.add(jlabContents);
		
		// localizar o pessoal
		
		// Mostra o frame construído. 
		jfrm.setVisible(true); 
	}
	
	
	//Método para gerência de eventos
	public void actionPerformed(ActionEvent ae) { 

		if(ae.getActionCommand().equals("ver crítica")) {
			String resp = biblioteca.analisar_musica(musica_analisada, críticos.getSelectedValue().toString());
			jlabContents.setText("<html><br><br><b>Crítica " 
			+ críticos.getSelectedValue().toString() +"</b>:<br>" +resp +"<html>");
		}
	}
	
//	public static void main(String[] args) {
//		Biblioteca_artista bib = new Biblioteca_artista();
//		Artista beatles = new Artista(74, "rock", "beatles");
//		Musica hey_jude = new Musica("heeey jude", "beatles", "hey jude", 1964);
//		beatles.add_musica(hey_jude);
//		bib.add_artista(beatles);
//		new PaginaCritico(bib, hey_jude);
//	}
}
