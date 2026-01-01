class Wator extends Program {

    //Paramètres de la simulation
        final int NOMBRE_COLONNES   = 10;
        final int NOMBRE_LIGNES     = 10;
        final int GESTATION_THON    =  2; // Le temps de gestation d'un thon
        final int GESTATION_REQUIN  =  6; // idem pour le requin
        final int NOURRITURE_REQUIN =  3; // La nourriture de départ d'un requin

        final double PROBA_THON     = 0.25;
        final double PROBA_REQUIN   = 0.10;
        final double PROBA_ORQUE    = 0.13;

        // Constantes de gestation et nourriture pour les orques
        final int GESTATION_ORQUE = 8;
        final int NOURRITURE_ORQUE = 4;

    

        final int LATENCE = 10; // à diminuer pour augmenter la vitesse de la simulation

        final String SAUVEGARDE = "ocean.csv";

        // Compteurs pour chaque espèce
        int nbThons = 0;
        int nbRequins = 0;

        void algorithm(){
            Poisson[][] ocean = charger(SAUVEGARDE);

            
            
            if (estVide(ocean)){
                initialiser(ocean, PROBA_THON, PROBA_REQUIN, PROBA_ORQUE);
            }
            
            
            
            int nombreTours = 0;
            while(!estVide(ocean)){
                int ligne   = random(NOMBRE_LIGNES);
                int colonne = random(NOMBRE_COLONNES);
                appliquerRegles(ocean, ligne, colonne);
                println("On applique les régles en " + ligne + ", " + colonne);
                println(toString(ocean));
                sleep(LATENCE);
                nombreTours++;
                if (nombreTours == 10){
                    println("Voulez-vous sauvegarder ? (O/N)");
                    if (readChar() == 'O'){
                        sauver(ocean, SAUVEGARDE);
                    }
                    nombreTours = 0;
                }
            }
        }

        // Initialise le tableau de poissons aléatoirement selon des probabilités
        void initialiser(Poisson[][] tab, double probaThon, double probaRequin, double probaOrque){
            
            
            
            nbThons = 0;
            nbRequins = 0;
            
            
            
            for (int idxL = 0; idxL < length(tab,1); idxL++) {
                for (int idxC = 0; idxC < length(tab,2); idxC++) {
                    tab[idxL][idxC] = newPoisson(probaThon, probaRequin, probaOrque);
                }
            }
        }

        // Créer un poisson ou du plancton en fonction des probabilités fournies
        Poisson newPoisson(double probaThon, double probaRequin, double probaOrque){
            double alea = random();
            Poisson p;
            if (alea < probaThon) {
                p = newThon();
                nbThons++;
            } else if (alea < probaThon + probaRequin) {
                p = newRequin();
                nbRequins++;
            } else { //il n'y a pas de poisson
                p = new Poisson();
                p.espece = Espece.PLANCTON;
            }
            return p;
        }




        // Met à jour les compteurs lors d'un changement d'espèce
        void mettreAJourCompteurs(Espece ancienne, Espece nouvelle){
            // Décrémenter l'ancienne espèce
            if (ancienne == Espece.THON) {
                nbThons--;
            } else if (ancienne == Espece.REQUIN) {
                nbRequins--;
            }
            
            // Incrémenter la nouvelle espèce
            if (nouvelle == Espece.THON) {
                nbThons++;
            } else if (nouvelle == Espece.REQUIN) {
                nbRequins++;
            }
        }



        // Créer un thon à partir des caractéristiques en constantes globales
        Poisson newThon(){
            Poisson p   = new Poisson();


            
            p.famine    = 1;



            p.gestation = GESTATION_THON;
            p.espece    = Espece.THON;
            return p;
        }

        // Créer un requin à partir des caractéristiques en constantes globales
        Poisson newRequin(){
            Poisson p   = new Poisson();



            p.famine    = NOURRITURE_REQUIN;



            p.gestation = GESTATION_REQUIN;
            p.espece    = Espece.REQUIN;
            return p;
        }

        // Retourne le poisson à la position (ligne, colonne) dans l'océan
        Poisson get(Poisson[][] tab, int ligne, int colonne){
            return tab[ligne][colonne];
        }

        // Indique si le tableau ne contient plus que du plancton
        boolean estVide(Poisson[][] ocean){
            return (nbThons == 0 && nbRequins == 0);
        }

        // Retourne un entier au hasard entre 0 et max exclus
        int random(int max){
            return (int) (random()*max) ;
        }

        // Gère la faim du poisson (décrémente sa nourriture)
        /**@inject
         * @remove
         */
        void aFaim(Poisson p){
            if (p.espece != Espece.PLANCTON && p.espece != Espece.THON) {
                p.famine--;
            }
        }

        // Déplace un poisson vers une case adjacente
        // Retourne true si le poisson s'est déplacé (permet la reproduction)
        boolean deplacement(Poisson[][] tab, int lig, int col, Espece espece){
            // Chercher une case adjacente disponible
            int[][] directions = {
                {-1,0}, {1,0}, {0,-1}, {0,1}, // haut, bas, gauche, droite
                {-1,-1}, {1,1}, {-1,1}, {-1,-1} // diagonales
            };

            // Mélanger les directions aléatoirement
            for (int i = 0; i < 10; i++) {
                int idx1 = random(4);
                int idx2 = random(4);
                int[] temp = directions[idx1];
                directions[idx1] = directions[idx2];
                directions[idx2] = temp;
            }

            for (int i = 0; i < length(directions,1); i++) {
                int nouvLig = (lig + directions[i][0] + NOMBRE_LIGNES) % NOMBRE_LIGNES;
                int nouvCol = (col + directions[i][1] + NOMBRE_COLONNES) % NOMBRE_COLONNES;

                Poisson cible = get(tab, nouvLig, nouvCol);

                // Si la case est du plancton (vide)
                if (cible.espece == Espece.PLANCTON) {
                    // Déplacer le poisson
                    Poisson poisson = get(tab, lig, col);
                    tab[nouvLig][nouvCol] = poisson;
                    return true; // Déplacement réussi
                }

                // Si c'est un prédateur qui peut manger la proie
                if (espece == Espece.REQUIN && cible.espece == Espece.THON) {
                    Poisson requin = get(tab, lig, col);
                    requin.famine = NOURRITURE_REQUIN; // Se nourrir
                    mettreAJourCompteurs(Espece.THON, Espece.PLANCTON); // Le thon est mangé
                    tab[nouvLig][nouvCol] = requin;
                    return true;
                }

            }

            return false; // Aucun déplacement possible
        }

        // Gère la reproduction du poisson
        // Retourne un nouveau poisson si reproduction, ou du plancton sinon
        Poisson reproduction(Poisson p){
            // Vérifier si le poisson peut se reproduire (gestation à 0)
            if (p.gestation <= 0 && p.espece != Espece.PLANCTON) {
                // Réinitialiser la gestation du parent
                if (p.espece == Espece.THON) {
                    p.gestation = GESTATION_THON;
                    // Créer un nouveau thon
                    Poisson nouveauNe = newThon();
                    return nouveauNe;
                } else if (p.espece == Espece.REQUIN) {
                    p.gestation = GESTATION_REQUIN;
                    // Créer un nouveau requin
                    Poisson nouveauNe = newRequin();
                    return nouveauNe;
                }
            }
            
            // Pas de reproduction, la case devient du plancton
            Poisson plancton = new Poisson();
            plancton.espece = Espece.PLANCTON;
            return plancton;
        }

        // Charge l'océan depuis un fichier CSV (à implémenter)
        Poisson[][] charger(String filename){
            Poisson[][] ocean = new Poisson[NOMBRE_LIGNES][NOMBRE_COLONNES];
            // TODO: implémenter le chargement
            return ocean;
        }

        // Sauvegarde l'océan dans un fichier CSV (à implémenter)
        void sauver(Poisson[][] ocean, String filename){
            // TODO: implémenter la sauvegarde
        }

        // Convertit l'océan en chaîne de caractères pour l'affichage
        String toString(Poisson[][] ocean){
            String result = "=== État de l'océan ===\n";




            result += "Thons: " + nbThons + " | Requins: " + nbRequins + "\n\n";
            


            
            for (int i = 0; i < length(ocean,1); i++){
                for (int j = 0; j < length(ocean,2); j++){
                    Poisson p = get(ocean, i, j);
                    if (p.espece == Espece.PLANCTON) {
                        result += ". ";
                    } else if (p.espece == Espece.THON) {
                        result += "T ";
                    } else if (p.espece == Espece.REQUIN) {
                        result += "R ";
                    }
                }
                result += '\n';
            }
            return result;
        }

        //fonction qui applique les règles de la simulation sur une case dont les coordonnées sont données en paramètre
        void appliquerRegles(Poisson[][] tab, int lig, int col){
            Poisson p = get(tab, lig, col);
            
            // Si c'est du plancton, rien à faire
            if (p.espece == Espece.PLANCTON) {
                return;
            }
            
            // Gérer la faim
            aFaim(p);
            
            // Vérifier si le poisson meurt de faim
            if (mourirDeFaim(p)) {
                mettreAJourCompteurs(p.espece, Espece.PLANCTON);
                tab[lig][col] = new Poisson();
                tab[lig][col].espece = Espece.PLANCTON;
                return;
            }
            
            // On vire petit à petit la gestation
            p.gestation--;
            
            // Tenter le déplacement
            boolean seEstDeplace = deplacement(tab, lig, col, p.espece);
            
            // Si le poisson s'est déplacé, gérer la reproduction
            if (seEstDeplace) {
                // Créer un nouveau poisson sur la case d'origine si reproduction possible
                tab[lig][col] = reproduction(p);
            }
        }

        // Gère la mort du poisson par famine
        // Retourne true si le poisson meurt
        boolean mourirDeFaim(Poisson p) {
            if (p.famine <= 0 && p.espece != Espece.PLANCTON && p.espece != Espece.THON) {
                return true;
            }
            return false;
        }
}
 