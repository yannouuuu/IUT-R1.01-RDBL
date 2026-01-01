class Occurences extends Program {
    void algorithm(){

    }

    int nbOccurrences(String mot, char lettre){
        // Cas d'arrêt chaîne vide
        if(length(mot) == 0){
            return 0;
        }
        
        // Cas récursif on traite le premier caractère
        if(charAt(mot, 0) == lettre){
            // Le premier caractère correspond, on compte 1 + les occurrences dans le reste
            return 1 + nbOccurrences(substring(mot, 1, length(mot)), lettre);
        } else {
            // Le premier caractère ne correspond pas, on compte juste les occurrences dans le reste
            return nbOccurrences(substring(mot, 1, length(mot)), lettre);
        }
    }

    void test_nbOccurences(){
        assertEquals(4, nbOccurrences("motmotmott", 't'));
        assertEquals(0, nbOccurrences("", 'r'));
    }

    int nbOccurrencesTerminale(String mot, char lettre, int compteur){
        // Cas d'arrêt chaîne vide
        if(length(mot) == 0){
            return compteur;
        }

        if(charAt(mot, 0) == lettre){
            // Le premier caractère correspond, on incrémente le compteur
            return nbOccurrencesTerminale(substring(mot, 1, length(mot)), lettre, compteur + 1);
        } else {
            // Le premier caractère ne correspond pas, on garde le même compteur
            return nbOccurrencesTerminale(substring(mot, 1, length(mot)), lettre, compteur);
        }
    }
    
    void test_nbOccurencesTerminale(){
        assertEquals(4, nbOccurrences("ghjsdgjgdfg", 'g'));
        assertEquals(0, nbOccurrences("", 'r'));
    }

}
