package ui;
import java.util.Scanner;

public class Integradora1 {
	
	public static void main(String[] args) {
		
		double Totaltodos = 0;
		int asiento = 3;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenid@ a la Calculadora de Vuelos ICESI Flight 1.0");
		System.out.println("¿Viaja solo o acompañado?: 1.Solo  2.Acompañado");
		System.out.println("¡Recuerda constestar solo con los numeros dados en las opciones! ");
		int pasajeros = sc.nextInt();
		
		Double[] totalboleto = new Double[rep(pasajeros)+1];  
		for (int i = 1; i <= rep(pasajeros); i++) {
			System.out.println("Introduce el peso de tu equipaje en kg para la persona #" + i);
			
			int KgMaleta = sc.nextInt();
			System.out.println(ofrecer(KgMaleta));
			System.out.println("Cual deseas elegir? 1[XS]  2[S]  3[M]");
			
			int eleccion = sc.nextInt();
			System.out.println("El precio seria de: $" + Tarifa(eleccion));
			System.out.println(escogerAsiento(eleccion));
			
			int silla = sc.nextInt();
			if (silla==1 || eleccion==3){
				System.out.println("¿Optarás por tener asiento en 1[Pasillo], 2[En medio] ó 3[Ventana]?");
				asiento = sc.nextInt();
				System.out.println("Has elegido el: " + asientoSeleccionado(asiento));
			}
			
			System.out.println("¿Desea llevar una maleta adicional de 10 kg? se debe pagar un valor de $50.000 por cada maleta. (Máximo 3 maletas adicionales de 10 kg"
			+ "."
			+ "Digite el numero de maletas:"
			+ "."
			+ "1[1] 2[2] 3[3] 4[0]");
			int adicionalDiezKg = sc.nextInt();
			
			System.out.println("¿Desea llevar una maleta adicional de 23 kg? se debe pagar un valor de $100.000 por cada maleta. (Máximo 2 maletas adicionales de 23 kg"
			+ "."
			+ "Digite el numero de maletas:"
			+ "."
			+ "1[1] 2[2] 3[0]");
			int ad23Kg = sc.nextInt();
			
			totalboleto[i] = Tarifa(eleccion) + eleccionSilla(silla) + asientoVentPas(asiento) + adicional10kg(ad10kg) + adicional23kg(ad23Kg);
			
			System.out.println("¡Listo! el precio total de el pasajero: " + i +" es de: $" + totalboleto[i] );
			
			Totaltodos += totalboleto[i];
		}
		System.out.println("El precio total de $" + Totaltodos
		+ "."
		+"¡Nos vemos en las nubes!");


	}
	
	/**
	Metodo 1: recomendacion
	Descripcion: Se le ofrece al usuario una tarifa dependiendo del peso de la maleta del usuario 
	@param KgMaleta, tipo int, es para saber que tarifa se ajusta a el peso
	@return String ofrecer, es la tarifa que se le va a ofrecer al usuario 
	**/
	public static String ofrecer (int KgMaleta){
	String ofrecer = ("");
	String Recomendacion = ("¡Excelente!, puedo ofrecer para ti las siguientes tarifas: ");
	if (KgMaleta<=3) {
		ofrecer=(Recomendacion
		+ "\n"
		+ "Tarifa XS, con un costo de $175.000 donde tendrás artículo personal.");
	}else if (KgMaleta <= 13) {
		ofrecer=(Recomendacion
		+ "\n"
		+ "Tarifa S, con un costo de $218.750 donde tendrás artículo personal y maleta en cabina de 10 kg.");		
	}else if (KgMaleta > 13) {
		ofrecer=(Recomendacion
		+ "\n"
		+ "Tarifa M, con un costo de $284.375 donde tendrás artículo personal, 1 maleta en cabina de 10 kg, 1 maleta documentada en bodega de 23 kg y la elección de tu asiento.");	
	}
	return ofrecer;
	}	
	
	/**
	Metodo 2: Tarifa
	Descripcion: Este metodo permite calcular el precio base de cada tarifa
	@param eleccion, tipo int, es la tarifa elegida por el usuario 
	@return Double precioTarifa, el precio de la tarifa seguiendo la formula: precioTarifa = PrecioTarifaAnterior +(PorcentajeComodidad *PrecioTarifaAnterior)
	**/
	public static double Tarifa (int eleccion) {
		
	double precioTarifa=0;
	int precioXS=175000;
	switch(eleccion){
	case 1:
		precioTarifa = precioXS; //Es el precio base
		break;
	case 2:
		precioTarifa = (precioXS*1.25); //Formula PrecioTarifa = PrecioTarifaAnterior +(PorcentajeComodidad *PrecioTarifaAnterior) 
		break;
	case 3:
		precioTarifa =((precioXS*1.25) + (0.30 * (precioXS*1.25))); //Formula PrecioTarifa = (Preciobase*1.25)+( PorcentajeComodidad *PrecioTarifaAnterior) 
		break;
	}
	return precioTarifa;
	} 	
	
