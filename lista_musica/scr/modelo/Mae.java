package modelo;
import java.util.*;

public class Mae extends Critico {
	
	private List<String> apelidos_carinhosos = new ArrayList<String>();
	
	public Mae(Musica analise) {
		nome = "mãe";
		this.musica_analisada = analise;
		this.veredito = apuração();
	}
	
	public Mae(Musica analise, List<String> positivo, List<String> apelidos) {
		nome = "mãe";
		this.apelidos_carinhosos = apelidos;
		Random rand = new Random();
		for (int i=0; i<positivo.size();i++) {
			int num = rand.nextInt(apelidos_carinhosos.size());
			frases_positivas.add("ah " +apelidos_carinhosos.get(num) + " " + positivo.get(i));
		}
		this.musica_analisada = analise;
		
		this.veredito = apuração();
		
	}
	
	@Override
	public boolean apuração() {
		return true;
	}
	
	public List<String> getApelidos_carinhosos(){
		return apelidos_carinhosos;
	}
	
	public void setApelidos_carinhosos(List<String> apelidos_carinhosos) {
		this.apelidos_carinhosos = apelidos_carinhosos;
	}
	
}
