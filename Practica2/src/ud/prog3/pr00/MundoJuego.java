package ud.prog3.pr00;

import java.util.ArrayList;

public class MundoJuego {

		private ArrayList<JLabelEstrella> listaestrellas;
		
	public static double calcFuerzaRozamiento(double masa, double coefRozSuelo, double coefRozAire, double vel) {
		double fuerzaRozamientoAire = coefRozAire * (-vel); // En contra del movimiento
		double fuerzaRozamientoSuelo = masa * coefRozSuelo * ((vel > 0) ? (-1) : 1); // Contra mvto
		return fuerzaRozamientoAire + fuerzaRozamientoSuelo;
	}

	public static double calcAceleracionConFuerza(double fuerza, double masa) {
		return fuerza / masa;
	}

	public static void aplicarFuerza(double fuerza, Coche coche) {
		double fuerzaRozamiento = calcFuerzaRozamiento(Coche.MASA, Coche.COEF_SUELO, Coche.COEF_AIRE,
				coche.getVelocidad());
		double aceleracion = calcAceleracionConFuerza(fuerza + fuerzaRozamiento, Coche.MASA);
		if (fuerza == 0) {
			// No hay fuerza, solo se aplica el rozamiento
			double velAntigua = coche.getVelocidad();
			coche.acelera(aceleracion, 0.04);
			if (velAntigua >= 0 && coche.getVelocidad() < 0 || velAntigua <= 0 && coche.getVelocidad() > 0) {
				coche.setVelocidad(0); // Si se está frenando, se para (no anda al revés)
			}
		} else {
			coche.acelera(aceleracion, 0.04);
		}

	}
	
	public void creaEstrella() {
		JLabelEstrella estrella= new JLabelEstrella();
//		estrella.setPosicion( Math.random(), Math.random() );
//		panel.add( miCoche.getGrafico() );  // Añade al panel visual
//		miCoche.getGrafico().repaint();  // Refresca el dibujado del coche
//	}
	}
}
