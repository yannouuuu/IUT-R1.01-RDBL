class FinalCountdown extends Program {
    void algorithm() {
        long debut = getTime();
        int trois = 3;
        while (getTime() - debut < 3) {
            println(trois);
            trois += 3;
        }
        println("Opération terminée en " + (getTime() - debut) + " ms");
    }
}
