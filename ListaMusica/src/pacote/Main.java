package pacote;

public class Main {
	
	
	public static void main(String[] args) {
		CRUD_Artista artista = new CRUD_Artista();
		CRUD_Música música = new CRUD_Música();
		
		artista.create(24, "masculino", "beatles");
		música.create("I need somebody help!", artista.getArmazem().getArtistas().get(0), 1955, "help");
		música.create("Heeeey jude", artista.getArmazem().getArtistas().get(0), 1955, "hey jude");
		System.out.println(artista.getArmazem().getArtistas().get(0).getNome());
		artista.read_música();
		Música jude = artista.armazem.busca_música("hey jude");
		System.out.println(jude.getLetra());
	}
	
}
