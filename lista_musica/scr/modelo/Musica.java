package modelo;

public class Musica {
	private String letra;
	private String nome_artista;
	private int ano;
	private String nome_musica;
	
	public Musica(String letra, String nome_artista, String nome_musica, int ano) {
		this.letra = letra;
		this.nome_artista = nome_artista.toLowerCase();
		this.ano =ano;
		this.nome_musica = nome_musica.toLowerCase();
	}
	
	public String getLetra() {
		return letra;
	}
	public void setLetra(String novo_letra) {
		letra = novo_letra;
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
	public String getNome_musica() {
		return nome_musica;
	}
	public void setNome_música(String nome_música) {
		this.nome_musica = nome_música;
	}
	
	@Override
	public String toString() {
		return "nome da Música: " + nome_musica + "\nNome do Artista: " + 
	nome_artista + "\nano: " + ano + "\nLetra: \n" + letra;
		
	}
	
	/**
	 * Retorna todas as informações da instancia em uma String mas formatada em HTML
	 * @return String
	 */
	public String toStringHTML() {
		return "<html>nome da Música: " + nome_musica + "<br>Nome do Artista: " + 
	nome_artista + "<br>ano: " + ano + "<html>";
		
	}
}
