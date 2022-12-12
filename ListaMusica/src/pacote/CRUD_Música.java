package pacote;

public class CRUD_Música extends CRUD {
	
	
	public void create(String letra, Artista artista, int ano, String nome) {
		Música nova_música = new Música(letra, artista.getNome(), nome, ano);
		artista.add_música(nova_música);
		
	}
	
	public void delete(Música musica, Artista artista) {
		System.out.println("deltei uma música :(");
	}
	
	public void analisar_música(Música musica_analisada, String Crítico) {
		Crítico critico = new Avô(musica_analisada);
		boolean critério = critico.apuração(musica_analisada);
		System.out.println(critico.resposta(critério));
	}
}
