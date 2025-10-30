class ExtraireMots extends Program {

    void test_extraireMots () {
        assertArrayEquals(new String[]{"je", "tu", "elle", "je", "tu"}, extraireMots("je tu elle je tu "));
        assertArrayEquals(new String[]{"je", "tu", "elle", "je", "tu"}, extraireMots(" je tu, elle . je tu ! "));
    }

    void algorithm() {
        // ne rien mettre ici !
    }

    boolean estLettre(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    String[] extraireMots(String texte){
        if (texte == null){
            return new String[0];
        }
        texte = texte + " ";
        int n = texte.length();
        boolean inWord = false;
        int count = 0;

        for (int i = 0; i < n; i++) {
            char c = texte.charAt(i);
            if (estLettre(c)) {
                if (!inWord) inWord = true;
            } else {
                if (inWord) {
                    count++;
                    inWord = false;
                }
            }
        }

        String[] tab = new String[count];
        int idx = 0;
        inWord = false;
        int start = 0;
        for (int i = 0; i < n; i++) {
            char c = charAt(texte, i);
            if (estLettre(c)) {
                if (!inWord) { 
                    inWord = true; 
                    start = i; 
                }
            } else {
                if (inWord) {
                    tab[idx++] = substring(texte, start, i);
                    inWord = false;
                }
            }
        }

        return tab;
    }

}
