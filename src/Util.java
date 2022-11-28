import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Util {

    public static byte[] Sha256Hash(byte[] msg)
    {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(msg);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns an uniformly distributed random BigInteger
     * @param lowerLimit inclusive
     * @param upperLimit exclusive
     * @return random BigInteger
     */
    public static BigInteger getRandomBigInteger(BigInteger lowerLimit, BigInteger upperLimit) {
        upperLimit = upperLimit.subtract(lowerLimit);
        Random rand = new Random();
        BigInteger result;
        do {
            result = new BigInteger(upperLimit.bitLength(), rand);
        } while(result.compareTo(upperLimit) >= 0);
        return result.add(lowerLimit);
    }

}
