import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

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
	
	
	
	
}
