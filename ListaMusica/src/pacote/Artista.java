package pacote;
import java.util.*;

public class Artista {
	private List<Música> músicas = new ArrayList<Música>();
	private int idade;
	private String gênero;
	private String nome;
	
	public Artista(int idade, String gênero, String nome) {
		this.idade = idade;
		this.gênero = gênero;
		this.nome = nome;
	}
	
	public List<Música> getMúsicas() {
		return músicas;
	}
	public void setMúsicas(List<Música> músicas) {
		this.músicas = músicas;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getGênero() {
		return gênero;
	}
	public void setGênero(String gênero) {
		this.gênero = gênero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public void del_música(Música música) {
		músicas.remove(música);
	}
	
	
	public void add_música(Música música) {
		músicas.add(música);
	}
	
	
}
