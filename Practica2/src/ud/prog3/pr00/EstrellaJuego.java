package ud.prog3.pr00;

import java.security.Timestamp;

public class EstrellaJuego {

	private JLabelEstrella migrafico;
	private static long t;

	public JLabelEstrella getMigrafico() {
		return migrafico;
	}

	public void setMigrafico(JLabelEstrella migrafico) {
		this.migrafico = migrafico;
	}
	
	
	public long getT() {
		return t;
	}

	public void setT(long l) {
		EstrellaJuego.t = l;
	}
}
