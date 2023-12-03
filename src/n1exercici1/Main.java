package n1exercici1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Month> months = new ArrayList<>();

        Month month1 = new Month("gener");
        Month month2 = new Month("febrer");
        Month month3 = new Month("març");
        Month month4 = new Month("Abril");
        Month month5 = new Month("Maig");
        Month month6 = new Month("juny");
        Month month7 = new Month("Juliol");
        Month month8 = new Month("Agost");
        Month month9 = new Month("Septembre");
        Month month10 = new Month("octubre");
        Month month11 = new Month("novembre");
        Month month12 = new Month("desembre");

        months.add(month1);
        months.add(month2);
        months.add(month3);
        months.add(month4);
        months.add(month5);
        months.add(month6);
        months.add(month7);
        //aniria agost
        months.add(month9);
        months.add(month10);
        months.add(month11);
        months.add(month12);
        System.out.println("El mesos sense Agost:\n" + months.toString());

        months.add(7, month8); //afegeixo agost despres i estara al seu lloc

        System.out.println("El mesos amb Agost:\n" + months.toString());


        //probo afegir un mes repetit convertin larraylist en hashset
        HashSet<Month> hashMonth = new HashSet<Month>(months);

        System.out.println("Aqui intento afegir un altre cop Setembre");
        hashMonth.add(month9);



        System.out.println("Els mesos de l'anys sense repetir setembre:\n" + months.toString());

        System.out.println("Els mesos remenats:\n" + hashMonth);

        System.out.println("Recorro la llista amb for i la imprimeixo:");
        for (Month month : months) {
            System.out.println(month.getNom());
        }

        //recorro la llista amb iterador
        System.out.println("hashSet mesos desordenats:");
        Iterator<Month> iterator = hashMonth.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
