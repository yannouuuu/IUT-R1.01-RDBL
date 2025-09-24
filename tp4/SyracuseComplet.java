class SyracuseComplet extends Program {

    void algorithm() {
        print("Entrez un nombre: ");
        int n = readInt();
        int depart = n;
        int altitudeMax = n;
        int dureeVol = 0;
        int dureeVolAltitude = 0;
        boolean altitudeDescendue = false;

        print("Trajectoire: ");
        while (n != 1) {
            print(n + ", ");
            dureeVol++;
            if (n > altitudeMax) {
                altitudeMax = n;
            }
            if (!altitudeDescendue && n < depart) {
                dureeVolAltitude = dureeVol - 1;
                altitudeDescendue = true;
            }
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (n * 3) + 1;
            }
        }
        print(1 + ".\n");

        print("Altitude max: " + altitudeMax + "\n");
        print("Durée de vol: " + dureeVol + "\n");
        print("Durée de vol en altitude: " + dureeVolAltitude + "\n");
        print("Facteur d'expansion: " + (altitudeMax / depart) + "\n");
    }
}
