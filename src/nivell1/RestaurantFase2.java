package nivell1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RestaurantFase2 {
	
	public static void main(String[] args) {
		
		HashMap<String,Integer> preuPlat = new HashMap<>();
		preuPlat.put("Bufalina",12);
		preuPlat.put("4 Formaggi",12);
		preuPlat.put("Pino Daniele",18);
		preuPlat.put("Margherita",9);
		preuPlat.put("Prosciutto",10);
		preuPlat.put("Parmiggiana",11);
		preuPlat.put("Al Tonno",13);
		preuPlat.put("Carbonara",11);
		preuPlat.put("Massimo Troisse",17);
		preuPlat.put("Ortolana",12);
		
		List<String> menu = new ArrayList();
		
		int contador = 0;
		for (Map.Entry<String, Integer> entry: preuPlat.entrySet())  {
			RestaurantFase1.plats[contador]= entry.getKey();
			RestaurantFase1.preus[contador]= entry.getValue();
			contador++;
		}
		
		//Llistat de Plats
		for (int i=0;i<10;i++) {
			System.out.println("Plat:"+RestaurantFase1.plats[i] + " Preu:"+RestaurantFase1.preus[i]);
		}
		
		int continuar =1;
		while (continuar==1) {
			System.out.println("Que es vol per menjar?");
			Scanner myObj = new Scanner(System.in);
			if (!myObj.nextLine().equals("")) {
				menu.add(myObj.nextLine());
			}
			System.out.println("Es vol seguir demanant per menjar(S/N)?");
			Scanner myObj2 = new Scanner(System.in);
			if (myObj2.nextLine().equalsIgnoreCase("S")) {
				continuar = 1;
			}else {
				continuar = 0;
			}
		}
	}

}
