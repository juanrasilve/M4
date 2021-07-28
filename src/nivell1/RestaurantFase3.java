package nivell1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RestaurantFase3 {
	
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
		
		try {
			assignacion_Arrays(preuPlat);
			llistat_plats();
			demanar_plats(menu);
			total(menu);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
}

	public static void assignacion_Arrays(HashMap<String,Integer> preuPlat) throws Exception {
			int contador = 0;
			for (Map.Entry<String, Integer> entry: preuPlat.entrySet())  {
					RestaurantFase1.plats[contador]= entry.getKey();
					RestaurantFase1.preus[contador]= entry.getValue();
					contador++;
			}
	}

	public static void llistat_plats() throws Exception {
			//Llistat de Plats
			for (int i=0;i<10;i++) {
				System.out.println("Plat:"+RestaurantFase1.plats[i] + " Preu:"+RestaurantFase1.preus[i]);
			}
	}
		
	public static void demanar_plats(List<String> menu) throws Exception {
		int continuar =1;
		while (continuar==1) {
			System.out.println("Que es vol per menjar?");
			Scanner myObj1 = new Scanner(System.in);
			String valor1 = myObj1.nextLine();
			int existe = 0;
			if (!valor1.equals(" ")){
				for (int i=0;i<10;i++) {
					if (valor1.equalsIgnoreCase(RestaurantFase1.plats[i])) {
						menu.add(valor1);
						existe = 1;
					}
				}
				if (existe ==0 ) System.out.println("Aquest producte no existeix");
			}
			System.out.println("Es vol seguir demanant per menjar(S/N)?");
			Scanner myObj2 = new Scanner(System.in);
			String valor2=myObj2.nextLine();
			if (valor2.equalsIgnoreCase("S")) {
				continuar = 1;
			}else {
				continuar = 0;
			}
		}
		
	}
	
	public static void total(List<String> menu) throws Exception {
		
		int total=0;
		//Comparar Llistats
		for (int i=0;i<menu.size();i++) {
			for (int j=0;j<10;j++) {
				if (menu.get(i).equalsIgnoreCase(RestaurantFase1.plats[j])) {
					total += RestaurantFase1.preus[j];
				}
			}
		}
		System.out.println("Preu Total:" + total);
		
		RestaurantFase1.b500=total/500;
		if (RestaurantFase1.b500>0) {
			System.out.println(RestaurantFase1.b500 + " bitllets de 500");
		}
		total=total%500;
		RestaurantFase1.b200=total/200;
		if (RestaurantFase1.b200>0) {
			System.out.println(RestaurantFase1.b200 + " bitllets de 200");
		}
		total=total%200;
		RestaurantFase1.b100=total/100;
		if (RestaurantFase1.b100>0) {
			System.out.println(RestaurantFase1.b100 + " bitllets de 100");
		}
		total=total%100;
		RestaurantFase1.b50=total/50;
		if (RestaurantFase1.b50>0) {
			System.out.println(RestaurantFase1.b50 + " bitllets de 50");
		}
		total=total%50;
		RestaurantFase1.b20=total/20;
		if (RestaurantFase1.b20>0) {
			System.out.println(RestaurantFase1.b20 + " bitllets de 20");
		}
		total=total%20;
		RestaurantFase1.b10=total/10;
		if (RestaurantFase1.b10>0) {
			System.out.println(RestaurantFase1.b10 + " bitllets de 10");
		}
		total=total%10;
		RestaurantFase1.b5=total/5;
		if (RestaurantFase1.b5>0) {
			System.out.println(RestaurantFase1.b5 + " bitllets de 5");
		}
		total=total%5;
		RestaurantFase1.m2=total/2;
		if (RestaurantFase1.m2>0) {
			System.out.println(RestaurantFase1.m2 + " monedes de 2");
		}
		total=total%2;
		RestaurantFase1.m1=total/1;
		if (RestaurantFase1.m1>0) {
			System.out.println(RestaurantFase1.m1 + " monedes de 1");
		}
		
	}
}
