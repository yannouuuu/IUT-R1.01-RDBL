class SommeMultiples extends Program {

    void algorithm() {
        int saisieD = readInt(); 
        int multiple = readInt();
        int saisieF = readInt(); 
        int result = 0;


        if (saisieD <= multiple) {
            for (int i = saisieD; i <= multiple; i++) {
                if (i % saisieF == 0) {
                    result = result +i;
                }
            }
        }

        println(result);
    }
}
