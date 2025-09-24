class PlusPetitNombre extends Program {
    void algorithm() {
        print("Entrez deux nombres : ");
        int a = readInt();
        int b = readInt();

        int plusPetit;
        if (a <= b) {
            plusPetit = a;
        } else {
            plusPetit = b;
        }

        println("Le plus petit est " + plusPetit);
    }
}
