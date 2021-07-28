package nivell2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Restaurant2Nivell3 {
	
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
		
		int continuar =1;
		
		List<String> menu = new ArrayList();
		
		try {
			assignacion_Arrays(preuPlat);
			llistat_plats();
			demanar_plats(continuar,menu);
			total(menu);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
}

	public static void assignacion_Arrays(HashMap<String,Integer> preuPlat) throws Exception {
			int contador = 0;
			for (Map.Entry<String, Integer> entry: preuPlat.entrySet())  {
					Restaurant1Nivell2.plats[contador]= entry.getKey();
					Restaurant1Nivell2.preus[contador]= entry.getValue();
					contador++;
			}
	}

	public static void llistat_plats() throws Exception {
			//Llistat de Plats
			for (int i=0;i<10;i++) {
				System.out.println("Plat:"+Restaurant1Nivell2.plats[i] + " Preu:"+Restaurant1Nivell2.preus[i]);
			}
	}
		
	public static void demanar_plats(int continuar,List<String> menu) throws Exception {
		while (continuar==1) {
			System.out.println("Que es vol per menjar?");
			Scanner myObj1 = new Scanner(System.in);
			String valor1 = myObj1.nextLine();
			try {
				comprobar_plat(valor1,menu);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				comprobar_S_N(continuar);
			}catch(Exception e) {
				System.out.println(e.getMessage());
				continuar = comprobar_S_N(continuar);
			}
		}
	}
	
	public static void comprobar_plat(String valor1, List<String> menu) throws Exception {
			int existe = 0;
			if (!valor1.equals(" ")){
			for (int i=0;i<10;i++) {
				if (valor1.equalsIgnoreCase(Restaurant1Nivell2.plats[i])) {
					menu.add(valor1);
					existe = 1;
				}
			}
			if (existe ==0 ) throw new Exception("Aquest producte no existeix");
		}
	}
	
	public static int comprobar_S_N(int continuar) throws Exception{
		System.out.println("Es vol seguir demanant per menjar(S/N)?");
		Scanner myObj2 = new Scanner(System.in);
		String valor2=myObj2.nextLine();
		if (valor2.equalsIgnoreCase("S")) {
			continuar = 1;
		}else if (valor2.equalsIgnoreCase("N")) {
			continuar = 0;
		}else throw new Exception("Aquesta resposta es incorrecta");
		return continuar;
	}
	
	public static void total(List<String> menu) throws Exception {
		
		int total=0;
		//Comparar Llistats
		for (int i=0;i<menu.size();i++) {
			for (int j=0;j<10;j++) {
				if (menu.get(i).equalsIgnoreCase(Restaurant1Nivell2.plats[j])) {
					total += Restaurant1Nivell2.preus[j];
				}
			}
		}
		System.out.println("Preu Total:" + total);
		
		Restaurant1Nivell2.b500=total/500;
		if (Restaurant1Nivell2.b500>0) {
			System.out.println(Restaurant1Nivell2.b500 + " bitllets de 500");
		}
		total=total%500;
		Restaurant1Nivell2.b200=total/200;
		if (Restaurant1Nivell2.b200>0) {
			System.out.println(Restaurant1Nivell2.b200 + " bitllets de 200");
		}
		total=total%200;
		Restaurant1Nivell2.b100=total/100;
		if (Restaurant1Nivell2.b100>0) {
			System.out.println(Restaurant1Nivell2.b100 + " bitllets de 100");
		}
		total=total%100;
		Restaurant1Nivell2.b50=total/50;
		if (Restaurant1Nivell2.b50>0) {
			System.out.println(Restaurant1Nivell2.b50 + " bitllets de 50");
		}
		total=total%50;
		Restaurant1Nivell2.b20=total/20;
		if (Restaurant1Nivell2.b20>0) {
			System.out.println(Restaurant1Nivell2.b20 + " bitllets de 20");
		}
		total=total%20;
		Restaurant1Nivell2.b10=total/10;
		if (Restaurant1Nivell2.b10>0) {
			System.out.println(Restaurant1Nivell2.b10 + " bitllets de 10");
		}
		total=total%10;
		Restaurant1Nivell2.b5=total/5;
		if (Restaurant1Nivell2.b5>0) {
			System.out.println(Restaurant1Nivell2.b5 + " bitllets de 5");
		}
		total=total%5;
		Restaurant1Nivell2.m2=total/2;
		if (Restaurant1Nivell2.m2>0) {
			System.out.println(Restaurant1Nivell2.m2 + " monedes de 2");
		}
		total=total%2;
		Restaurant1Nivell2.m1=total/1;
		if (Restaurant1Nivell2.m1>0) {
			System.out.println(Restaurant1Nivell2.m1 + " monedes de 1");
		}
		
	}
}
