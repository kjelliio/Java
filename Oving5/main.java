class main{
    public static void main(String[] args) {
        System.out.println("=== OPPGAVE 1: Brøk-klasse ===\n");
        
        // Lage brøker
        Fraction f1 = new Fraction(3, 4);      // 3/4
        Fraction f2 = new Fraction(1, 2);      // 1/2
        Fraction f3 = new Fraction(5);         // 5/1
        
        System.out.println("Brøk 1: " + f1);
        System.out.println("Brøk 2: " + f2);
        System.out.println("Brøk 3: " + f3);
        System.out.println();
        
        // Addisjon
        Fraction sum = f1.add(f2);
        System.out.println(f1 + " + " + f2 + " = " + sum);
        
        // Subtraksjon
        Fraction diff = f1.subtract(f2);
        System.out.println(f1 + " - " + f2 + " = " + diff);
        
        // Multiplikasjon
        Fraction prod = f1.multiply(f2);
        System.out.println(f1 + " * " + f2 + " = " + prod);
        
        // Divisjon
        Fraction kvot = f1.divide(f2);
        System.out.println(f1 + " / " + f2 + " = " + kvot);
        
        System.out.println("\n=== OPPGAVE 2: MinRandom-klasse ===\n");
        
        // Lage MinRandom instans
        MinRandom rnd = new MinRandom();
        
        // Test nextInt - tilfeldige heltall fra 1 til 100
        System.out.println("5 tilfeldige heltall mellom 1 og 100:");
        for (int i = 0; i < 5; i++) {
            System.out.println("  " + rnd.nextInt(1, 100));
        }
        
        System.out.println();
        
        // Test nextDouble - tilfeldige desimaltall fra 0.0 til 1.0
        System.out.println("5 tilfeldige desimaltall mellom 0.0 og 1.0:");
        for (int i = 0; i < 5; i++) {
            System.out.printf("  %.4f\n", rnd.nextDouble(0.0, 1.0));
        }
        
        System.out.println();
        
        // Test nextDouble med større intervall
        System.out.println("5 tilfeldige desimaltall mellom -10.5 og 10.5:");
        for (int i = 0; i < 5; i++) {
            System.out.printf("  %.2f\n", rnd.nextDouble(-10.5, 10.5));
        }
        
        System.out.println("\n=== KOMBINERT TEST ===\n");
        
        // Lag tilfeldige brøker og legg dem sammen
        MinRandom fractionRnd = new MinRandom();
        Fraction f4 = new Fraction(fractionRnd.nextInt(1, 10), fractionRnd.nextInt(1, 10));
        Fraction f5 = new Fraction(fractionRnd.nextInt(1, 10), fractionRnd.nextInt(1, 10));
        
        System.out.println("Tilfeldige brøker:");
        System.out.println(f4 + " + " + f5 + " = " + f4.add(f5));
    }
}
