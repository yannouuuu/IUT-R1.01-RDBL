class HeureEuVersUs extends Program {

    void algorithm() {
        print("Saisir heures : ");
        int sHeures = readInt();
        print("Saisir minutes : ");
        int sMinutes = readInt();

        int heureUS;
        String suffix;

        if (sHeures == 0) {
            heureUS = 12;
            suffix = "AM";
        } else if (sHeures == 12) {
            heureUS = 12;
            suffix = "PM";
        } else if (sHeures < 12) {
            heureUS = sHeures;
            suffix = "AM";
        } else {
            heureUS = sHeures - 12;
            suffix = "PM";
        }

        println(heureUS + ":" + sMinutes + suffix);
    }
}
