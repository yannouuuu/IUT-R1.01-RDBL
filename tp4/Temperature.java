class Temperature extends Program {
    void algorithm() {
        println("Saisir une suite de valeurs entières terminée par -273.");
        int entier = readInt();
        int maximum = entier;

        while (true) {
            entier = readInt();
            if (entier == -273) {
                break;
            }
            if (entier > maximum) {
                maximum = entier;
            }
        }

        println("Le maximum est " + maximum + ".");
    }
}
