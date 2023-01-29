package dados;

import java.io.BufferedReader;
import modelo.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import modelo.Artista;
import modelo.Musica;

public class Cadastro {
	
	/**
	 * lê um arquivo txt e retorna uma String dele
	 * @param path
	 * @return String
	 */
	public static String read_file(String path) {
		File file = new File(path);
		String encoding = "utf-8";
		
		try {
			Reader leitor = new BufferedReader (new InputStreamReader(new FileInputStream (file),encoding));
			Scanner sc = new Scanner(leitor);
			String retorno = "";
			while (sc.hasNextLine()) {
				retorno += sc.nextLine() +"\n";
			}
			sc.close();
			return retorno;
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return "Erro";
		}
	}
	
	/**
	 * lê um arquivo txt e retorna uma String formatada para HTML
	 * @param path
	 * @return String
	 */
	public static String read_fileHMTL(String path) {
		File file = new File(path);
		String encoding = "utf-8";
		
		try {
			Reader leitor = new BufferedReader (new InputStreamReader(new FileInputStream (file),encoding));
			Scanner sc = new Scanner(leitor);
			String retorno = "<html>";
			while (sc.hasNextLine()) {
				retorno += sc.nextLine() +"<br>";
			}
			retorno += "<html>";
			sc.close();
			return retorno;
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return "Erro";
		}
	}
	
	
	/**
	 * Cadastra todos os dados da pseudo-base de dados para para a classe agregadora Biblioteca_artista
	 * @param biblioteca
	 */
	public static void cadastrar(Biblioteca_artista biblioteca) {
		String path = "/home/pfc15/Documentos/OO/CursoDeAperfeicoamento-Mod3/CursoDeAperfeicoamento/src/negocio/scr/dados/";
		
		// adicionando camila cabello
		Artista artista = new Artista(25, "pop", "camila cabello");
		String letra = Cadastro.read_file(path + "never_be_the_same.txt");
		Musica musica = new Musica(letra, "camila cabello", "never be the same", 2017);
		artista.add_musica(musica);
		letra = Cadastro.read_file(path + "Havana.txt");
		musica = new Musica(letra, "camila cabello", "havana", 2017);
		artista.add_musica(musica);
		biblioteca.add_artista(artista);
		
		// adicionando seu jorge
		artista = new Artista(52, "samba", "Seu jorge");
		// mina do condominio
		letra = Cadastro.read_file(path + "mina_do_condominio");
		musica = new Musica(letra, "Seu jorge", "mina do condominio", 2007);
		artista.add_musica(musica);
		// amiga da minha mulher
		letra = Cadastro.read_file(path + "amiga_da_minha_mulher.txt");
		musica = new Musica(letra, "seu jorge", "amiga da minha mulher", 2011);
		artista.add_musica(musica);
		//samba rock
		letra = Cadastro.read_file(path+ "samba_rock.txt");
		musica = new Musica(letra, "seu jorge", "samba rock", 2007);
		artista.add_musica(musica);
		biblioteca.add_artista(artista);
		
		// gilberto gil
		artista = new Artista(80, "mpb", "Gilberto gil");
		letra = Cadastro.read_file(path + "andar_com_fe.txt");
		musica = new Musica(letra, "gilberto Gil", "andar com fe", 1982);
		artista.add_musica(musica);
		biblioteca.add_artista(artista);
		
		// caetano veloso
		artista = new Artista(80, "mpb", "Caetano veloso");
		letra = Cadastro.read_file(path+ "alegria_alegria.txt");
		musica = new Musica(letra, "caetano veloso", "alegria alegria", 1967);
		artista.add_musica(musica);
		letra = Cadastro.read_file(path+"sozinho.txt");
		musica = new Musica(letra, "caetano veloso", "Sozinho", 1999);
		artista.add_musica(musica);
		biblioteca.add_artista(artista);
		
		
		// Emicida
		artista = new Artista(37, "rap", "Emicida");
		letra = Cadastro.read_file(path+"passarinhios.txt");
		musica = new Musica(letra, "emicida", "passarinhos", 2015);
		artista.add_musica(musica);
		letra = Cadastro.read_file(path+"amarelo.txt");
		musica = new Musica(letra, "emicida", "Amarelo", 2019);
		artista.add_musica(musica);
		biblioteca.add_artista(artista);
	}
}
