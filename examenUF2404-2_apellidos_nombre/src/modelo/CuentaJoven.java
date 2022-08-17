package modelo;

public class CuentaJoven extends Cuenta {
	
	private double bonificacion;
	private boolean estudiante;
	
	public CuentaJoven(Persona titular) {
		super(titular);
	}
	
	// Constructor con todos los par�metros
	
	public CuentaJoven(Persona titular, int bonificacion, boolean estudiante) {
		super(titular);
		if (titular.getEdad()<26) {
		this.bonificacion = bonificacion;
		this.estudiante = estudiante;
		}else {
			this.bonificacion=0;
			this.estudiante=false;
		}
	}
	// Getters y setter:

	public double getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
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
		return "CuentaJoven [getTitular()=" + getTitular() + ", bonificaci�n=" + bonificacion + ", estudiante="
				+ estudiante + "]";
	}
	
	/**
	 * M�todo que calcula los intereses de la cuenta coomo el producto del saldo por la tasa de inter�s
	 * teniendo en cuenta la bonificacion de la cuentaJoven
	 * @return double intereses de la cuenta
	 */
	public double calculaIntereses() {
		double intereses= super.calculaIntereses();
		intereses= intereses - intereses*this.bonificacion;
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
