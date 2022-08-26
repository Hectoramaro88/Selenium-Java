package com.java;

import com.access1.AccessModifier1;

public class Ejercicio5 extends AccessModifier1{

	public static void main(String[] args) {
		
//		Coche coche1 = new Coche();
//		coche1.llantas = 4;
//		coche1.asientos = 5;
//		coche1.ac = true;
//		coche1.marca = "BMW";
//		coche1.modelo = "2020";
//		coche1.motor = "Hibrido";
//		
//		System.out.println("El modelo del coche 1 es: "+ coche1.modelo);
//		
//		coche1.encendido();
//		coche1.acelerar();
//		
//		Coche coche2 = new Coche(2, 2, "Electrico", false, "Audi", "2021");
//		System.out.println("El modelo del coche 2 es: "+ coche2.modelo);
		
		Coche coche3 = new Coche(5, "2022");
		System.out.println("Mi coche 3 tiene "+ coche3.getLlantas() + " Llantas");
		coche3.setLlantas(1000);
		System.out.println("Mi coche 3 tiene "+ coche3.getLlantas() + " Llantas");
		
		
		// Ejercicio# 5
		
		/*
		 * Crear una clase que se llame Motos y vamos a crear 3 diferentes tipos de motos con estados y comportamientos.
		 */
		
		Motocicleta moto1 = new Motocicleta();
		moto1.acelerar();
//		moto1.llantas = 2;
		
		motos motos = new motos(1, "Ducati");
		System.out.println("mi motos tiene "+motos.getModelo()+" modelo");
		motos.acelerar();
		
		motos motos2 = new motos(2, "Ducati");
		motos2.setLlantas(2);
		motos2.frenar();
		
		motos motos3 = new motos(1, "Ducati");
		motos3.setMotor("rumrum");
		motos3.acelerar();

	
	}

}
