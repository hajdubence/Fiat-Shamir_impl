import java.math.BigInteger;

public class Verifier {
    public Account acc;
    public BigInteger v;
    public BigInteger c;
    public BigInteger r;

    Verifier(Account acc){
        this.acc = acc;
    }

    public BigInteger generateC(){
        c = Util.getRandomBigInteger(BigInteger.ONE,acc.n);
        return c;
    }
    public boolean verify(){
        BigInteger t = acc.g.modPow(v,acc.n);
        BigInteger result = BigInteger.ZERO;

        if (r.compareTo(BigInteger.ZERO)>0)
            result = acc.g.modPow(r.negate(),acc.n).modInverse(acc.n).multiply(acc.y.modPow(c,acc.n)).mod(acc.n);
        else
            result = acc.g.modPow(r,acc.n).multiply(acc.y.modPow(c,acc.n)).mod(acc.n);

        return t.compareTo(result) == 0;
    }

}
