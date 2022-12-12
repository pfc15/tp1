package pacote;

public class CRUD {
	protected Armazem_artista armazem;
	
	public CRUD() {
		Armazem_artista armazem = new Armazem_artista();
		this.armazem = armazem;
	}
	
	public CRUD(Armazem_artista armazem) {
		this.armazem = armazem;
	}
	
	
	public void read_música() {
		for (int i =0; i<armazem.getArtistas().size(); i++) {
			Artista artista = armazem.getArtistas().get(i);
			for (int e=0; e<artista.getMúsicas().size(); e++) {
				System.out.println(artista.getNome() + "..." + artista.getMúsicas().get(e).getNome_música());
			}
		}
	}
	
	public void update(Armazem_artista novo_armazem) {
		this.armazem = novo_armazem;
	}
	
	public void delete() {
		System.out.println("deletei :(");
	}

	public Armazem_artista getArmazem() {
		return armazem;
	}

	public void setArmazem(Armazem_artista armazem) {
		this.armazem = armazem;
	};
}
