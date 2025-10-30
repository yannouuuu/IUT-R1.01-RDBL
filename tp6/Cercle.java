class Cercle extends Program {

    final double PI = 3.14159; 
    final double QUATRE_TIERS_DE_PI = 4.0 / 3.0 * PI;

    int nombreDeMultiplications = 0;

    double multiplication(double a, double b) {
        nombreDeMultiplications++;
        return a * b;
    }

    double circonference(double rayon) {
        return multiplication(PI, diametre(rayon)); 
    }

    double diametre(double rayon) {
        return multiplication(2, rayon);
    }

    double aire(double rayon) {
        double rayonCarre = multiplication(rayon, rayon);
        return multiplication(PI, rayonCarre);
    }

    double volume(double rayon) {
        double rayonCarre = multiplication(rayon, rayon);
        double rayonCube = multiplication(rayonCarre, rayon);
        return multiplication(QUATRE_TIERS_DE_PI, rayonCube);
    }

    void algorithm() {
        for (int rayon = 1; rayon <= 15; rayon++) {
            double c = circonference(rayon);
            double v = volume(rayon);
            double d = diametre(rayon);
            print("circonference(" + rayon + ") = " + c + ", ");
            print("diametre(" + rayon + ") = " + d + ", ");
            print("volume(" + rayon + ") = " + v + ".\n");
        }
        print("Soit un total de " + nombreDeMultiplications + " multiplications.\n");
    }

}
