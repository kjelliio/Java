import java.util.Random;

class Oving6 {
    public static void main(String[] args) {
        // OPPGAVE 1
        System.out.println("=== OPPGAVE 1: TELLETABELL ===\n");
        
        Random random = new Random();
        int antallTall = 1000;
        int[] antall = new int[10];
        
        for (int i = 0; i < antallTall; i++) {
            int tall = random.nextInt(10);
            antall[tall]++;
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " " + antall[i] + " ");
            int stjerner = antall[i] / 10;
            for (int j = 0; j < stjerner; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // OPPGAVE 2
        System.out.println("\n\n=== OPPGAVE 2: TEKSTANALYSE ===\n");
        
        String tekst = "Programmering er gøy og interessant";
        TextAnalyse analyse = new TextAnalyse(tekst);
        analyse.skrivStatistikk();
        
        // OPPGAVE 3
        System.out.println("\n\n=== OPPGAVE 3: MATRISE ===\n");
        
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] data2 = {{7, 8, 9}, {10, 11, 12}};
        
        Matrise m1 = new Matrise(data1);
        Matrise m2 = new Matrise(data2);
        
        System.out.println("Matrise 1 + Matrise 2:");
        m1.add(m2).print();
        
        System.out.println("\nMatrise 1 transponert:");
        m1.transpose().print();
        
        int[][] data3 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] data4 = {{7, 8, 9}, {10, 11, 12}};
        
        Matrise m3 = new Matrise(data3);
        Matrise m4 = new Matrise(data4);
        
        System.out.println("\nMatrise 3 * Matrise 4:");
        m3.multiply(m4).print();
    }
}

// ============ TEKSTANALYSE KLASSE ============
class TextAnalyse {
    private String tekst;
    private int[] antallTegn;
    
    public TextAnalyse(String tekst) {
        this.tekst = tekst.toLowerCase();
        this.antallTegn = new int[26];
        
        for (int i = 0; i < this.tekst.length(); i++) {
            char c = this.tekst.charAt(i);
            if (c >= 'a' && c <= 'z') {
                antallTegn[c - 'a']++;
            }
        }
    }
    
    public int antallForskjelliges() {
        int teller = 0;
        for (int i = 0; i < 26; i++) {
            if (antallTegn[i] > 0) {
                teller++;
            }
        }
        return teller;
    }
    
    public int antallBokstaver() {
        int teller = 0;
        for (int i = 0; i < 26; i++) {
            teller += antallTegn[i];
        }
        return teller;
    }
    
    public char mestForekommende() {
        int maksimum = 0;
        char bokstav = 'a';
        
        for (int i = 0; i < 26; i++) {
            if (antallTegn[i] > maksimum) {
                maksimum = antallTegn[i];
                bokstav = (char) ('a' + i);
            }
        }
        return bokstav;
    }
    
    public String bokstaverSomMangler() {
        String mangler = "";
        for (int i = 0; i < 26; i++) {
            if (antallTegn[i] == 0) {
                mangler += (char) ('a' + i);
            }
        }
        return mangler;
    }
    
    public void skrivStatistikk() {
        System.out.println("Tekst: \"" + tekst + "\"\n");
        System.out.println("Antall bokstaver totalt: " + antallBokstaver());
        System.out.println("Antall forskjellige bokstaver: " + antallForskjelliges());
        System.out.println("Mest forekommende bokstav: '" + mestForekommende() + "'");
        System.out.println("Bokstaver som mangler: " + bokstaverSomMangler() + "\n");
        
        System.out.println("Tabell:");
        for (int i = 0; i < 26; i++) {
            if (antallTegn[i] > 0) {
                System.out.println((char)('a' + i) + ": " + antallTegn[i]);
            }
        }
    }
}

// ============ MATRISE KLASSE ============
class Matrise {
    private int[][] data;
    private int antallRader;
    private int antallKolonner;
    
    public Matrise(int[][] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Matrise kan ikke være tom");
        }
        
        this.antallRader = data.length;
        this.antallKolonner = data[0].length;
        this.data = new int[antallRader][antallKolonner];
        
        for (int i = 0; i < antallRader; i++) {
            for (int j = 0; j < antallKolonner; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }
    
    public int getAntallRader() {
        return antallRader;
    }
    
    public int getAntallKolonner() {
        return antallKolonner;
    }
    
    public Matrise add(Matrise other) {
        if (this.antallRader != other.antallRader || 
            this.antallKolonner != other.antallKolonner) {
            throw new IllegalArgumentException("Matriser må ha samme størrelse for addisjon");
        }
        
        int[][] resultat = new int[antallRader][antallKolonner];
        
        for (int i = 0; i < antallRader; i++) {
            for (int j = 0; j < antallKolonner; j++) {
                resultat[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        
        return new Matrise(resultat);
    }
    
    public Matrise multiply(Matrise other) {
        if (this.antallKolonner != other.antallRader) {
            throw new IllegalArgumentException(
                "Antall kolonner i første matrise må = antall rader i andre matrise");
        }
        
        int[][] resultat = new int[this.antallRader][other.antallKolonner];
        
        for (int i = 0; i < this.antallRader; i++) {
            for (int j = 0; j < other.antallKolonner; j++) {
                int sum = 0;
                for (int k = 0; k < this.antallKolonner; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                resultat[i][j] = sum;
            }
        }
        
        return new Matrise(resultat);
    }
    
    public Matrise transpose() {
        int[][] resultat = new int[antallKolonner][antallRader];
        
        for (int i = 0; i < antallRader; i++) {
            for (int j = 0; j < antallKolonner; j++) {
                resultat[j][i] = this.data[i][j];
            }
        }
        
        return new Matrise(resultat);
    }
    
    public void print() {
        for (int i = 0; i < antallRader; i++) {
            System.out.print("[ ");
            for (int j = 0; j < antallKolonner; j++) {
                System.out.print(String.format("%3d ", data[i][j]));
            }
            System.out.println("]");
        }
    }
}
