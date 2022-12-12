package pacote;
import java.util.*;

public class Armazem_artista {
	private List<Artista> artistas = new ArrayList<Artista>();
	
	public Armazem_artista() {
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
	
	public Artista Match_artista(Música música) {
		Artista autor;
		for (int i =0; i<artistas.size();i++) {
			for (int e=0; e < artistas.get(i).getMúsicas().size();e++) {
				Música música1 = artistas.get(i).getMúsicas().get(e);
				if (música1.getNome_música().equals(música.getNome_música())) {
					autor = artistas.get(i);
					return autor;
				}
			}
		}
		return null;
	}
	
	public Música busca_música(String termo_procurado) {
		Música música;
		for (int i =0; i<artistas.size();i++) {
			for (int e=0; e < artistas.get(i).getMúsicas().size();e++) {
				Música música1 = artistas.get(i).getMúsicas().get(e);
				if (música1.getNome_música().equals(termo_procurado)) {
					música = música1;
					return música;
				}
			}
		}
		return null;
	}
}
