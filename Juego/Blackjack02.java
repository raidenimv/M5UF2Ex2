import java.io.*;
import java.lang.Math;
import java.util.*;
// ESTA PUESTO QUE SEA SIEMPRE NCARTA 0 PARA EL JUGADOR == ONNNNNNN
/*for (i = 0; i < cartabanca; i++){
						System.out.print(carta[BANCA[i]]+"  ");
					}*/


//Programa que simula una aplicacion de BlackJack.

public class Blackjack02 {
	
	public static void main (String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//Declaracion de variables
		String user; 
		int fija =1; //PROVISIONAL  linea 40
		int resp =0;  //PROVISIONAL  linea 903
		int banco = 1; //PROVISIONAL linea 149
		
		int tt = 0;
		int decision;
		int capin = 100; //Capital inicial.
		int ronda = 1; // Las manos que ha jugado el usuario, la inicializamos en 1.
		int bet; //La apuesta en cada mano, se suma a --capin-- o se resta a --capin--
		int ncarta; //Variable para generar carta aleatoria
		int cartamano = 0; //Variable que guarda las cartas que tiene el usuario en la mano.
		int cartabanca = 0;
		int totalbanca = 0; //Suma total cartas de la banca
		int totalj1 = 0; //Suma total jugador con 1 mano
		int i;
		
		
		//variables para la condicion de carta aleatoria (para que no se pueda repetir una carta mas de 2 veces en una mano)
		int conta1 =0,conta2 =0,conta3 =0,conta4 =0,conta5 =0,conta6 =0,conta7 =0,conta8 =0,conta9 =0,conta10 =0,contaj =0,contaq =0,contak =0,contb1 =0,contb2 =0,contb3 =0,contb4 =0,contb5 =0,contb6 =0,contb7 =0,contb8 =0,contb9 =0,contb10 =0,contbj =0,contbq =0,contbk =0,contc1 =0,contc2 =0,contc3 =0,contc4 =0,contc5 =0,contc6 =0,contc7 =0,contc8 =0,contc9 =0,contc10 =0,contcj =0,contcq =0,contck =0,contd1 =0,contd2 =0,contd3 =0,contd4 =0,contd5 =0,contd6 =0,contd7 =0,contd8 =0,contd9 =0,contd10 =0,contdj =0,contdq =0,contdk =0;
		
		//Array para las cartas
		String[] carta = {"\uD83C\uDCA1","\uD83C\uDCA2","\uD83C\uDCA3","\uD83C\uDCA4","\uD83C\uDCA5","\uD83C\uDCA6","\uD83C\uDCA7","\uD83C\uDCA8","\uD83C\uDCA9","\uD83C\uDCAA","\uD83C\uDCAB","\uD83C\uDCAD","\uD83C\uDCAE","\uD83C\uDCB1","\uD83C\uDCB2","\uD83C\uDCB3","\uD83C\uDCB4","\uD83C\uDCB5","\uD83C\uDCB6","\uD83C\uDCB7","\uD83C\uDCB8","\uD83C\uDCB9","\uD83C\uDCBA","\uD83C\uDCBB","\uD83C\uDCBD","\uD83C\uDCBE","\uD83C\uDCC1","\uD83C\uDCC2","\uD83C\uDCC3","\uD83C\uDCC4","\uD83C\uDCC5","\uD83C\uDCC6","\uD83C\uDCC7","\uD83C\uDCC8","\uD83C\uDCC9","\uD83C\uDCCA","\uD83C\uDCCB","\uD83C\uDCCD","\uD83C\uDCCE","\uD83C\uDCD1","\uD83C\uDCD2","\uD83C\uDCD3","\uD83C\uDCD4","\uD83C\uDCD5","\uD83C\uDCD6","\uD83C\uDCD7","\uD83C\uDCD8","\uD83C\uDCD9","\uD83C\uDCDA","\uD83C\uDCDB","\uD83C\uDCDD","\uD83C\uDCDE"};
		int JUGADOR [];
		int BANCA [];
		JUGADOR = new int [15]; //array para las cartas del jugador
		
		BANCA = new int [15]; //array para las cartas de la banca
		
		//Presentacion Programa
		System.out.println("\uD83C\uDCBF"+" TE DAMOS LA BIENVENIDA AL BLACK JACK "+"\uD83C\uDCBF");
		System.out.println("---------------------------------------------");
		System.out.println("Aqui tiene el paquete de bienvenida: 100฿"+"\nApueste con moderacion, es su responsabilidad");
		System.out.println("---------------------------------------------");
		//Bucle do while que engloba toda la "mano" del BJ, de esta manera podemos repetir el proceso rapidamente.
		do{
		System.out.println("");
		System.out.println("Comienzo de la ronda "+ronda+":"); //Presentamos la "mano" que se va a jugar
		System.out.println("Realize su apuesta por favor: ");//Recogemos la apuesta deseada
		user = reader.readLine();
		bet = Integer.parseInt(user);
		
		//Limpiamos Pantalla
		System.out.print("\033[H\033[2J");
		System.out.flush();
		//Imprimir Interfaz
		System.out.println("+-----------------------------------------------------------+");
		System.out.println("| DINERO TOTAL: "+capin+"฿	  RONDA: "+ronda+"	APUESTA ACTUAL: "+bet+"฿  |");
		System.out.println("+-----------------------------------------------------------+");


		//Cartas del crupier
		ncarta = (int)(Math.random()*51+1); //Generamos la carta aleatoria del crupier
		System.out.println ("La Mano de la banca es: \n");
		//MANO BANCA
		if (banco == 1){
		//palo PICAS (A-K)
			if (ncarta == 0 && conta1 < 2){
				conta1 = conta1 + 1 ;
				System.out.print(carta[ncarta]+"  "); 
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				totalbanca = totalbanca + 11;
				if (totalbanca > 21){
					if (BANCA[cartabanca-2] == 0 || BANCA[cartabanca-2] == 13 ||BANCA[cartabanca-2] == 26 || BANCA[cartabanca-2] == 39){
							totalbanca = totalbanca -10;
						}
					totalbanca = totalbanca - 10;
					} //_---------------------------------------------------------------------------------------------------------->
				}
			else if (ncarta == 1 && conta2 < 2){
				conta2 = conta2 + 1;
				System.out.print(carta[ncarta]+"  "); 
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				totalbanca = totalbanca + 2;
				}
			else if (ncarta == 2 && conta3 < 2){
				conta3 = conta3 + 1;
				System.out.print(carta[ncarta]+"  "); 
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				totalbanca = totalbanca + 3;
				}
			else if (ncarta == 3 && conta4 < 2){
				conta4 = conta4 + 1;
				System.out.print(carta[ncarta]+"  "); 
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				totalbanca = totalbanca + 4;
				}
			else if (ncarta == 4 && conta5 < 2){
				conta5 = conta5 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 5;
				}
			else if (ncarta == 5 && conta6 < 2){
				conta6 = conta6 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  ");
				totalbanca = totalbanca + 6; 
				}
			else if (ncarta == 6 && conta7 < 2){
				conta7 = conta7 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 7;
				}
			else if (ncarta == 7 && conta8 < 2){
				conta8 = conta8 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 8;
				}
			else if (ncarta == 8 && conta9 < 2){
				conta9 = conta9 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 9;
				}
			else if (ncarta == 9 && conta10 < 2){
				conta10 = conta10 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			else if (ncarta == 10 && contaj < 2){
				contaj = contaj + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			else if (ncarta == 11 && contaq < 2){
				contaq = contaq + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			else if (ncarta == 12 && contak < 2){
				contak = contak + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
		
			//PALO CORAZONES (A-K)
			else if (ncarta == 13 && contb1 < 2){
				contb1 = contb1 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 11;
				if (totalbanca > 21){
					if (BANCA[cartabanca-2] == 0 || BANCA[cartabanca-2] == 13 ||BANCA[cartabanca-2] == 26 || BANCA[cartabanca-2] == 39){
							totalbanca = totalbanca -10;
						}
					totalbanca = totalbanca -10;
				}
				}
			else if (ncarta == 14 && contb2 < 2){
				contb2 = contb2 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 2;
				}
			else if (ncarta == 15 && contb3 < 2){
				contb3 = contb3 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 3;
				}
			else if (ncarta == 16 && contb4 < 2){
				contb4 = contb4 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 4;
				}
			else if (ncarta == 17 && contb5 < 2){
				contb5 = contb5 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 5;
				}
			else if (ncarta == 18 && contb6 < 2){
				contb6 = contb6 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 6;
				}
			else if (ncarta == 19 && contb7 < 2){
				contb7 = contb7 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 7;
				}
			else if (ncarta == 20 && contb8 < 2){
				contb8 = contb8 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 8;
				}
			else if (ncarta == 21 && contb9 < 2){
				contb9 = contb9 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 9;
				}
			else if (ncarta == 22 && contb10 < 2){
				contb10 = contb10 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			else if (ncarta == 23 && contbj < 2){
				contbj = contbj + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			else if (ncarta == 24 && contbq < 2){
				contbq = contbq + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			else if (ncarta == 25 && contbk < 2){
				contbk = contbk + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			
			//PALO DIAMANTES (A-K)
			else if (ncarta == 26 && contc1 < 2){
				contc1 = contc1 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 11; 
				if (totalbanca > 21){
					if (BANCA[cartabanca-2] == 0 || BANCA[cartabanca-2] == 13 ||BANCA[cartabanca-2] == 26 || BANCA[cartabanca-2] == 39){
							totalbanca = totalbanca -10;
						}
					totalbanca = totalbanca -10;
				}
				}
			else if (ncarta == 27 && contc2 < 2){
				contc2 = contc2 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 2;
				}
			else if (ncarta == 28 && contc3 < 2){
				contc3 = contc3 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 3;
				}
			else if (ncarta == 29 && contc4 < 2){
				contc4 = contc4 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 4;
				}
			else if (ncarta == 30 && contc5 < 2){
				contc5 = contc5 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 5;
				}
			else if (ncarta == 31 && contc6 < 2){
				contc6 = contc6 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 6;
				}
			else if (ncarta == 32 && contc7 < 2){
				contc7 = contc7 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 7;
				}
			else if (ncarta == 33 && contc8 < 2){
				contc8 = contc8 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 8;
				}
			else if (ncarta == 34 && contc9 < 2){
				contc9 = contc9 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 9;
				}
			else if (ncarta == 35 && contc10 < 2){
				contc10 = contc10 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			else if (ncarta == 36 && contcj < 2){
				contcj = contcj + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			else if (ncarta == 37 && contcq < 2){
				contcq = contcq + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			else if (ncarta == 38 && contck < 2){
				contck = contck + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
		
			//PALO TREBOLES (A-K)
			else if (ncarta == 39 && contd1 < 2){
				contd1 = contd1 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 11;
				if (totalbanca > 21){
					if (BANCA[cartabanca-2] == 0 || BANCA[cartabanca-2] == 13 ||BANCA[cartabanca-2] == 26 || BANCA[cartabanca-2] == 39){
							totalbanca = totalbanca -10;
						}
					totalbanca = totalbanca - 10;
				}
				}
			else if (ncarta == 40 && contd2 < 2){
				contd2 = contd2 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 2;
				}
			else if (ncarta == 41 && contd3 < 2){
				contd3 = contd3 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 3;
				}
			else if (ncarta == 42 && contd4 < 2){
				contd4 = contd4 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 4;
				}
			else if (ncarta == 43 && contd5 < 2){
				contd5 = contd5 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 5;
				}
			else if (ncarta == 44 && contd6 < 2){
				contd6 = contd6 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 6;
				}
			else if (ncarta == 45 && contd7 < 2){
				contd7 = contd7 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 7;
				}
			else if (ncarta == 46 && contd8 < 2){
				contd8 = contd8 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 8;
				}
			else if (ncarta == 47 && contd9 < 2){
				contd9 = contd9 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 9;
				}
			else if (ncarta == 48 && contd10 < 2){
				contd10 = contd10 + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			else if (ncarta == 49 && contdj < 2){
				contdj = contdj + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			else if (ncarta == 50 && contdq < 2){
				contdq = contdq + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			else if (ncarta == 51 && contdk < 2){
				contdk = contdk + 1;
				BANCA[cartabanca] = ncarta;
				cartabanca = cartabanca+ 1 ;
				System.out.print(carta[ncarta]+"  "); 
				totalbanca = totalbanca + 10;
				}
			}
		
		System.out.print("\uD83C\uDCA0");
		System.out.println ("\n\nSu mano es: \n");
		//MANO JUGADOR
		do{
			ncarta = (int)(Math.random()*51+1); //Generamos la carta aleatoria.
						//palo PICAS (A-K)
			if (ncarta == 0 && conta1 < 2){
				conta1 = conta1 + 1;
				JUGADOR[cartamano] = ncarta;
				System.out.print(carta[ncarta]+"  "); 
				cartamano = cartamano + 1;
				totalj1 = totalj1 + 11;
				if (totalj1 > 21){
					if (JUGADOR[cartamano-2] == 0 || JUGADOR[cartamano-2] == 13 ||JUGADOR[cartamano-2] == 26 || JUGADOR[cartamano-2] == 39){
							totalj1 = totalj1 -10;
						}
					totalj1 = totalj1 -10;
				}
				
				}
			else if (ncarta == 1 && conta2 < 2){
				conta2 = conta2 + 1;
				JUGADOR[cartamano] = ncarta;
				System.out.print(carta[ncarta]+"  "); 
				cartamano = cartamano + 1;
				totalj1 = totalj1 + 2;
				}
			else if (ncarta == 2 && conta3 < 2){
				conta3 = conta3 + 1;
				JUGADOR[cartamano] = ncarta;
				System.out.print(carta[ncarta]+"  "); 
				cartamano = cartamano + 1;
				totalj1 = totalj1 + 3;
				}
			else if (ncarta == 3 && conta4 < 2){
				conta4 = conta4 + 1;
				JUGADOR[cartamano] = ncarta;
				System.out.print(carta[ncarta]+"  "); 
				cartamano = cartamano + 1;
				totalj1 = totalj1 + 4;
				}
			else if (ncarta == 4 && conta5 < 2){
				conta5 = conta5 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 5;
				}
			else if (ncarta == 5 && conta6 < 2){
				conta6 = conta6 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 6;
				}
			else if (ncarta == 6 && conta7 < 2){
				conta7 = conta7 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 7;
				}
			else if (ncarta == 7 && conta8 < 2){
				conta8 = conta8 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 8;
				}
			else if (ncarta == 8 && conta9 < 2){
				conta9 = conta9 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 9;
				}
			else if (ncarta == 9 && conta10 < 2){
				conta10 = conta10 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			else if (ncarta == 10 && contaj < 2){
				contaj = contaj + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			else if (ncarta == 11 && contaq < 2){
				contaq = contaq + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			else if (ncarta == 12 && contak <2){
				contak = contak + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
		
			//PALO CORAZONES (A-K)
			else if (ncarta == 13 && contb1 < 2){
				contb1 = contb1 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 11;
				if (totalj1 > 21){
					if (JUGADOR[cartamano-2] == 0 || JUGADOR[cartamano-2] == 13 ||JUGADOR[cartamano-2] == 26 || JUGADOR[cartamano-2] == 39){
							totalj1 = totalj1 -10;
						}
					totalj1 = totalj1 -10;
				}
				}
			else if (ncarta == 14 && contb2 < 2){
				contb2 = contb2 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 2;
				}
			else if (ncarta == 15 && contb3 < 2){
				contb3 = contb3 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 3;
				}
			else if (ncarta == 16 && contb4 < 2){
				contb4 = contb4 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 4;
				}
			else if (ncarta == 17 && contb5 < 2){
				contb5 = contb5 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 5;
				}
			else if (ncarta == 18 && contb6 < 2){
				contb6 = contb6 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 6;
				}
			else if (ncarta == 19 && contb7 < 2){
				contb7 = contb7 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 7;
				}
			else if (ncarta == 20 && contb8 < 2){
				contb8 = contb8 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 8;
				}
			else if (ncarta == 21 && contb9 < 2){
				contb9 = contb9 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 9;
				}
			else if (ncarta == 22 && contb10 < 2){
				contb10 = contb10 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			else if (ncarta == 23 && contbj < 2){
				contbj = contbj + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			else if (ncarta == 24 && contbq < 2){
				contbq = contbq + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			else if (ncarta == 25 && contbk < 2){
				contbk = contbk + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			
			//PALO DIAMANTES (A-K)
			else if (ncarta == 26 && contc1 < 2){
				contc1 = contc1 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 11;
				if (totalj1 > 21){
					if (JUGADOR[cartamano-2] == 0 || JUGADOR[cartamano-2] == 13 ||JUGADOR[cartamano-2] == 26 || JUGADOR[cartamano-2] == 39){
							totalj1 = totalj1 -10;
						}
					totalj1 = totalj1 -10;
				}
				}
			else if (ncarta == 27 && contc2 < 2){
				contc2 = contc2 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 2;
				}
			else if (ncarta == 28 && contc3 < 2){
				contc3 = contc3 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 3;
				}
			else if (ncarta == 29 && contc4 < 2){
				contc4 = contc4 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 4;
				}
			else if (ncarta == 30 && contc5 < 2){
				contc5 = contc5 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 5;
				}
			else if (ncarta == 31 && contc6 < 2){
				contc6 = contc6 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 6;
				}
			else if (ncarta == 32 && contc7 < 2){
				contc7 = contc7 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 7;
				}
			else if (ncarta == 33 && contc8 < 2){
				contc8 = contc8 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 8;
				}
			else if (ncarta == 34 && contc9 < 2){
				contc9 = contc9 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 9;
				}
			else if (ncarta == 35 && contc10 < 2){
				contc10 = contc10 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			else if (ncarta == 36 && contcj < 2){
				contcj = contcj + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			else if (ncarta == 37 && contcq < 2){
				contcq = contcq + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			else if (ncarta == 38 && contck < 2){
				contck = contck + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
		
			//PALO TREBOLES (A-K)
			else if (ncarta == 39 && contd1 < 2){
				contd1 = contd1 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 11;
				if (totalj1 > 21){
					if (JUGADOR[cartamano-2] == 0 || JUGADOR[cartamano-2] == 13 ||JUGADOR[cartamano-2] == 26 || JUGADOR[cartamano-2] == 39){
							totalj1 = totalj1 -10;
						}
					totalj1 = totalj1 -10;
				}
				}
			else if (ncarta == 40 && contd2 < 2){
				contd2 = contd2 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 2;
				}
			else if (ncarta == 41 && contd3 < 2){
				contd3 = contd3 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 3;
				}
			else if (ncarta == 42 && contd4 < 2){
				contd4 = contd4 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 4;
				}
			else if (ncarta == 43 && contd5 < 2){
				contd5 = contd5 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 5;
				}
			else if (ncarta == 44 && contd6 < 2){
				contd6 = contd6 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 6;
				}
			else if (ncarta == 45 && contd7 < 2){
				contd7 = contd7 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 7;
				}
			else if (ncarta == 46 && contd8 < 2){
				contd8 = contd8 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 8;
				}
			else if (ncarta == 47 && contd9 < 2){
				contd9 = contd9 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 9;
				}
			else if (ncarta == 48 && contd10 < 2){
				contd10 = contd10 + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			else if (ncarta == 49 && contdj < 2){
				contdj = contdj + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			else if (ncarta == 50 && contdq < 2){
				contdq = contdq + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
			else if (ncarta == 51 && contdk <2){
				contdk = contdk + 1;
				JUGADOR[cartamano] = ncarta;
				cartamano = cartamano + 1;
				System.out.print(carta[ncarta]+"  "); 
				totalj1 = totalj1 + 10;
				}
				
		}while(cartamano < 2);
		//CODIGO JESSY 
		do{
			 //Decisiones
			System.out.println ("\n\nQue quiere hacer? ");
			System.out.println ("	1. Plantarse");
			System.out.println ("	2. Pedir carta");
			
			user = reader.readLine();
			decision = Integer.parseInt(user);
			
			//Opción 1 (Plantarse)
			if (decision == 1){
				do{
					ncarta = (int)(Math.random()*51+1); //Generamos la segunda carta del crupier
					if (ncarta == 0 && conta1 < 2){
					conta1 = conta1 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 11;
					if (totalbanca > 21){
						if (BANCA[cartabanca-2] == 0 || BANCA[cartabanca-2] == 13 ||BANCA[cartabanca-2] == 26 || BANCA[cartabanca-2] == 39){
							totalbanca = totalbanca -10;
						}
						totalbanca = totalbanca -10;
					}
					}
				else if (ncarta == 1 && conta2 < 2){
					conta2 = conta2 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 2;
					}
				else if (ncarta == 2 && conta3 < 2){
					conta3 = conta3 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 3;
					}
				else if (ncarta == 3 && conta4 < 2){
					conta4 = conta4 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 4;
					}
				else if (ncarta == 4 && conta5 < 2){
					conta5 = conta5 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 5;
					}
				else if (ncarta == 5 && conta6 < 2){
					conta6 = conta6 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 6;
					}
				else if (ncarta == 6 && conta7 < 2){
					conta7 = conta7 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 7;
					}
				else if (ncarta == 7 && conta8 < 2){
					conta8 = conta8 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 8;
					}
				else if (ncarta == 8 && conta9 < 2){
					conta9 = conta9 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 9;
					}
				else if (ncarta == 9 && conta10 < 2){
					conta10 = conta10 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				else if (ncarta == 10 && contaj < 2){
					contaj = contaj + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				else if (ncarta == 11 && contaq < 2){
					contaq = contaq + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				else if (ncarta == 12 && contak <2){
					contak = contak + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
			
				//PALO CORAZONES (A-K)
				else if (ncarta == 13 && contb1 < 2){
					contb1 = contb1 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 11;
					if (totalbanca > 21){
						if (BANCA[cartabanca-2] == 0 || BANCA[cartabanca-2] == 13 ||BANCA[cartabanca-2] == 26 || BANCA[cartabanca-2] == 39){
							totalbanca = totalbanca -10;
						}
						totalbanca = totalbanca -10;
					}
					}
				else if (ncarta == 14 && contb2 < 2){
					contb2 = contb2 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 2;
					}
				else if (ncarta == 15 && contb3 < 2){
					contb3 = contb3 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 3;
					}
				else if (ncarta == 16 && contb4 < 2){
					contb4 = contb4 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 4;
					}
				else if (ncarta == 17 && contb5 < 2){
					contb5 = contb5 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 5;
					}
				else if (ncarta == 18 && contb6 < 2){
					contb6 = contb6 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 6;
					}
				else if (ncarta == 19 && contb7 < 2){
					contb7 = contb7 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 7;
					}
				else if (ncarta == 20 && contb8 < 2){
					contb8 = contb8 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 8;
					}
				else if (ncarta == 21 && contb9 < 2){
					contb9 = contb9 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 9;
					}
				else if (ncarta == 22 && contb10 < 2){
					contb10 = contb10 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				else if (ncarta == 23 && contbj < 2){
					contbj = contbj + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				else if (ncarta == 24 && contbq < 2){
					contbq = contbq + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				else if (ncarta == 25 && contbk < 2){
					contbk = contbk + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				
				//PALO DIAMANTES (A-K)
				else if (ncarta == 26 && contc1 < 2){
					contc1 = contc1 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 11;
					if (totalbanca > 21){
						if (BANCA[cartabanca-2] == 0 || BANCA[cartabanca-2] == 13 ||BANCA[cartabanca-2] == 26 || BANCA[cartabanca-2] == 39){
							totalbanca = totalbanca -10;
						}
						totalbanca = totalbanca -10;
					}
					}
				else if (ncarta == 27 && contc2 < 2){
					contc2 = contc2 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 2;
					}
				else if (ncarta == 28 && contc3 < 2){
					contc3 = contc3 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 3;
					}
				else if (ncarta == 29 && contc4 < 2){
					contc4 = contc4 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 4;
					}
				else if (ncarta == 30 && contc5 < 2){
					contc5 = contc5 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 5;
					}
				else if (ncarta == 31 && contc6 < 2){
					contc6 = contc6 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 6;
					}
				else if (ncarta == 32 && contc7 < 2){
					contc7 = contc7 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 7;
					}
				else if (ncarta == 33 && contc8 < 2){
					contc8 = contc8 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 8;
					}
				else if (ncarta == 34 && contc9 < 2){
					contc9 = contc9 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 9;
					}
				else if (ncarta == 35 && contc10 < 2){
					contc10 = contc10 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				else if (ncarta == 36 && contcj < 2){
					contcj = contcj + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				else if (ncarta == 37 && contcq < 2){
					contcq = contcq + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				else if (ncarta == 38 && contck < 2){
					contck = contck + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
			
				//PALO TREBOLES (A-K)
				else if (ncarta == 39 && contd1 < 2){
					contd1 = contd1 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 11;
					if (totalbanca > 21){
						if (BANCA[cartabanca-2] == 0 || BANCA[cartabanca-2] == 13 ||BANCA[cartabanca-2] == 26 || BANCA[cartabanca-2] == 39){
							totalbanca = totalbanca -10;
						}
						totalbanca = totalbanca -10;
					}
					}
				else if (ncarta == 40 && contd2 < 2){
					contd2 = contd2 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 2;
					}
				else if (ncarta == 41 && contd3 < 2){
					contd3 = contd3 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 3;
					}
				else if (ncarta == 42 && contd4 < 2){
					contd4 = contd4 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 4;
					}
				else if (ncarta == 43 && contd5 < 2){
					contd5 = contd5 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 5;
					}
				else if (ncarta == 44 && contd6 < 2){
					contd6 = contd6 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 6;
					}
				else if (ncarta == 45 && contd7 < 2){
					contd7 = contd7 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 7;
					}
				else if (ncarta == 46 && contd8 < 2){
					contd8 = contd8 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 8;
					}
				else if (ncarta == 47 && contd9 < 2){
					contd9 = contd9 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 9;
					}
				else if (ncarta == 48 && contd10 < 2){
					contd10 = contd10 + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				else if (ncarta == 49 && contdj < 2){
					contdj = contdj + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				else if (ncarta == 50 && contdq < 2){
					contdq = contdq + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				else if (ncarta == 51 && contdk <2){
					contdk = contdk + 1;
					BANCA[cartabanca] = ncarta;
					cartabanca = cartabanca + 1;
					totalbanca = totalbanca + 10;
					}
				}while (totalbanca < 16);
		
			}
			//Opcion 2 (Pedir carta) TRABAJAMOS AQUI -----------------///////////////////////////////////////////////////////////////////////////////
			else if (decision == 2) {
				ncarta = (int)(Math.random()*51+1); //Generamos la carta aleatoria
				tt = tt+1;
				if (ncarta == 0 && conta1 < 2){
					conta1 = conta1 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 11;
					if (totalj1 > 21){
						if (JUGADOR[cartamano-2] == 0 || JUGADOR[cartamano-2] == 13 ||JUGADOR[cartamano-2] == 26 || JUGADOR[cartamano-2] == 39){
							totalj1 = totalj1 -10;
						}
						totalj1 = totalj1 -10;
					}
					}
				else if (ncarta == 1 && conta2 < 2){
					conta2 = conta2 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 2;
					}
				else if (ncarta == 2 && conta3 < 2){
					conta3 = conta3 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 3;
					}
				else if (ncarta == 3 && conta4 < 2){
					conta4 = conta4 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 4;
					}
				else if (ncarta == 4 && conta5 < 2){
					conta5 = conta5 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 5;
					}
				else if (ncarta == 5 && conta6 < 2){
					conta6 = conta6 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 6;
					}
				else if (ncarta == 6 && conta7 < 2){
					conta7 = conta7 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 7;
					}
				else if (ncarta == 7 && conta8 < 2){
					conta8 = conta8 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 8;
					}
				else if (ncarta == 8 && conta9 < 2){
					conta9 = conta9 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 9;
					}
				else if (ncarta == 9 && conta10 < 2){
					conta10 = conta10 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				else if (ncarta == 10 && contaj < 2){
					contaj = contaj + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				else if (ncarta == 11 && contaq < 2){
					contaq = contaq + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				else if (ncarta == 12 && contak <2){
					contak = contak + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
			
				//PALO CORAZONES (A-K)
				else if (ncarta == 13 && contb1 < 2){
					contb1 = contb1 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 11;
					if (totalj1 > 21){
						if (JUGADOR[cartamano-2] == 0 || JUGADOR[cartamano-2] == 13 ||JUGADOR[cartamano-2] == 26 || JUGADOR[cartamano-2] == 39){
							totalj1 = totalj1 -10;
						}
						totalj1 = totalj1 -10;
					}
					}
				else if (ncarta == 14 && contb2 < 2){
					contb2 = contb2 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 2;
					}
				else if (ncarta == 15 && contb3 < 2){
					contb3 = contb3 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 3;
					}
				else if (ncarta == 16 && contb4 < 2){
					contb4 = contb4 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 4;
					}
				else if (ncarta == 17 && contb5 < 2){
					contb5 = contb5 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 5;
					}
				else if (ncarta == 18 && contb6 < 2){
					contb6 = contb6 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 6;
					}
				else if (ncarta == 19 && contb7 < 2){
					contb7 = contb7 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 7;
					}
				else if (ncarta == 20 && contb8 < 2){
					contb8 = contb8 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 8;
					}
				else if (ncarta == 21 && contb9 < 2){
					contb9 = contb9 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 9;
					}
				else if (ncarta == 22 && contb10 < 2){
					contb10 = contb10 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				else if (ncarta == 23 && contbj < 2){
					contbj = contbj + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				else if (ncarta == 24 && contbq < 2){
					contbq = contbq + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				else if (ncarta == 25 && contbk < 2){
					contbk = contbk + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				
				//PALO DIAMANTES (A-K)
				else if (ncarta == 26 && contc1 < 2){
					contc1 = contc1 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 11;
					if (totalj1 > 21){
						if (JUGADOR[cartamano-2] == 0 || JUGADOR[cartamano-2] == 13 ||JUGADOR[cartamano-2] == 26 || JUGADOR[cartamano-2] == 39){
							totalj1 = totalj1 -10;
						}
						totalj1 = totalj1 -10;
					}
					}
				else if (ncarta == 27 && contc2 < 2){
					contc2 = contc2 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 2;
					}
				else if (ncarta == 28 && contc3 < 2){
					contc3 = contc3 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 3;
					}
				else if (ncarta == 29 && contc4 < 2){
					contc4 = contc4 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 4;
					}
				else if (ncarta == 30 && contc5 < 2){
					contc5 = contc5 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 5;
					}
				else if (ncarta == 31 && contc6 < 2){
					contc6 = contc6 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 6;
					}
				else if (ncarta == 32 && contc7 < 2){
					contc7 = contc7 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 7;
					}
				else if (ncarta == 33 && contc8 < 2){
					contc8 = contc8 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 8;
					}
				else if (ncarta == 34 && contc9 < 2){
					contc9 = contc9 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 9;
					}
				else if (ncarta == 35 && contc10 < 2){
					contc10 = contc10 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				else if (ncarta == 36 && contcj < 2){
					contcj = contcj + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				else if (ncarta == 37 && contcq < 2){
					contcq = contcq + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				else if (ncarta == 38 && contck < 2){
					contck = contck + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
			
				//PALO TREBOLES (A-K)
				else if (ncarta == 39 && contd1 < 2){
					contd1 = contd1 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 11;
					if (totalj1 > 21){
						if (JUGADOR[cartamano-2] == 0 || JUGADOR[cartamano-2] == 13 ||JUGADOR[cartamano-2] == 26 || JUGADOR[cartamano-2] == 39){
							totalj1 = totalj1 -10;
						}
						totalj1 = totalj1 -10;
					}
					}
				else if (ncarta == 40 && contd2 < 2){
					contd2 = contd2 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 2;
					}
				else if (ncarta == 41 && contd3 < 2){
					contd3 = contd3 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 3;
					}
				else if (ncarta == 42 && contd4 < 2){
					contd4 = contd4 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 4;
					}
				else if (ncarta == 43 && contd5 < 2){
					contd5 = contd5 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 5;
					}
				else if (ncarta == 44 && contd6 < 2){
					contd6 = contd6 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 6;
					}
				else if (ncarta == 45 && contd7 < 2){
					contd7 = contd7 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 7;
					}
				else if (ncarta == 46 && contd8 < 2){
					contd8 = contd8 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 8;
					}
				else if (ncarta == 47 && contd9 < 2){
					contd9 = contd9 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 9;
					}
				else if (ncarta == 48 && contd10 < 2){
					contd10 = contd10 + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				else if (ncarta == 49 && contdj < 2){
					contdj = contdj + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				else if (ncarta == 50 && contdq < 2){
					contdq = contdq + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
				else if (ncarta == 51 && contdk <2){
					contdk = contdk + 1;
					JUGADOR[cartamano] = ncarta;
					cartamano = cartamano + 1;
					totalj1 = totalj1 + 10;
					}
					
				}
				
			for (i = 0; i < cartamano; i++){
				System.out.print(carta[JUGADOR[i]]+" ");
			}
		} while (totalj1 <21 && decision == 2);
		System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("+-----------------------------------------------------------+");
			System.out.println("| DINERO TOTAL: "+capin+"฿	  RONDA: "+ronda+"	APUESTA ACTUAL: "+bet+"฿  |");
			System.out.println("+-----------------------------------------------------------+");
			System.out.println("La banca tiene: \n");
			for (i=0; i<cartabanca;i++){
				System.out.print(carta[BANCA[i]]+" ");
			}
			System.out.println("\n\nSu mano es: \n");
			for (i = 0; i < cartamano; i++){
				System.out.print(carta[JUGADOR[i]]+" ");
			}
			
			if (totalbanca > 21 && totalj1 < 21 && tt==0){
				System.out.print("\n\nLa banca se ha pasado, usted gana " +bet+"฿");
				capin = capin+bet;
			}else if (totalbanca > 21 && totalj1 == 21 && tt == 0){
				System.out.println("\n\nBLACK JACKK!!! LA BANCA SE HA PASADO, USTED GANA "+bet*5+"฿");
				capin = capin+bet*5;
			}else if (totalbanca > 21 && totalj1 > 21 && tt == 0){
				System.out.println("\n\nUsted se ha pasado, la banca se ha pasado. Usted recupera su apuesta de "+bet+"฿");
			}else if (totalbanca <= 21 && totalj1 <totalbanca && tt == 0){
				System.out.println("\n\nLa banca gana. Usted pierde "+bet+"฿");
				capin = capin-bet;
			}else if (totalbanca <= 21 && totalj1 <= 21 && totalbanca == totalj1 && tt == 0){
				System.out.println("\n\nUsted empata con la banca. Usted recupera su apuesta "+bet+"฿");
			}else if (totalbanca < totalj1 && totalj1 < 21 && tt == 0){
				System.out.println("\n\nUsted gana a la banca. Usted gana "+bet+"฿");
				capin = capin+bet;
			}else if (totalbanca < 21 && totalj1 > 21 && tt == 0){
				System.out.println("\n\nUsted se ha pasado. Usted pierde "+bet+"฿");
			}
			//Resultados despues de pedir carta.
			if (totalbanca > 21 && totalj1 < 21 && tt!=0 & decision == 1){
				System.out.print("\n\nLa banca se ha pasado, usted gana " +bet+"฿");
				capin = capin+bet;
			}else if (totalbanca > 21 && totalj1 == 21 && tt != 0 && decision == 1){
				System.out.println("\n\nBLACK JACKK!!! LA BANCA SE HA PASADO, USTED GANA "+bet*5+"฿");
				capin = capin+bet*5;
			}else if (totalbanca > 21 && totalj1 > 21 && tt != 0 && decision == 1){
				System.out.println("\n\nUsted se ha pasado, la banca se ha pasado. Usted recupera su apuesta de "+bet+"฿");
			}else if (totalbanca <= 21 && totalj1 <totalbanca && tt != 0 && decision ==1){
				System.out.println("\n\nLa banca gana. Usted pierde "+bet+"฿");
				capin = capin-bet;
			}else if (totalbanca <= 21 && totalj1 <= 21 && totalbanca == totalj1 && tt != 0 && decision ==1){
				System.out.println("\n\nUsted empata con la banca. Usted recupera su apuesta "+bet+"฿");
			}else if (totalbanca < totalj1 && totalj1 < 21 && tt != 0 && decision ==1){
				System.out.println("\n\nUsted gana a la banca. Usted gana "+bet+"฿");
				capin = capin+bet;
			}else if (totalbanca < 21 && totalj1 > 21 && tt != 0 && decision == 1){
				System.out.println("\n\nUsted se ha pasado. Usted pierde "+bet+"฿");
			}
		
		}while (resp!=0);

/*for (i = 0; i < cartamano; i++){
					System.out.print(carta[JUGADOR[i]]+"  ");
				}*/
		
	}
}
/*for (i=0;i<JUGADOR.length;i++){
						if (totalj1 > 21 && JUGADOR[i] == 0 || JUGADOR[i] == 13 || JUGADOR[i] == 26 || JUGADOR[i] == 39){
							totalj1 = totalj1-10;
						}
					}*/
