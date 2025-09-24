class SommeMinMax extends Program {

    void algorithm() {
        int saisieD = readInt();
        int saisieF = readInt();
        int result = 0;

        if (saisieD <= saisieF) {
            for (int i = saisieD; i <= saisieF; i++) {
                result = result + i;
            }
        } else {
            result = 0;
        }

        println(result);
    }
}
