// OVING 3

import java.util.Scanner;

// OPPGAVE 1

public class oving3 {

    public static void main(String[] args) {

        /*
        Scanner scanner = new Scanner(System.in);
        String valg;

        do {
            System.out.println("Velg 13, 14 eller 15:");
            valg = scanner.nextLine();

            if (!valg.equals("13") && !valg.equals("14") && !valg.equals("15")) {
                System.out.println("Ugyldig valg! Prøv igjen.");
            }

        } while (!valg.equals("13") && !valg.equals("14") && !valg.equals("15"));


        if (valg.equals("13")) {

            for (int i = 1; i < 11; i++) {
                int tall = 13 * i;
                System.out.println("13 x " + i + " = " + tall);
            }

        } else if (valg.equals("14")) {

            for (int i = 1; i < 11; i++) {
                int tall = 14 * i;
                System.out.println("14 x " + i + " = " + tall);
            }

        } else if (valg.equals("15")) {

            for (int i = 1; i < 11; i++) {
                int tall = 15 * i;
                System.out.println("15 x " + i + " = " + tall);
            }
        }

        scanner.close();
        */


        // TEST OPPGAVE 2
        //finnprimtall();
    }


    // OPPGAVE 2
    public static void finnprimtall() {

        Scanner scanner = new Scanner(System.in);

        String primtall;
        int tall = 0;
        boolean gyldigInput = false;

        do {

            System.out.println("Skriv inn et tall:");
            primtall = scanner.nextLine();

            try {

                tall = Integer.parseInt(primtall);

                if (tall > 1) {
                    gyldigInput = true;
                } else {
                    System.out.println("Feil: Tallet må være større enn 1.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Feil: Du må skrive et gyldig heltall!");
            }

        } while (!gyldigInput);


        // Sjekker om tallet er primtall
        if (erPrimtall(tall)) {
            System.out.println(tall + " er et primtall!");
        } else {
            System.out.println(tall + " er IKKE et primtall.");
        }

        scanner.close();
    }


    // Metode som sjekker om et tall er primtall
    public static boolean erPrimtall(int tall) {

        for (int i = 2; i < tall; i++) {

            if (tall % i == 0) {
                return false;
            }
        }

        return true;
    }
}
