public class Main {
    public static void main(String[] args) {

        // Setup
        Account acc = new Account("1234");
        Verifier verifier = new Verifier(acc);
        Prover prover = new Prover(acc.n);

        // Generate evidence
        verifier.v = prover.generateV();
        prover.c = verifier.generateC();
        verifier.r = prover.computeR("1234");

        // Verify evidence
        System.out.println(verifier.verify());
    }
}