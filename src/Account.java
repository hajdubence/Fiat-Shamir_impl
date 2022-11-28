import java.math.BigInteger;

public class Account {
    public BigInteger n;
    public BigInteger g;
    public BigInteger y;

    Account(String password){
        n = BigInteger.valueOf(101); // This should be a large number
        g = BigInteger.valueOf(2);
        BigInteger x = new BigInteger(Util.Sha256Hash(password.getBytes())).mod(n);
        y = g.modPow(x,n);
    }
}
