import java.util.Random;

public class MinRandom {
    private Random random;
    
    // Konstruktor
    public MinRandom() {
        this.random = new Random();
    }
    
    // Returnerer tilfeldig heltall mellom nedre og øvre (inkludert begge)
    public int nextInt(int nedre, int øvre) {
        if (nedre > øvre) {
            throw new IllegalArgumentException("Nedre grense kan ikke være større enn øvre grense");
        }
        // random.nextInt(n) returnerer 0 til n-1
        // Vi legger til nedre for å få intervallet [nedre, øvre]
        return nedre + random.nextInt(øvre - nedre + 1);
    }
    
    // Returnerer tilfeldig desimaltall mellom nedre og øvre (inkludert begge)
    public double nextDouble(double nedre, double øvre) {
        if (nedre > øvre) {
            throw new IllegalArgumentException("Nedre grense kan ikke være større enn øvre grense");
        }
        // random.nextDouble() returnerer 0.0 til 1.0
        // Vi skalerer det til ønsket intervall
        return nedre + random.nextDouble() * (øvre - nedre);
    }
}
