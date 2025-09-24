class PGCD extends Program {

    void algorithm() {
        int a = readInt(); // 80
        int b = readInt(); // 70
        int reste;
        while (b != 0) {
            reste = a % b;
            a = b;
            b = reste;
        }

        println("Le pgcd est "+a);
    }

}
