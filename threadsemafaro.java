package trabalho_poo_de_janclaudio;
import com.sun.swing.internal.plaf.synth.resources.synth;


public class threadsemafaro implements Runnable {

	private Colors cor;
	private boolean parar;
	private boolean CMD;

	public threadsemafaro(){
		this.cor = Colors.VERMELHO;

		this.parar = false;
		this.CMD = false;

		new Thread(this).start();
	}

	@Override
	public void run() {

		while(!parar){
			try {
				
				Thread.sleep(this.cor.getTempoEspera());
				this.mudarCor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	synchronized void mudarCor(){
		switch (this.cor) {
		case VERMELHO:
			this.cor = Colors.VERDE;
			break;
		case AMARELO:
			this.cor = Colors.VERMELHO;
			break;
		case VERDE:
			this.cor = Colors.AMARELO;
			break;
		default:
			break;
		}
		this.CMD = true;
		notify();
	}
	
	public synchronized void esperaCorMudar(){
		while(!this.CMD){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.CMD = false;
	}
	
	public synchronized void desligarSemafaro(){
		this.parar = true;
	}

	public Colors getCor() {
		return cor;
	}
}
