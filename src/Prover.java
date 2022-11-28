import java.math.BigInteger;

public class Prover {
    public BigInteger n;
    public BigInteger v;
    public BigInteger c;

    Prover(BigInteger n){
        this.n = n;
    }
    public BigInteger generateV(){
        v = Util.getRandomBigInteger(BigInteger.ONE,n);
        return v;
    }

    public BigInteger computeR(String password){
        BigInteger x = new BigInteger(Util.Sha256Hash(password.getBytes())).mod(n);
        return v.subtract(c.multiply(x));
    }
}
