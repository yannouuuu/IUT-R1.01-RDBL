class LettresCrushDefi extends Program {

    // Donne le nombre minimal de lettres contiguës qu'on peut éliminer.
    final int TAILLE_MIN_ZONE = 3;

    // Copier la fonction eliminer et l'algorithme principal depuis le sujet

    String eliminer (String s, int indiceDepart) {
        int indiceAvant = explorer(s, indiceDepart, charAt(s, indiceDepart), -1);
        int indiceApres = explorer(s, indiceDepart, charAt(s, indiceDepart), 1);
        if (indiceApres - indiceAvant - 1 >= TAILLE_MIN_ZONE) {
            return substring(s, 0, indiceAvant+1) + substring(s, indiceApres, length(s));
        } else {
            return s;
        }
    }

    void algorithm() {
        String s = "xxxooooxx";
        boolean fin = false;

        while (! fin && length(s) != 0) {
            println(s);
            print("Saisir indice à éliminer, ou 'fin' pour arrêter : ");
            String saisie = readString();
            if (equals("fin", saisie)) {
                fin = true;
            } else {
                int indice = stringToInt(saisie);
                s = eliminer(s, indice);
            }
        }
        if (fin) {
            println("Perdu!");
        } else {
            println("Gagné!");
        }
    }

    int explorer (String s, int indiceDepart, char car, int direction){
        if (indiceDepart < 0 || indiceDepart >= length(s)) {
            return indiceDepart;
        }
        if (charAt(s, indiceDepart) != car) {
            return indiceDepart;
        }
        return explorer(s, indiceDepart + direction, car, direction);
    }

    boolean solutionExiste(String s) {
        // Cas d'arrêt 1 : chaîne vide = toutes les lettres éliminées
        if (length(s) == 0) {
            return true;
        }
        
        // Cas général : essayer d'éliminer à chaque indice
        for (int i = 0; i < length(s); i++) {
            String nouvelleChaine = eliminer(s, i);
            
            // Si une élimination a eu lieu (la chaîne a changé)
            if (!equals(nouvelleChaine, s)) {
                // Vérifier si une solution existe pour la nouvelle chaîne
                if (solutionExiste(nouvelleChaine)) {
                    return true;
                }
            }
        }
        
        // Cas d'arrêt 2 : pqs dindice permettant de trouver une solution
        return false;
    }


    void test_solutionExiste () {
        assertEquals(3, TAILLE_MIN_ZONE);
        assertTrue(solutionExiste("xxxooooxx"));
        assertFalse(solutionExiste("abcde"));
        assertTrue(solutionExiste(""));
        assertFalse(solutionExiste("ab"));
        assertFalse(solutionExiste("aa"));
        assertFalse(solutionExiste("aabbbaaabb"));
        assertTrue(solutionExiste("oaabbbaoo"));
    }
}
