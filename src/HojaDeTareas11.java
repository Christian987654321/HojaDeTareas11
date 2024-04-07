
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import clases.Cliente;

public class HojaDeTareas11 {

	public static void main(String[] args) {
		/*ArrayList<Integer> lista1= new ArrayList<Integer>();
		ArrayList<Integer> lista2= new ArrayList<Integer>();
		lista1.add(1);
		lista1.add(2);
		lista1.add(9);
		lista2.add(4);
		lista2.add(8);
		
		System.out.println(fusionEnteros(lista1,lista2));*/
		ejercicio3();
		
	}
	
	public static void ejercicio1() {
		Random rand=new Random();
		ArrayList<Integer> listaRandom1= new ArrayList<Integer>();
		TreeSet<Integer> set=new TreeSet<Integer>(); //Comparator
		
		for (int i=0;i<30;i++) {
			listaRandom1.add( rand.nextInt(1,11));
		}
		System.out.println("Lista: "+listaRandom1);
		
		set.addAll(listaRandom1);
		//System.out.println("Conjunto: "+set);
		
		Iterator<Integer> iterator= set.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+ " ");
		}
		
	}
	
	public static  List<Integer> fusionEnteros (List<Integer> lista1, List<Integer> lista2) {
		
		lista1.addAll(lista2);
		lista1.sort(Comparator.reverseOrder());
		
		return lista1;

	}
	public static void ejercicio3() {
		LocalDate d1= LocalDate.of(2021, 05, 12);
		LocalDate d2= LocalDate.of(2015, 05, 12);
		LocalDate d3= LocalDate.of(2016, 05, 12);
		LocalDate d4= LocalDate.of(2017, 05, 12);
		LocalDate d5= LocalDate.of(2018, 05, 12);
		
		Cliente c1 = new Cliente("11111111A", "Jacinto Gomez", 32, d1, 1615.15);
		Cliente c2 = new Cliente("11111112A", "Paco Perez", 25, d2, 2689.15);
		Cliente c3 = new Cliente("11111113A", "Daniel Ramos", 54, d3, 3400.15);
		Cliente c4 = new Cliente("11111114A", "Esteban Fernandez", 43, d4, 1092.15);
		Cliente c5 = new Cliente("11111115A", "Marta Sanchez", 61, d5, 30000.15);
		
		TreeSet<Cliente> clientesTS=new TreeSet<Cliente>();
		
		clientesTS.add(c1);
		clientesTS.add(c2);
		clientesTS.add(c3);
		clientesTS.add(c4);
		clientesTS.add(c5);
		
		clientesTS.remove(clientesTS.last());
		
		Iterator<Cliente> itCliente=clientesTS.iterator();
		while (itCliente.hasNext()) {
			System.out.println(itCliente.next());
		}
		
		
		
	}
	
	
	
	
}
