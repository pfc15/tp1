package pacote;

public class CRUD_Artista extends CRUD{
	
	
	public void create(int idade, String genero, String nome) {
		Artista novo = new Artista(idade, genero, nome);
		armazem.add_artista(novo);
	}
	
	public void read() {
		for (int i =0; i<armazem.getArtistas().size(); i++) {
			System.out.println(armazem.getArtistas().get(i).getNome());
		}
	}
	
	public void update(Armazem_artista novo_armazem, CRUD_Música crud) {
		this.armazem = novo_armazem;
		crud.setArmazem(novo_armazem);
	}
	
	public void delete(Artista artista) {
		System.out.println("deletei o artista :(");
	}
}
