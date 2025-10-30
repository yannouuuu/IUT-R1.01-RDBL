class JeuDuPendu extends Program {

    void algorithm() {
        String mot = "unix"; // Peut être modifié pour tester
        int erreurs = 0;
        int maxErreurs = 5;

        // On déclare un tableau de caractères de la taille du mot (à voir si ça marche en ijava) 
        char[] tabMot = new char[length(mot)];
        char[] tabAffichage = new char[length(mot)];
        
        for(int i = 0; i < length(mot); i++){
            tabMot[i] = charAt(mot, i);
            tabAffichage[i] = '*';
        }

        while(erreurs < maxErreurs && !motTrouve(tabAffichage)) {
            print("Il vous reste " + (maxErreurs - erreurs) + " erreurs: ");
            for(int i = 0; i < length(tabAffichage); i++) {
                print(tabAffichage[i] + " ");
            }
            println();
            
            print("Entrez un caractère: ");
            char lettre = readChar();
            
            boolean lettrePresente = false;
            for(int i = 0; i < length(tabMot); i++) {
                if(tabMot[i] == lettre) {
                    tabAffichage[i] = lettre;
                    lettrePresente = true;
                }
            }
            if(!lettrePresente) {
                erreurs++;
            }
        }
        
        if(motTrouve(tabAffichage)) {
            println("Vous avez gagné ! Il fallait trouver: " + mot);
        } else {
            println("Vous avez perdu ! Il fallait trouver: " + mot);
        }
    }
    
    boolean motTrouve(char[] tab) {
        for(int i = 0; i < length(tab); i++) {
            if(tab[i] == '*') {
                return false;
            }
        }
        return true;
    }
}
