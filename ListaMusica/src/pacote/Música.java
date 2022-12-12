package pacote;

public class Música {
	private String letra;
	private String nome_artista;
	private int ano;
	private String nome_música;
	
	public Música(String letra, String nome_artista, String nome_música, int ano) {
		this.letra = letra;
		this.nome_artista = nome_artista;
		this.ano =ano;
		this.nome_música = nome_música;
	}
	
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		letra = letra;
	}
	public String getNome_artista() {
		return nome_artista;
	}
	public void setNome_artista(String nome_artista) {
		this.nome_artista = nome_artista;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getNome_música() {
		return nome_música;
	}
	public void setNome_música(String nome_música) {
		this.nome_música = nome_música;
	}
	
	
}
