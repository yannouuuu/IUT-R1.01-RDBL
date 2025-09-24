class HeureUsVersEu extends Program {

    void algorithm() {
        print("Saisir heures");
        int sHeures = readInt();
        print("Saisir minutes");
        int sMinutes = readInt();
        print("Saisir AM/PM");
        String ampm = readString();

        int heureEu;
        if (equals(ampm, "AM")) {
            if (sHeures == 12) {
                heureEu = 0;
            } else {
                heureEu = sHeures;
            }
        } else { // PM
            if (sHeures == 12) {
                heureEu = 12;
            } else {
                heureEu = sHeures + 12;
            }
        }

        // Affichage avec zéro éventuel sur les minutes
        if (sMinutes < 10) {
            println(heureEu + ":0" + sMinutes);
        } else {
            println(heureEu + ":" + sMinutes);
        }
    }
}
