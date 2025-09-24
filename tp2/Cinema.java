class Cinema extends Program {
    void algorithm() {
        double prix = 12.0;

        print("Age du spectateur : ");
        int age = readInt();

        print("Option 3D ? (1 si oui, autre chiffre si non) : ");
        int option3D = readInt();

        print("Abonné ? (1 si oui, autre chiffre si non) : ");
        int abonne = readInt();

        if (age < 10) {
            prix = prix / 2;
        } else if ((age < 16) || (age > 60)) {
            prix = prix - 3;
        }

        if (option3D == 1) {
            prix = prix + 2;
        }

        if (abonne == 1) {
            prix = prix * 0.8;
        }

        println("Coût du billet : " + prix + " euros");
    }
}
