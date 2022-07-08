package ppal;

import modelo.CuentaJoven;
import modelo.Persona;

public class Principal {

	public static void main(String[] args) {
		
		Persona p = new Persona("Paco",20,"1111111f");
		Persona r = new Persona("Rafa",35,"4584585f");
		
			
		CuentaJoven c1 = new CuentaJoven(p, 6, true);
		CuentaJoven c2 = new CuentaJoven(r,2,false);
		
		System.out.println("-----Añadiendo nuevas CuentaJoven------");
		System.out.println(c1);
		System.out.println("---------------------------------");
		System.out.println(c2);
		System.out.println("---------------------------------");
		System.out.println("Calculando intereses------");
		c1.ingresar(1200);
		System.out.println("Los interesese de la cuenta c1 son: "+c1.calculaIntereses());
		
		System.out.println("Transfiriendo 200 euros de c1 a c2");
		c1.transferir(c2, 200);
		System.out.println("La cuenta c1 ahora tiene "+c1.getSaldo());
		
		

	}

}
