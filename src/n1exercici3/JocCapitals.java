package n1exercici3;

import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class JocCapitals {
    private HashMap<String, String> paisos;
    private Scanner entrada;

    public JocCapitals() {
        this.paisos = LlegirPaisos();
        this.entrada = new Scanner(System.in);
    }

    public void jugar() {
        String nom = "";
        int puntuacio = 0;

        System.out.println("Introdueix el teu nom:");
        nom = entrada.nextLine();
        System.out.println(nom + ",benvingut al joc de les capitals, tindras 10 intens, i si acertas tindras 1 punt ");

        puntuacio = PreguntarUsuari();
        GuardarPuntuacio(nom, puntuacio);

        System.out.println(nom + ", has aconseguit una puntuació de " + puntuacio);
    }

    private HashMap<String, String> LlegirPaisos() {
        HashMap<String, String> paisos = new HashMap<>();

        try (BufferedReader llegir = new BufferedReader(new FileReader("countries.txt"))) {
            String linea = "";
            while ((linea = llegir.readLine()) != null) {
                String[] parts = linea.split(" ");
                paisos.put(parts[0].trim(), parts[1].trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("Archiu no trobat");
        }

        return paisos;
    }

    private int PreguntarUsuari() {
        int puntuacio = 0;

        for (int i = 0; i < 10; i++) {
            String pais = paisos.keySet().toArray(new String[0])[new Random().nextInt(paisos.size())];
            System.out.println("Quina es la capital de " + pais + " ?");
            String capital = entrada.nextLine();

            if (capital.equalsIgnoreCase(paisos.get(pais))) {
                puntuacio++;
                System.out.println("Correcte, la capital del pais " + pais + " es: " + capital);
            } else {
                System.out.println("Incorrecte! La capital de " + pais + " es " + paisos.get(pais));
            }
        }

        return puntuacio;
    }

    private void GuardarPuntuacio(String nom, int puntuacio) {
        try (BufferedWriter escriureResultats = new BufferedWriter(new FileWriter("classificacio.txt", true))) {
            escriureResultats.write(nom + " " + puntuacio + "\n");
        } catch (IOException e) {
            throw new RuntimeException("No existe el archivo classificacio. Lo has movido?");
        }
    }
}
