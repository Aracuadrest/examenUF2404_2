package modelo;

public class CuentaJoven extends Cuenta {
	
	private double bonificaci�n;
	private boolean estudiante;
	
	public CuentaJoven(Persona titular) {
		super(titular);
	}
	
	// Constructor con todos los par�metros
	
	public CuentaJoven(Persona titular, int bonificaci�n, boolean estudiante) {
		super(titular);
		if (titular.getEdad()<26) {
		this.bonificaci�n = bonificaci�n;
		this.estudiante = estudiante;
		}else {
			this.bonificaci�n=0;
			this.estudiante=false;
		}
	}
	// Getters y setter:

	public double getBonificaci�n() {
		return bonificaci�n;
	}

	public void setBonificaci�n(int bonificaci�n) {
		this.bonificaci�n = bonificaci�n;
	}

	public boolean esEstudiante() {
		return estudiante;
	}

	public void setEstudiante(boolean estudiante) {
		this.estudiante = estudiante;
	}
	
	// M�todo toString():
	@Override
	public String toString() {
		return "CuentaJoven [getTitular()=" + getTitular() + ", bonificaci�n=" + bonificaci�n + ", estudiante="
				+ estudiante + "]";
	}
	
	/**
	 * M�todo que calcula los intereses de la cuenta coomo el producto del saldo por la tasa de inter�s
	 * teniendo en cuenta la bonificacion de la cuentaJoven
	 * @return double intereses de la cuenta
	 */
	public double calculaIntereses() {
		double intereses= super.calculaIntereses();
		intereses= intereses - intereses*this.bonificaci�n;
		if (estudiante) {
			intereses=intereses - intereses*0.07;
		}
		return intereses;
	}
	
	// M�todo transferir
	 
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
