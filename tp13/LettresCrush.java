class LettresCrush extends Program {

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


    void test_explorer () {
        assertEquals(2, explorer("xxxooooxx", 4, 'o', -1));
        assertEquals(7, explorer("xxxooooxx", 4, 'o', 1));

        assertEquals(-1, explorer("xxxooooxx", 1, 'x', -1));
        assertEquals(9, explorer("xxxooooxx", 7, 'x', 1));

        assertEquals(2, explorer("xxxooooxx", 2, 'o', -1));
        assertEquals(2, explorer("xxxooooxx", 2, 'o', 1));
    }

}
