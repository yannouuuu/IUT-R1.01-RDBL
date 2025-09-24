class Tri extends Program {

    void algorithm() {
        char c1, c2, c3;
        c1 = readChar();
        c2 = readChar();
        c3 = readChar();
        // à compléter pour que c1, c2 et c3 contiennent les caractères saisis dans l’ordre ASCII
        String result = "";

        for(int i = 0; i < 3; i++) {
            if (c1 < c2 && c1 > c3) {
                result = result + c1;
            } else if (c2 < c1 && c2 < c3) {
                result = result + c2;
            } else if (c3 < c1 && c3 < c2) {
                result = result + c3;
            }
        }
        
        println("" + c1 + c2 + c3); // à garder tel quel 
    }
}

