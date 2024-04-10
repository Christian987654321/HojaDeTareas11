
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
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
		//System.out.println(generadorDeLista().size());
		/*
		int num=24 /7;
		System.out.println(num);
		int num2=24 %7;
		System.out.println(num2);
		*/
		
		List<List<String>>valor=repartoAlumnos(generadorDeLista(),7);
		
		for(int i=0;i<valor.size();i++) {
			System.out.println(valor.get(i));
		}
		
		/*
		for (List<String> valores:valor) {
			//System.out.println(valores);
			for(String a:valores) {
				System.out.println(a);
			}
		}*/
		//ejercicio5();
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
	public static List<String> generadorDeLista(){
		ArrayList<String> nombresAlumnos= new ArrayList<String>();
		String [] nombres= {"Ana","Paula","Juana","Martín","Pedro","Raquel","Bruno","Hernan","Lautaro","Enzo","Leonel","Mauro","Gonzalo","Nicolas","Luciano","Julian","Juan","Nahuel","Jose","Daniel","Roberto","Mario","Alejo","Carlos"};
		for(int i=0;i<nombres.length;i++) {
			nombresAlumnos.add(nombres[i]);
		}
		return nombresAlumnos;
		
	}
	
	public static List<List<String>> repartoAlumnos(List<String> lista, int numGrupos){
		List<List<String>> grupos = new ArrayList<List<String>>();
		
        int numAlumnos = lista.size();
        int tamañoBase = numAlumnos / numGrupos;
        int gruposConUnoAdicional = numAlumnos % numGrupos;

        int indiceInicio = 0;
        for (int i = 0; i < numGrupos; i++) {
            int tamañoGrupo = tamañoBase;
            if (i < gruposConUnoAdicional) {
                tamañoGrupo++;
            }
            List<String> grupo = lista.subList(indiceInicio, indiceInicio + tamañoGrupo);
            grupos.add(grupo);
            indiceInicio += tamañoGrupo;
        }
		
		return grupos;
		
		
	}
	
	public static void ejercicio5() {
		
		TreeMap<String,String> dic=new TreeMap<String,String>();
		Set<String>claves=dic.keySet(); // set sobre claves porque no se repiten
		Scanner sc=new Scanner(System.in);
		int opcion=-1;
		String linea=null,letra=null,key=null,value=null;
		String [] todo=new String[0];
		String rutaBin ="Diccionario.dat";
		String ruta="Diccionario.csv";
		File f=new File(rutaBin);
		File f2=new File(ruta);
		
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		if (!f2.exists()) {
			try {
				f2.createNewFile();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		
		
		try(BufferedReader reader = new BufferedReader(new FileReader("Diccionario.csv"))){
			while ((linea=reader.readLine())!=null) {
				//System.out.println(linea);
				todo=linea.split(":");
				dic.put(todo[0], todo[1]);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		System.out.println("Bienvenido al menú de Diccionario, las opciones son las siguientes:");
		
		do {
			System.out.println("1-Buscar palabra\n2-Listar todas las palabras\n3-Listar todas las palabras por letra\n4-Añadir palabra al diccionario\n5-Borrar palabra del diccionario\n6-Exportar a binario\n7-Guardar y salir");
			opcion=sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			case 1:
				System.out.println("Ingresa la palabra a buscar en el diccionario.");
				linea=sc.nextLine().toLowerCase();
				linea=Character.toUpperCase(linea.charAt(0))+linea.substring(1,linea.length());
				if(dic.get(linea)==null) {
					System.out.println("La palabra todavía no existe en éste diccionario.\n");
				}else {
				System.out.println(linea+": "+dic.get(linea)+"\n");
				}
				break;
			case 2:
				
				for (String clave:claves) {
					System.out.println(clave+": "+dic.get(clave));
				}
				System.out.println("");
				break;
			case 3:
				System.out.println("Ingresa la letra de las palabras a buscar en el diccionario.");
				letra=sc.nextLine().toUpperCase();
				for (String clave:claves) {
					if(clave.startsWith(letra)) {
						System.out.println(clave+": "+dic.get(clave));
					}
				}
				System.out.println("");

				break;
			case 4:
				System.out.println("Ingresa la palabra para añadir en el diccionario.");
				key=sc.nextLine().toLowerCase();
				System.out.println("Ahora ingresa su significado.");
				value=sc.nextLine();
				key=Character.toUpperCase(key.charAt(0))+key.substring(1,key.length());
				dic.put(key, value);
				
				break;
			case 5:
				System.out.println("Ingresa la palabra a borrar del diccionario.");
				key=sc.nextLine();
				key=Character.toUpperCase(key.charAt(0))+key.substring(1,key.length());
				linea=dic.remove(key);
				if(linea==null) {
					System.out.println("No se pudo remover la palabra.\n");
				}else {
					System.out.println("Borrada con éxito.\n");
				}
				break;
			case 6:
				
				try(ObjectOutputStream writer = new ObjectOutputStream (new FileOutputStream(rutaBin))){
					
						for(String clave:claves) {
							writer.writeObject(clave+":"+dic.get(clave));
						}
					
				} catch (FileNotFoundException e) {
					System.out.println("Fichero no encontrado");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
				/* Leer el binario
				TreeMap<String,String> dic2=new TreeMap<String,String>();
				Set<String>claves2=dic2.keySet();
				
				try(ObjectInputStream reader=new ObjectInputStream(new FileInputStream(rutaBin))){
					while(true) {
						linea=(String) reader.readObject();
						todo=linea.split(":");
						dic2.put(todo[0], todo[1]);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for (String clave:claves) {
					System.out.println(clave+": "+dic.get(clave));
				}
				 */
				break;
			case 7:
				
				try(BufferedWriter writer=new BufferedWriter(new FileWriter(ruta))){
					for (String clave:claves) {
						writer.write(clave+": "+dic.get(clave));
						writer.newLine();
					}
					
				} catch (IOException e) {
					System.out.println(e.toString());
				}
				
				break;
			default:
				System.out.println("Ingresa una opción válida");
				break;
			}
			
			
		}while (opcion!=7);
		System.out.println("Hasta luego!");
		
	}
	
	
	
}