	/**
	Metodo 3: escogerAsiento
	Descripcion: Este metodo permite preguntar al usuario si desea escoger el asiento por un coste adicional, pero si es tarifa M ya viene incluido pero venta y pasillo cuestan adicionalmente
	@param eleccion, tipo int,  es la tarifa ingresada por el usuario, para saber que tipo de eleccion se debe mostrar
	@return String escogerAsiento
	**/
	public static String escogerAsiento(int eleccion){
	
	String escogerAsiento = ("");
	switch(eleccion) {
	case 1:
		escogerAsiento = ("¡Excelente elección! Al ser tarifa XS, tienes la posibilidad de elegir asiento con un coste adicional de $50.000 si lo deseas." 
		+ "."
		+ "¿Tomarás esta opción? 1[SI] 2[NO]");
		break;
	case 2:
		escogerAsiento = ("¡Excelente elección! Al ser tarifa S, tienes la posibilidad de elegir asiento con un coste adicional de $50.000 si lo deseas." 
		+ "."
		+ "¿Tomarás esta opción? 1[SI] 2[NO]");
		break;
	case 3:
		escogerAsiento = ("¡Excelente elección! Al ser tarifa M, tendrás elección de asiento antes del check-in incluida en tu precio."
		+ "."
		+ "Si el asiento resulta estar en pasillo o ventana, tendrá un costo adicional de $15.000"
		+ "."
		+ "¿Optarás por tener elegir asiento 1[SI] 2[NO]");
		break;
	}
	return escogerAsiento;
	}
	
	/**
	Metodo 4: eleccionSilla
	Descripcion: El metodo, en caso de que el usuario haya elegido comprar silla (no aplica para M), almacenara el valor de el precio 
	adicional que tenia la eleccion de la silla
	@param silla, tipo int, si el usuario decidio comprar silla o no
	@return int precio, el precio adicional por haber comprado la silla
	**/
	public static int eleccionSilla(int silla) {
	int precio = 0;
	switch(silla) {
	case 1:
		precio = 50000;
		break;
	case 2:
		precio = 0;
		break;
	}
	return precio;
	}
	
	/**
	Metodo 5: asientoVentPas
	Descripcion: El metodo, en caso de que el usuario selecciones (1)pasillo o (3)ventana se le adiciona un costo a la tarifa M, las tarifas XS,S no aplican
	@param asiento, tipo int, el asiento que eligio el usuario 
	@return double adicionalVentPas, es el precio adicional de la ventano o el pasillo en la tarifa M
	**/
	public static double asientoVentPas(int asiento) {
	double adicionalVentPas = 0;	
	if (asiento==1 || asiento==3){
		adicionalVentPas = 15000;
	} else {
		adicionalVentPas = 0;
	}
	return adicionalVentPas;
	}

	/**
	Metodo 6: adicionalesDiez
	Descripcion: Calcula el precio de las maletas adicionales de 10kg que el usuario adicionara
	@param adicionalDiezKg, tipo int, la cantidad de maletas que el usuario adicionara
	@return double precioMaletasDiez, el precio de las maletas de 10kg adicionadas por el usuario 
	**/
	public static double adicional10kg(int ad10kg) {
	double precioMaletasDiez = 50000;
	switch(ad10kg){
	case 1: 
		precioMaletasDiez = 50000;
		break;
	case 2:
		precioMaletasDiez *= 2;
		break;
	case 3:
		precioMaletasDiez *= 3;
		break;
	case 4:
		precioMaletasDiez = 0;
		break;
	}
	return precioMaletasDiez;
	}
	
	/**
	Metodo 7: adicional23kg
	Descripcion: Permite calcular el precio de las maletas adicionales de 23kg
	@param adicionalVeintTresKg, tipo int, la cantidad de maletas que el usuario va a adicionar
	@return double maleta23kg, el precio de las maletas de 23kg adcionadas por el usuario 
	**/
	public static double adicional23kg(int ad23Kg) {
	double maleta23kg = 100000;
	switch(ad23Kg){
	case 1: 
		maleta23kg = 100000;
		break;
	case 2:
		maleta23kg *= 2;
		break;
	case 3:
		maleta23kg = 0;
		break;	
	}
	return maleta23kg;
	}
	
	/**
	Metodo 8: rep
	Descripcion: Este metodo determina las veces que se repite el proceso el cual calcula el precio del boleto
	@param pasajeros, tipo int, el usuario elige si viaja solo o acompañado
	@return int rep, son las veces que se repite en caso de que vaya solo o acompañado
	**/
	public static int rep (int pasajeros) {
	int rep = 0;
	if (pasajeros==1) {
	rep = 1;
	} else {
	rep= 3;
	}
	return rep;
	}	
}