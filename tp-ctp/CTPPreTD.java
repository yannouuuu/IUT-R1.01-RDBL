public class CTPPreTD extends Program {
    final int RED_COMPONENT = 0;
    final int GREEN_COMPONENT = 1;
    final int BLUE_COMPONENT = 2;

    // Q1 : créer une image de taille*taille avec la couleur (r,g,b)
    int[][] creer(int taille, int r, int g, int b) {
        int[][] image = new int[3][taille * taille];
        
        for (int i = 0; i < taille * taille; i++) {
            image[RED_COMPONENT][i] = r;
            image[GREEN_COMPONENT][i] = g;
            image[BLUE_COMPONENT][i] = b;
        }
        
        return image;
    }

    // Q2 : convertir un entier en chaîne de caractères sur 3 caractères
    String toString(int nb) {
        String result = "" + nb;

        while (length(result) < 3) {
            result = "0" + result;
        }
        
        return result;
    }

    // Q3 : affichage de debogage d'une image dans la console
    String debug(int[][] image) {
        int nbPixels = length(image[0]);
        int taille = 0;
        
        // Calculer la taille (racine carrée du nombre de pixels)
        int i = 0;
        while (i * i < nbPixels) {
            i++;
        }
        taille = i;
        
        String result = "";
        
        for (int y = 0; y < taille; y++) {
            for (int x = 0; x < taille; x++) {
                int pixelIndex = y * taille + x;
                int r = image[RED_COMPONENT][pixelIndex];
                int g = image[GREEN_COMPONENT][pixelIndex];
                int b = image[BLUE_COMPONENT][pixelIndex];
                
                result += "(" + toString(r) + "," + toString(g) + "," + toString(b) + ") ";
            }
            result += "\n";
        }
        
        return result;
    }

    // Q4 : affichage d'une image dans la console en couleurs
    void show(int[][] image) {
        int nbPixels = length(image[0]);
        int taille = 0;
        
        // Calculer la taille (racine carrée du nombre de pixels)
        int i = 0;
        while (i * i < nbPixels) {
            i++;
        }
        taille = i;
        
        for (int y = 0; y < taille; y++) {
            for (int x = 0; x < taille; x++) {
                int pixelIndex = y * taille + x;
                int r = image[RED_COMPONENT][pixelIndex];
                int g = image[GREEN_COMPONENT][pixelIndex];
                int b = image[BLUE_COMPONENT][pixelIndex];
                print(rgb(r, g, b, true) + RESET);
            }
        }
    }

    void algorithm() {
        int[][] image2x2 = creer(2, 0, 32, 64);
        println(debug(image2x2));
        show(image2x2);
    }

}
