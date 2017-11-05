package ud.prog3.pr00;

import org.junit.Test;

/** Clase para definir instancias lógicas de coches con posición, dirección y velocidad.
 * @author Andoni Eguíluz
 * Facultad de Ingeniería - Universidad de Deusto (2014)
 */
public class Coche {
	protected double miVelocidad;  // Velocidad en pixels/segundo
	protected double miDireccionActual;  // Dirección en la que estoy mirando en grados (de 0 a 360)
	protected double posX;  // Posición en X (horizontal)
	protected double posY;  // Posición en Y (vertical)
	protected String piloto;  // Nombre de piloto
	static final int MASA =1;
	static final double COEF_SUELO=15.5;
	static final double COEF_AIRE=0.35;
	static final int FB_DEL=2000;
	static final int FB_ATRAS=1000;
	
	
	// Constructores
	
	public Coche() {
		miVelocidad = 0;
		miDireccionActual = 0;
		posX = 300;
		posY = 300;
	}
	
	/** Devuelve la velocidad actual del coche en píxeles por segundo
	 * @return	velocidad
	 */
	public double getVelocidad() {
		return miVelocidad;
	}

	/** Cambia la velocidad actual del coche
	 * @param miVelocidad
	 */
	public void setVelocidad( double miVelocidad ) {
		this.miVelocidad = miVelocidad;
	}

	public double getDireccionActual() {
		return miDireccionActual;
	}

	public void setDireccionActual( double dir ) {
		if (dir < 0) dir = 360 + dir;
		if (dir > 360) dir = dir - 360;
		miDireccionActual = dir;
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosicion( double posX, double posY ) {
		setPosX( posX );
		setPosY( posY );
	}
	
	public void setPosX( double posX ) {
		this.posX = posX; 
	}
	
	public void setPosY( double posY ) {
		this.posY = posY; 
	}
	
	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}


	/** Cambia la velocidad actual del coche
	 * @param aceleracion	Incremento/decremento de la velocidad en pixels/segundo
	 */
	public void acelera( double aceleracion ) {
		miVelocidad = miVelocidad + aceleracion;
	}
	
	/** Cambia la dirección actual del coche
	 * @param giro	Angulo de giro a sumar o restar de la dirección actual, en grados (-180 a +180)
	 * 				Considerando positivo giro antihorario, negativo giro horario
	 */
	public void gira( double giro ) {
		setDireccionActual( miDireccionActual + giro );
	}
	
	/** Cambia la posición del coche dependiendo de su velocidad y dirección
	 * @param tiempoDeMovimiento	Tiempo transcurrido, en segundos
	 */
	public void mueve( double tiempoDeMovimiento ) {
		setPosX( posX + miVelocidad * Math.cos(miDireccionActual/180.0*Math.PI) * tiempoDeMovimiento );
		setPosY( posY + miVelocidad * -Math.sin(miDireccionActual/180.0*Math.PI) * tiempoDeMovimiento );
		// el negativo es porque en pantalla la Y crece hacia abajo y no hacia arriba
	}
	
	@Override
	public String toString() {
		return piloto + " (" + posX + "," + posY + ") - " +
			   "Velocidad: " + miVelocidad + " ## Dirección: " + miDireccionActual; 
	}
	
	public double fuerzaAceleracionAdelante() {
		 if (miVelocidad<=-150) return FB_DEL;
		 else if (miVelocidad<=0)
		 return FB_DEL*(-miVelocidad/150*0.5+0.5);
		 else if (miVelocidad<=250)
		 return FB_DEL*(miVelocidad/250*0.5+0.5);
		 else if (miVelocidad<=750)
		 return FB_DEL;
		 else return FB_DEL*(-(miVelocidad-1000)/250);
		 }
	
	public double fuerzaAceleracionaAtras() {
		 if (miVelocidad>=250) return FB_ATRAS;
		 else if (miVelocidad>=0)
		 return FB_ATRAS*(-miVelocidad/250*0.55+0.3);
		 else if (miVelocidad>=-200)
		 return FB_ATRAS*(miVelocidad/200*0.7+0.3);
		 else if (miVelocidad>=-350)
		 return FB_ATRAS;
		 else return FB_ATRAS*(-(miVelocidad+500)/250);
		 }
	
		 @Test
		 public void testFuerzaAceleracionAtras() {
		 double[] tablaVel = { -500, -425, -300, -250, -200, -100, 0, 125, 250, 500,
		1100 };
		 double[] tablaFuerza = { 0, 0.5, 1, 1, 1, 0.65, 0.3, 0.575, 0.85, 0.85,
		0.85 };
		 for (int i=0;i<tablaVel.length;i++) {
//		 c.setVelocidad( tablaVel[i] );
//		 assertEquals( "Velocidad " + tablaVel[i], tablaFuerza[i]*Coche.FB_ATRAS,
//		c.fuerzaAceleracionAtras(), 0.0000001 );
		 }
		 } 
}
