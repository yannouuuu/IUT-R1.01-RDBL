class Bissextile extends Program {

    boolean bissextile(int annee) {
        if (annee % 400 == 0) {
            return true;
        } else if (annee % 100 == 0) {
            return false;
        } else if (annee % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    void algorithm() {
        int annee = 2022;
        int nbTrouvees = 0;

        while (nbTrouvees < 33) {
            if (bissextile(annee)) {
                print(annee + " ");
                nbTrouvees = nbTrouvees + 1;
                if (nbTrouvees % 13 == 0) {
                    println("");
                }
            }
            annee--;
        }
    }
}

