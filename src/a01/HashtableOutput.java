package a01;

public class HashtableOutput {

	public static int size = 13;

	public static void main(String[] args) {
		Hashtable ht = new Hashtable(size);

		System.out.println("INDEX Spalte in der Konsolenausgabe der toString bestätigt korrekte Hashfunktion \n");
		System.out.println("Test der Put Methode: \n");
		ht.put(1, "HASSAN"); // index = 1
		ht.put(2, "ESMA"); // index = 2
		ht.put(3, "AMEDEO"); // index = 3
		ht.put(4, "YEJAY"); // index = 4
		ht.put(5, "JANVES"); // index = 5
		ht.put(6, "NEJAN"); // index = 6
		ht.put(7, "KORAY"); // index = 7
		ht.put(8, "KADIR"); // index = 8
		ht.put(9, "BENNY"); // index = 9
		ht.put(10, "MARLENE"); // index = 10
		ht.put(11, "MAX"); // index = 11
		ht.put(12, "JENETAY"); // index = 12
		ht.put(13, "EDA"); // index = 0
		ht.put(14, "TIMON"); // index = 1
		System.out.println(ht.toString());
		System.out.println("Test der Put Methode, nachdem die alten Werte überschrieben wurden: \n");
		ht.put(1, "1"); // index = 1
		ht.put(2, "2"); // index = 2
		ht.put(3, "3"); // index = 3
		ht.put(4, "4"); // index = 4
		ht.put(5, "5"); // index = 5
		ht.put(6, "6"); // index = 6
		ht.put(7, "7"); // index = 7
		ht.put(8, "8"); // index = 8
		ht.put(9, "9"); // index = 9
		ht.put(10, "10"); // index = 10
		ht.put(11, "11"); // index = 11
		ht.put(12, "12"); // index = 12
		ht.put(13, "13"); // index = 0
		ht.put(14, "14"); // index = 1
		System.out.println(ht.toString());
		System.out.println("Test der Get Methode: \n");
		System.out.println(ht.get(1));
		System.out.println(ht.get(2));
		System.out.println(ht.get(3));
		System.out.println(ht.get(4));
		System.out.println(ht.get(5));
		System.out.println(ht.get(6));
		System.out.println(ht.get(7));
		System.out.println(ht.get(8));
		System.out.println(ht.get(9));
		System.out.println(ht.get(10));
		System.out.println(ht.get(11));
		System.out.println(ht.get(12));
		System.out.println(ht.get(13));
		System.out.println(ht.get(14));
		System.out.println();
		System.out.println("Test der Remove Methode: \n");
		ht.remove(1);
		ht.remove(2);
		ht.remove(3);
		ht.remove(4);
		ht.remove(5);
		ht.remove(6);
		ht.remove(7);
		ht.remove(8);
		ht.remove(9);
		ht.remove(10);
		ht.remove(11);
		ht.remove(12);
		ht.remove(13);
		System.out.println(ht.toString());
	}
}
