class Saisons extends Program {

    String saisonMeteorologique(int mois) {
        if (mois < 1 || mois > 12) {
            return "erreur";
        } else if (mois == 12 || mois == 1 || mois == 2) {
            return "hiver";
        } else if (mois >= 3 && mois <= 5) {
            return "printemps";
        } else if (mois >= 6 && mois <= 8) {
            return "été";
        } else { // 9, 10, 11
            return "automne";
        }
    }

    int nombreJoursMois(int numeroMois) {
        if (numeroMois < 1 || numeroMois > 12) {
            return 0;
        } else if (numeroMois == 2) {
            return 28;
        } else if (numeroMois == 4 || numeroMois == 6 || numeroMois == 9 || numeroMois == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    String saisonAstronomique(int jour, int mois) {
        String saison = saisonMeteorologique(mois);

        if (mois == 3 && jour < 21) {
            saison = "hiver";
        } else if (mois == 6 && jour < 21) {
            saison = "printemps";
        } else if (mois == 9 && jour < 21) {
            saison = "été";
        } else if (mois == 12 && jour < 21) {
            saison = "automne";
        }
        return saison;
    }

    void algorithm() {
        int total = 0;

        // --- Étape 2 : affichage mois par mois ---
        for (int m = 0; m <= 13; m = m + 1) {
            String saison = saisonMeteorologique(m);
            int jours = nombreJoursMois(m);
            println("mois " + m + " : " + saison + ", " + jours + " jours");
            total = total + jours;
        }
        println("nombre de jours total : " + total);

        // --- Étape 4 : affichage jour par jour ---
        for (int m = 1; m <= 12; m = m + 1) {
            int jours = nombreJoursMois(m);
            for (int j = 1; j <= jours; j = j + 1) {
                println(j + "/" + m + " : " + saisonAstronomique(j, m));
            }
        }
    }
}



