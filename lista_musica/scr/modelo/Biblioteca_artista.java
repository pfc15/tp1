package modelo;
import java.util.*;

import org.junit.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Biblioteca_artista {
	private List<Artista> artistas = new ArrayList<Artista>();
	
	public Biblioteca_artista() {
	}

	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}
	
	public void del_artista(Artista artista) {
		artistas.remove(artista);
	}
	
	public void add_artista(Artista artista) {
		artistas.add(artista);
	}
	
	/**
	 * Retorna uma string formatada em HTML com todas as músicas presentes
	 * na instancia da classe
	 * @return String
	 */
	public String mostrar_musica() {
		String retorno = "<html><br><br>";
		for (int i =0; i<artistas.size(); i++) {
			Artista artista = artistas.get(i);
			for (int e=0; e<artista.getMusicas().size(); e++) {
				retorno += artista.getNome() + "..." + artista.getMusicas().get(e).getNome_musica() + "; <br>";
			}
		}
		retorno += "<html>";
		return retorno;
	}
	
	public ArrayList<String> getListaArtista() {
		ArrayList<String> nome_artistas = new ArrayList<String>();
		for (int i=0;i<artistas.size();i++) {
			nome_artistas.add(artistas.get(i).getNome());
		}
		return nome_artistas;
	}
	
	
	/**
	 * teste de busca da música 
	 */
	@Test
	public void teste_busca_musica() {
		Artista pedro = new Artista(21, "rock", "pedro");
		Musica minha_musica = new Musica("essa é minha música yeah yeah", "pedro", "minha música", 2023);
		pedro.add_musica(minha_musica);
		this.add_artista(pedro);
		
		Musica música_achada = busca_musica("minha música");
		
		assertEquals(minha_musica, música_achada);
		assertNull(busca_musica("música inexistente"));
		
	}
	
	
	/**
	 * O método busca uma música por uma String tentando dar match
	 * com o nome da música, caso não encontre um match retorna null
	 * @param termo_procurado
	 * @return Musica
	 */
	public Musica busca_musica(String termo_procurado) {
		Musica musica;
		for (int i =0; i<artistas.size();i++) {
			for (int e=0; e < artistas.get(i).getMusicas().size();e++) {
				Musica música1 = artistas.get(i).getMusicas().get(e);
				if (música1.getNome_musica().equals(termo_procurado)) {
					musica = música1;
					return musica;
				}
			}
		}
		return null;
	}
	
	/**
	 * Teste para conferir se você consegue adicionar e deletar músicas
	 * corretamente. 
	 */
	@Test
	protected void teste_add_del_música() {
		Musica musica = new Musica("letras", "eu", "múisca incrível", 2023);
		Artista eu = new Artista(21, "rock", "pedro");
		eu.add_musica(musica);
		assertTrue(eu.getMusicas().contains(musica));
		eu.del_musica(musica);
		assertFalse(eu.getMusicas().contains(musica));
	}
	
	/**
	 * teste para a busca de artistas
	 */
	@Test
	public void teste_busca_artista_byString() {
		Artista pedro = new Artista(21, "rock", "pedro");
		Musica hey_jude = new Musica("essa é minha música yeah yeah", "pedro", "minha música", 2023);
		pedro.add_musica(hey_jude);
		this.add_artista(pedro);
		// busca pelo nome
		Artista achado = this.busca_artista_byString("pedro");
		assertEquals(pedro, achado);
		// busca com maiúscula
		achado = this.busca_artista_byString("PEdRo");
		assertEquals(pedro, achado);
		achado = this.busca_artista_byString("predo");
		assertNotEquals(pedro, achado);
	}
	
	/**
	 * O método procura pelo artista pelo nome dele tentando dar match
	 * com o termo procurado. Se não for encontrado nenhum artista o
	 * método retorna null
	 * @param termo_procurado
	 * @return Artista
	 */
	public Artista busca_artista_byString(String termo_procurado) {
		termo_procurado = termo_procurado.toLowerCase();
		for (int i=0;i<artistas.size();i++) {
			if (artistas.get(i).getNome().equals(termo_procurado)) {
				return artistas.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Procura um artista por uma música que esta dentro da lista de músicas dele
	 * caso não seja encontrado nenhum artista, o método retorna null.
	 * @param música
	 * @return Artista
	 */
	public Artista busca_artista_byMusica(Musica música) {
		for (int i=0; i<artistas.size(); i++) {
			if (artistas.get(i).getMusicas().contains(música)) {
				return artistas.get(i);
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String retorno = "Biblioteca: \n";
		for (int i=0;i<artistas.size();i++) {
			retorno += artistas.get(i).toString();
			retorno += "\n\n" + "==".repeat(30) + "\n\n";
		}
		return retorno;
		
	}
	
	/**
	 * Retorna todas as informações da instancia da classe, mas formatado
	 * no formato de HTML
	 * @return
	 */
	public String toStringHTML() {
		String retorno = "<html>Biblioteca: <br>";
		for (int i=0;i<artistas.size();i++) {
			retorno += artistas.get(i).toStringHTML();
			retorno += "<br>" + "==".repeat(30) + "<br>";
		}
		retorno += "<html>";
		return retorno;
		
	}
	
	/**
	 * chama as classes de Críticos para analisar a música selecionado
	 * Retorna uma string revelando o veredito do crítico
	 * @param musica_analisada
	 * @param Crítico_s
	 * @return crítica String
	 */
	public String analisar_musica(Musica musica_analisada, String critico_s) {
		Critico critico;
		if (critico_s.equals("avô robô")){
			critico = new Avo(musica_analisada);
		} else if (critico_s.equals("mãe robô")) {
			critico = new Mae(musica_analisada);
		} else {
			critico = new Pedante(musica_analisada);
		}
		
		return critico.resposta();
	}
}
