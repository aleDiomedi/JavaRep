import java.util.ArrayList;

public class ContoCorrente {
	
	ArrayList<Transazione> transazioni= new ArrayList<>();
	float saldo;
	
	public ContoCorrente(float saldo) {
		super();
		this.saldo = saldo;
	}
	
	public void eseguiTransazione(Transazione transazione) {
		if (transazione.getTipo().equals("prelievo")) {
			this.saldo = this.saldo - transazione.valore;
			this.transazioni.add(transazione);
			
		}else if (transazione.getTipo().equals("deposito")) {
			this.saldo = this.saldo + transazione.valore;
			this.transazioni.add(transazione);
			
		}else {
			System.out.println("tipo errato");
		}
	}
	public ArrayList<Transazione> getTransazioni() {
		return transazioni;
	}
	public void setTransazioni(ArrayList<Transazione> transazioni) {
		this.transazioni = transazioni;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	

}
