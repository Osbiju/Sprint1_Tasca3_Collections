package n1exercici2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        //creo llista la la omplo
        List<Integer> llista1 = new ArrayList<Integer>();
        llista1.add(1);
        llista1.add(2);
        llista1.add(3);
        llista1.add(4);
        llista1.add(5);

        //creo segona llista
        List<Integer> llista2 = new ArrayList<Integer>();

        //utilitzacio del ListIterator per llegir i la guardo per imprimirla
        ListIterator<Integer> iterator = llista1.listIterator(llista1.size());
        while (iterator.hasPrevious()) {
            llista2.add(iterator.previous());
        }


        //mostrar per consola
        System.out.println("Primera llista: " + llista1);
        System.out.println();
        System.out.println("Segona llista(en teoria numeros al reves): " + llista2);


    }
}
