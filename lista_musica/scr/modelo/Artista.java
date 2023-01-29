package modelo;
import java.util.*;
import org.junit.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Artista {
	private List<Musica> musicas = new ArrayList<Musica>();
	private int idade;
	private String genero;
	private String nome;
	
	public Artista(int idade, String genero, String nome) {
		this.idade = idade;
		this.genero = genero.toLowerCase();
		this.nome = nome.toLowerCase();
	}
	
	public List<Musica> getMusicas() {
		return musicas;
	}
	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getGenero() {
		return genero;
	}
	public void setGênero(String genero) {
		this.genero = genero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	/**
	 * deleta uma música da lista de músicas do Artista
	 * @param música
	 */
	public void del_musica(Musica música) {
		musicas.remove(música);
	}
	
	/**
	 * adiona uma música à lista de músicas do Artista
	 * @param música
	 */
	public void add_musica(Musica música) {
		musicas.add(música);
	}
	
	@Override
	public String toString() {
		String retorno = "nome: " + nome + "\nidade: " + idade + "\ngênero: " + genero + "\nmúsicas: ";
		for (int i=0;i<musicas.size();i++) {
			retorno += "\n" + musicas.get(i).getNome_musica();
		}
		return retorno;
	}
	
	
	/**
	 * Retorna todas as informações da instancia da classe, mas formatada
	 * para HTML
	 * @return
	 */
	public String toStringHTML() {
		String retorno = "<html><br>nome: " + nome + "<br>idade: " + idade + "<br>gênero: " 
	+ genero + "<br>músicas: ";
		for (int i=0;i<musicas.size();i++) {
			retorno += "<br>" + musicas.get(i).getNome_musica();
		}
		retorno += "<html>";
		return retorno;
	}

}
