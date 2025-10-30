class TestBissextile extends Program {

    // Exemples d'années bissextiles : 2000, 2012, 2024, 1600
    // Créer ici la fonction de test pour les années bissextiles


    // Exemples d'années non bissextiles : 2013, 2006, 1999, 1000
    // Créer ici la fonction de test pour les années non bissextiles
    void test_bissextile_true(){
        assertEquals(true, bissextile(2000));
        assertEquals(true, bissextile(2012));
        assertEquals(true, bissextile(2024));
        assertEquals(true, bissextile(1600));
        
    }

    void test_bissextile_false(){
        assertEquals(false, bissextile(2013));
        assertEquals(false, bissextile(2006));
        assertEquals(false, bissextile(1999));
        assertEquals(false, bissextile(1000));
    }

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
