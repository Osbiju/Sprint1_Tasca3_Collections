package n1exercici3;

import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    //construimos un mapa con dos argumentos K y V (Key,Value) y lo guardamos en paisos
    private static HashMap<String, String> paisos = new HashMap<String, String>();

    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        entrada = new Scanner(System.in);
        String nom = "";
        int puntuacio = 0;

        //legim els paisos del fitxer
        paisos = llegirPaisos();

        //juguem
        System.out.println("Introdueix el teu nom:");
        nom = entrada.nextLine();
        System.out.println(nom + ",benvingut al joc de les capitals, tindras 10 intens, i si acertas tindras 1 punt ");

        puntuacio = preguntarUsuari();
        guardarPuntuacio(nom,puntuacio);

        // Mostrem la puntuació, ja la mostrem trucant a la funcio
       // System.out.println(nom + ", has aconseguit una puntuació de " + puntuacio);

    }
    private static HashMap<String, String> llegirPaisos(){
        //legeixo el fitxer i el guardo a llegir-IMPORTANT: SHAN DE BORRAR LES DOS LINEAS BUIDES DEL ARXHIU.TXT, SINO NO FUNCIONA
        BufferedReader llegir = null;
        String linea = "";
        String[] parts;
        String key = "";
        String value = "";

        try {
            llegir = new BufferedReader(new FileReader("countries.txt"));//TODO posar la direccio correcta
//            String linea = paisos.put(K,V); esto seria si quisiera añadir uno a uno, que no venga de un archivo

            while ((linea = llegir.readLine()) != null) {
                parts = linea.split(" ");
                key = parts[0].trim();
                value = parts[1].trim();
                //controlar que no sigui null o buid la KEY o value
                if (!key.equalsIgnoreCase("") && !value.equalsIgnoreCase("")) {
                    paisos.put(key, value);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Archiu no trobat");//asi ajudem a entendre el error
            //throw new RuntimeException(e);este seria el por defecto

        } finally {
            //tancar el buffer pero calculem que no es tanqui cuan sigui null
            if (llegir != null) {
                try {
                    llegir.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return paisos;
    }

    private static int preguntarUsuari(){
        int puntuacio = 0;
        Object[] key;
        String pais = "";
        String capital = "";

        for (int i = 0; i < 10; i++){
            //seleccionar pais atleatori
            key = paisos.keySet().toArray(new String[0]);
            pais = (String)key[new Random().nextInt(key.length)];

            //demanar capital
            System.out.println("Quina es la capital de " + pais + " ?");
            capital = entrada.nextLine();

            //comprobar resposta
            if (capital.equalsIgnoreCase(paisos.get(pais))){
                puntuacio++;
                System.out.println("Correcte, la capital del pais " + pais + " es: " + capital);
            }else {
                System.out.println("Incorrecte! La capital de " + pais + " es " + paisos.get(pais));
            }
        }
        return puntuacio;
    }

    private static void guardarPuntuacio(String nom, int puntuacio){
        //guardar puntuacioi mostrar, nomes es guarda un nom, podria mirar com fer per a que es guardessin tots els que vagi fent

        try {
            BufferedWriter escriureResultats = new BufferedWriter(new FileWriter("classificacio.txt"));//TODO posar la direccio correcta
            escriureResultats.write(nom + " " + puntuacio);
            escriureResultats.close();//si no es posa, es creara larchiu pero no es llegira
        } catch (IOException e) {
            throw new RuntimeException("No existe el archivo classificacio. Lo has movido?");
            //throw new RuntimeException(e);este seria el por defecto
        } finally {
            System.out.println("\n" + nom + " has acabat el joc, has conseguit una puntuacio de " + puntuacio);
        }
    }
}
