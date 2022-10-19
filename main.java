package trabalho_poo_de_janclaudio;

public class main {

	public static void main(String[] args) {
		threadsemafaro sf = new threadsemafaro();
		
		for (int i=0; i<10; i++){
			System.out.println(sf.mudarCor());
			sf.esperaCorMudar();
		}
		
		sf.desligarSemafaro();
	}

}
