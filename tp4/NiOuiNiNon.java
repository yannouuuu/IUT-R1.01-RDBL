class NiOuiNiNon extends Program {

    void algorithm() {
        final String OUI = "oui";
        final String NON = "non";
        String saisie;

        do {
            saisie = readString();
        } while (!(equals(saisie, OUI)) && !(equals(saisie, NON)));

        println("Perdu!");
    }
}
