import java.util.Calendar;

public class Transazione {
	String tipo;
	float valore;
	Calendar data;
	
	public Transazione(String tipo, float valore, Calendar data) {
		super();
		this.tipo = tipo;
		this.valore = valore;
		this.data = data;
	}
	
	@Override
	public String toString() {
		//da Calendar a String
		return "data: "+data.getTime()+" tipo: "+tipo+" valore: €"+valore;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getValore() {
		return valore;
	}
	public void setValore(float valore) {
		this.valore = valore;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
}
