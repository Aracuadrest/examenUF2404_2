package modelo;

public class CuentaJoven extends Cuenta {
	
	private double bonificación;
	private boolean estudiante;
	
	public CuentaJoven(Persona titular) {
		super(titular);
	}
	
	// Constructor con todos los parámetros
	
	public CuentaJoven(Persona titular, int bonificación, boolean estudiante) {
		super(titular);
		if (titular.getEdad()<26) {
		this.bonificación = bonificación;
		this.estudiante = estudiante;
		}else {
			this.bonificación=0;
			this.estudiante=false;
		}
	}
	// Getters y setter:

	public double getBonificación() {
		return bonificación;
	}

	public void setBonificación(int bonificación) {
		this.bonificación = bonificación;
	}

	public boolean esEstudiante() {
		return estudiante;
	}

	public void setEstudiante(boolean estudiante) {
		this.estudiante = estudiante;
	}
	
	// Método toString():
	@Override
	public String toString() {
		return "CuentaJoven [getTitular()=" + getTitular() + ", bonificación=" + bonificación + ", estudiante="
				+ estudiante + "]";
	}
	
	/**
	 * Método que calcula los intereses de la cuenta coomo el producto del saldo por la tasa de interés
	 * teniendo en cuenta la bonificacion de la cuentaJoven
	 * @return double intereses de la cuenta
	 */
	public double calculaIntereses() {
		double intereses= super.calculaIntereses();
		intereses= intereses - intereses*this.bonificación;
		if (estudiante) {
			intereses=intereses - intereses*0.07;
		}
		return intereses;
	}
	
	// Método transferir
	 
	public boolean transferir(Cuenta cDestino, double cantidad) {
		boolean correcto=false;
		if (this.getSaldo()>(cantidad+Cuenta.comision)) {
			this.saldo=this.saldo-cantidad-Cuenta.comision;
			cDestino.saldo=cDestino.saldo+cantidad;
			correcto=true;
		}
		if (this.estudiante=true){
			this.saldo=this.saldo+Cuenta.comision;
			
		}
		return correcto;
	}
	
	
	
	
	
}
