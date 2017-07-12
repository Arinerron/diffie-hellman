import java.math.BigInteger;

public class Main {
    public int p, g, a, key = 0;

    public static void main(String[] args) {
        // Diffie-Hellman key exchange
        // a can be any random number
        Main a = new Main(23, 6, 152783);
        Main b = new Main(23, 6, 6342343);
        a.key = a.priv(b.pub());
        b.key = b.priv(a.pub());

        System.out.println(a.key + " and " + b.key);
    }

    public Main(int p, int g, int a) { // a is secret integer
        this.p = p;
        this.g = g;
        this.a = a;
    }

    public int priv(int k) {
        return new BigInteger(k + "").pow(a).mod(new BigInteger(p + "")).intValue();
    }

    public int pub() {
        return new BigInteger(g + "").pow(a).mod(new BigInteger(p + "")).intValue();
    }
}
