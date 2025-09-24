class DevinerNombre extends Program {

    void algorithm() {
        int min = 1;
        int max = 100;
        int guess;
        char response;

        while (true) {
            guess = (min + max) / 2;
            println("Est-ce que le nombre est " + guess + " ?");
            response = readChar();

            if (response == '=') {
                println("Il fallait trouver " + guess +" !");
                break;
            } else if (response == '+') {
                min = guess + 1;
            } else if (response == '-') {
                max = guess - 1;
            }
        }
    }
}
