package modelo;

public class Cuenta {

		private Persona titular;
		protected double saldo;
		private double creditoMax;
		protected static final double comision=5;
		protected static final double intereses=0.035;

		
		/**
		 * Constructor de la clase que crea una cuenta dado un titular pasado como parámetro
		 * El saldo de la cuenta estará en 0
		 * @param titular Persona el titular de la Cuenta
		 */
		public Cuenta(Persona titular) {
			this.titular = titular;
			this.saldo=0;
			this.creditoMax=2000;
		}


		/**
		 * Constructor de la clase que crea una cuenta dado un titular y un saldo incial pasados como parámetros
		 * @param titular Persona el titular de la Cuenta
		 * @param saldo double con el valor del saldo incial
		 */
		public Cuenta(Persona titular, double saldo) {
			super();
			this.titular = titular;
			this.saldo = saldo;
			this.creditoMax=2000;
		}




		/** 
		 * Método getter para obtener a la objeto Persona titular de la cuenta
		 * @return Persona el titular de la Cuenta
		 */
		public Persona getTitular() {
			return titular;
		}

		/** 
		 * Método setter para establecer a la Persona titular de la cuenta
		 * @param Persona el titular de la Cuenta
		 */
		public void setTitular(Persona titular) {
			this.titular = titular;
		}


		/**
		 * Método para obtener el saldo de la cuenta
		 * @return double con el saldo de la cuenta. Para establecer el saldo habrá que recurrir a los métodos transferir/ingreso
		 */
		public double getSaldo() {
			return saldo;
		}

		/**
		 * Método que devuelve el valor máximo de crédito que se le permite al cliente en la cuenta
		 * @return double crédito total del que dispone
		 */
		public double getCreditoMax() {
			return creditoMax;
		}
		
		/**
		 * Método que ingresa una cantidad en la Cuenta siempre que la cantidad a ingresas se amahyor que 0
		 * @param cantidad double la cantidad a ingresar
		 */
		public void ingresar(double cantidad) {
			if (cantidad>0) {
				this.saldo=this.saldo+cantidad;
			}
		}

		/**
		 * Método que sirve para retirar saldo de la cuenta, pero a débito, con lo que no se permitirá la retirada 
		 * si no se dispone de saldo suficiente
		 * @param cantidad double la cantidad a retirar
		 * @return boolean con el resultado de la operación true si se ha podido realizar la operación o false en caso 
		 * contrario
		 */
		public boolean retirarADebito(double cantidad) {
			if (cantidad <= this.saldo) {
				this.saldo=this.saldo-cantidad;
				return true;
			}
			return false;
		}
		
		/**
		 * Método que sirve para retirar saldo de la cuenta, pero a crédito, con lo que se permitirá la retirada 
		 * de más saldo del que deispone la cuenta siempre que los números rojos no sobrepasen al creditoMax de la cuenta
		 * @param cantidad double la cantidad a retirar
		 * @return boolean con el resultado de la operación true si se ha podido realizar la operación o false en caso 
		 * contrario
		 */
		public boolean retirarACredito(double cantidad) {
			if (Math.abs(this.saldo-cantidad) <= this.creditoMax) {
				this.saldo=this.saldo-cantidad;
				return true;
			}
			return false;
		}

		
		
		/**
		 * Método de la clase para imprimir una cuenta por pantalla
		 * @return String con la representación textual del objeto Cuenta
		 */
		@Override
		public String toString() {
			return "Cuenta [getTitular()=" + getTitular() + ", getSaldo()=" + getSaldo() + ", titular=" + titular
					+ ", saldo=" + saldo + ", creditoMax=" + creditoMax + "]";
		}


		/**
		 * Método que calcula los intereses de la cuenta coomo el producto del saldo por la tasa de interés
		 * @return
		 */
		public double calculaIntereses() {
			return this.saldo*Cuenta.intereses;
		}
		
		/** 
		 * Método de la clase que realiza una transferencia desde una cuenta a otra si hay suficiente saldo
		 * se borrará el saldo de la cuenta implicita y se la transferirá a la que está pasada como parámetro.
		 * Se le cobrará simpre una comisión de 5€ por tranferencia
		 * @param cDestino la cuenta a la que se tranfieren los fondos
		 * @param cantidad la cantidad a tranferir
		 * @return booelan true si hay sufuciente saldo entre la comision que se cobra y el dinero a tranferir 
		 *         false en caso contrario
		 */
		public boolean transferir(Cuenta cDestino, double cantidad) {
			boolean correcto=false;
			if (this.saldo>cantidad+5) {
				this.saldo=this.saldo-cantidad-Cuenta.comision;
				cDestino.saldo=cDestino.saldo+cantidad;
				correcto=true;
			}
			return correcto;
		}
}


