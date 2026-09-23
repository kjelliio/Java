public class Fraction {
    private int numerator;    // telleren
    private int denominator;  // nevneren
    
    // Konstruktor 1: tar både teller og nevner
    public Fraction(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) {
            throw new IllegalArgumentException("Teller og nevner kan ikke være 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    // Konstruktor 2: tar bare ett tall (nevner blir 1)
    public Fraction(int numerator) {
        this(numerator, 1);
    }
    
    // Get-metoder
    public int getNumerator() {
        return numerator;
    }
    
    public int getDenominator() {
        return denominator;
    }
    
    // Hjelpemetode: finne største felles divisor (for å forenkle brøker)
    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Hjelpemetode: forenkle brøken
    private void simplify() {
        int divisor = gcd(numerator, denominator);
        numerator /= divisor;
        denominator /= divisor;
    }
    
    // Addisjon: this + other
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + 
                          other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.simplify();
        return result;
    }
    
    // Subtraksjon: this - other
    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - 
                          other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.simplify();
        return result;
    }
    
    // Multiplikasjon: this * other
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.simplify();
        return result;
    }
    
    // Divisjon: this / other
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Kan ikke dele på null");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.simplify();
        return result;
    }
    
    // toString for enkel utskrift
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
