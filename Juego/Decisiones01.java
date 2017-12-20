import java.io.*;
import java.lang.Math;
import java.util.*;

//Programa que simula una aplicacion de BlackJack.

public class Decisiones01 {
	public static void main (String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//Declaracion de variables. NO HAY QUE METERLAS EN EL CODIGO
		String user;
		int JUGADOR [];
		int BANCA [];
		BANCA = new int [7];
		JUGADOR = new int [15];
		int decision;
		int totalj1 = 0;
		int totalj2 = 0;
		
		JUGADOR[0] = 5; //PROVISIONAL
		JUGADOR[1] = 5; //PROVISIONAL
		
		//PROVISIONAL
		int resp =0;  //PROVISIONAL 
		int capin = 100; //Capital inicial.
		int mano = 1; // Las manos que ha jugado el usuario, la inicializamos en 1.
		int bet; //La apuesta en cada mano, se suma a --capin-- o se resta a --capin--
		int ncarta; //Variable para generar carta aleatoria
		int cartamano = 0; //Variable que guarda las cartas que tiene el usuario en la mano.
		int banco = 1; //PROVISIONAL
		
		//variables para la condicion de carta aleatoria (para que no se pueda repetir una carta mas de 2 veces en una mano)
		int conta1 =0,conta2 =0,conta3 =0,conta4 =0,conta5 =0,conta6 =0,conta7 =0,conta8 =0,conta9 =0,conta10 =0,contaj =0,contaq =0,contak =0,contb1 =0,contb2 =0,contb3 =0,contb4 =0,contb5 =0,contb6 =0,contb7 =0,contb8 =0,contb9 =0,contb10 =0,contbj =0,contbq =0,contbk =0,contc1 =0,contc2 =0,contc3 =0,contc4 =0,contc5 =0,contc6 =0,contc7 =0,contc8 =0,contc9 =0,contc10 =0,contcj =0,contcq =0,contck =0,contd1 =0,contd2 =0,contd3 =0,contd4 =0,contd5 =0,contd6 =0,contd7 =0,contd8 =0,contd9 =0,contd10 =0,contdj =0,contdq =0,contdk =0;
		int miscojones =5;
		//Array para las cartas
		String[] carta = {"\uD83C\uDCA1","\uD83C\uDCA2","\uD83C\uDCA3","\uD83C\uDCA4","\uD83C\uDCA5","\uD83C\uDCA6","\uD83C\uDCA7","\uD83C\uDCA8","\uD83C\uDCA9","\uD83C\uDCAA","\uD83C\uDCAB","\uD83C\uDCAD","\uD83C\uDCAE","\uD83C\uDCB1","\uD83C\uDCB2","\uD83C\uDCB3","\uD83C\uDCB4","\uD83C\uDCB5","\uD83C\uDCB6","\uD83C\uDCB7","\uD83C\uDCB8","\uD83C\uDCB9","\uD83C\uDCBA","\uD83C\uDCBB","\uD83C\uDCBD","\uD83C\uDCBE","\uD83C\uDCC1","\uD83C\uDCC2","\uD83C\uDCC3","\uD83C\uDCC4","\uD83C\uDCC5","\uD83C\uDCC6","\uD83C\uDCC7","\uD83C\uDCC8","\uD83C\uDCC9","\uD83C\uDCCA","\uD83C\uDCCB","\uD83C\uDCCD","\uD83C\uDCCE","\uD83C\uDCD1","\uD83C\uDCD2","\uD83C\uDCD3","\uD83C\uDCD4","\uD83C\uDCD5","\uD83C\uDCD6","\uD83C\uDCD7","\uD83C\uDCD8","\uD83C\uDCD9","\uD83C\uDCDA","\uD83C\uDCDB","\uD83C\uDCDD","\uD83C\uDCDE"};
		
		//INTRODUCIR CODIGO A PARTIR DE AQUI
		do{
			if (JUGADOR[0] == JUGADOR[1]){ //Decisiones con posibilidad de separar
				System.out.println ("\nQue quiere hacer? ");
				System.out.println ("	1. Plantarse");
				System.out.println ("	2. Pedir carta");
				System.out.println ("	3. Separar cartas");
				user = reader.readLine();
				decision = Integer.parseInt(user);
				
				//Opción 1 (Plantarse)
				if (decision == 1){
					System.out.println("El valor de tus cartas suma un total de " + totalj1);
				} 
				//Opcion 2 (Pedir carta)
				else if (decision == 2) {
					ncarta = (int)(Math.random()*52+1); //Generamos la carta aleatoria
					//------------------------------------SUSTITUIR POR CODIGO NUEVO
					//palo PICAS (A-K)
					if (ncarta == 0 && conta1 <2){
						conta1 = conta1 +1;
						System.out.print(carta[ncarta]+"  "); 
						cartamano = cartamano+1;
						}
					else if (ncarta == 1 && conta2 <2){
						conta2 = conta2+1;
						System.out.print(carta[ncarta]+"  "); 
						cartamano = cartamano+1;
						}
					else if (ncarta == 2 && conta3 <2){
						conta3 = conta3+1;
						System.out.print(carta[ncarta]+"  "); 
						cartamano = cartamano+1;
						}
					else if (ncarta == 3 && conta4 <2){
						conta4 = conta4+1;
						System.out.print(carta[ncarta]+"  "); 
						cartamano = cartamano+1;
						}
					else if (ncarta == 4 && conta5 <2){
						conta5 = conta5+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 5 && conta6 <2){
						conta6 = conta6+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 6 && conta7 <2){
						conta7 = conta7+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 7 && conta8 <2){
						conta8 = conta8+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 8 && conta9 <2){
						conta9 = conta9+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 9 && conta10 <2){
						conta10 = conta10+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 10 && contaj <2){
						contaj = contaj+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 11 && contaq <2){
						contaq = contaq+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 12 && contak <2){
						contak = contak+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
				
					//PALO CORAZONES (A-K)
					else if (ncarta == 13 && contb1 <2){
						contb1 = contb1+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 14 && contb2 <2){
						contb2 = contb2+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 15 && contb3 <2){
						contb3 = contb3+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 16 && contb4 <2){
						contb4 = contb4+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 17 && contb5 <2){
						contb5 = contb5+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 18 && contb6 <2){
						contb6 = contb6+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 19 && contb7 <2){
						contb7 = contb7+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 20 && contb8 <2){
						contb8 = contb8+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 21 && contb9 <2){
						contb9 = contb9+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 22 && contb10 <2){
						contb10 = contb10+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 23 && contbj <2){
						contbj = contbj+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 24 && contbq <2){
						contbq = contbq+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 25 && contbk <2){
						contbk = contbk+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					
					//PALO DIAMANTES (A-K)
					else if (ncarta == 27 && contc1 <2){
						contc1 = contc1+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 28 && contc2 <2){
						contc2 = contc2+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 29 && contc3 <2){
						contc3 = contc3+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 30 && contc4 <2){
						contc4 = contc4+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 31 && contc5 <2){
						contc5 = contc5+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 32 && contc6 <2){
						contc6 = contc6+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 33 && contc7 <2){
						contc7 = contc7+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 34 && contc8 <2){
						contc8 = contc8+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 35 && contc9 <2){
						contc9 = contc9+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 36 && contc10 <2){
						contc10 = contc10+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 37 && contcj <2){
						contcj = contcj+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 38 && contcq <2){
						contcq = contcq+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 39 && contck <2){
						contck = contck+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
				
					//PALO TREBOLES (A-K)
					else if (ncarta == 40 && contd1 <2){
						contd1 = contd1+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 41 && contd2 <2){
						contd2 = contd2+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 42 && contd3 <2){
						contd3 = contd3+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 43 && contd4 <2){
						contd4 = contd4+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 44 && contd5 <2){
						contd5 = contd5+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 45 && contd6 <2){
						contd6 = contd6+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 46 && contd7 <2){
						contd7 = contd7+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 47 && contd8 <2){
						contd8 = contd8+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 48 && contd9 <2){
						contd9 = contd9+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 49 && contd10 <2){
						contd10 = contd10+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 50 && contdj <2){
						contdj = contdj+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 51 && contdq <2){
						contdq = contdq+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
					else if (ncarta == 52 && contdk <2){
						contdk = contdk+1;
						cartamano = cartamano+1;
						System.out.print(carta[ncarta]+"  "); 
						}
							
						}
				//Opcion 3 (Separar)
				else if (decision == 3){
					totalj1 = totalj1/2;
					totalj2 = totalj1;
						}
					} 
			//Decisiones sin posibilidad de separar
			else { 
				System.out.println ("Que quiere hacer? ");
				System.out.println ("	1. Plantarse");
				System.out.println ("	2. Pedir carta");
				user = reader.readLine();
				decision = Integer.parseInt(user);
				
				//Opción 1 (Plantarse)
				if (decision == 1){
					System.out.println("El valor de tus cartas suma un total de " + totalj1);
				} else if (decision == 2) { 
				
				//Opcion 2 (Pedir carta)
				
					
				}
			}
		} while (totalj1<21 && decision == 2);
	}
}
