class Semaine3 extends Program {

    // Semaine 1 : couleurs
    // On représente une couleur par trois couleurs primaires
    // correspondant au trois intensité de rouge (red), vert (green) et bleu (blue)
    // Ces intensités varient entre 0 et 255.
    // Ainsi, une couleur peut-être représenté par : "255044138"
    // pour red = 255, green = 044 et blue = 138 (le 0 est important!)
    final int RED    = 0;
    final int GREEN  = 1;
    final int BLUE   = 2;
    int lineTurtle = 0; // indice de la ligne de la tortue (initialement à 0)
    int columnTurtle = 0; // indice de la colomne de la tortue (initialement à 0)
    boolean penDown = true; // position du crayon (initialement baissé)
    String colorPen = "000000255"; // représente la couleur du crayon (initialement à bleu)
    String currentImage = ""; // représente l'image sur laquelle se trouve la tortue

    int charToInt(char digit) {
        return (int) (digit - '0');
    }

    String toString(int primaryColor) {
        String valeur = "00"+primaryColor;
        return substring(valeur, length(valeur)-3, length(valeur));
    }

    String color(int red, int green, int blue) {
        return toString(red) + toString(green) + toString(blue);
    }

    int primaryColorToInt(String primaryColor) {
        return charToInt(charAt(primaryColor, 0)) * 100 +
               charToInt(charAt(primaryColor, 1)) *  10 +
               charToInt(charAt(primaryColor, 2));
    }

    int primaryColorIndex(int primaryColor) {
        return primaryColor * 3;
    }

    int get(String color, int primaryColor) {
        int indiceDebut = primaryColorIndex(primaryColor);
        return primaryColorToInt(substring(color, indiceDebut, indiceDebut + 3));
    }

    String set(String color, int primaryColor, int valeur) {
        String newColor = "";
        int idxStart = primaryColorIndex(primaryColor);
        // on copie ce qui est avant l'indice de primaryColor (éventuellement rien)
        newColor = newColor + substring(color, 0, idxStart);
        // on accumule la nouvelle valeur en la normalisant avant
        newColor = newColor + toString(valeur);
        // on copie tout ce qui est après la composte
        newColor = newColor + substring(color, idxStart+3, length(color));
        return newColor;
    }

    // Semaine 2 : images
    // On souhaite maintenant représenter une grille carrée de pixels de couleurs.
    // Le choix de la grille carré évite d'avoir à encoder les dimensions de l'image.
    // Pour cela, on propose d'utiliser une simple chaîne de caractères contenant
    // tous les pixels les uns à la suite des autres.

    int size(String image) {
        return sqrt(length(image)/9);
    }

    // on sait que la grille est carré, donc on récupère d'abord sa taille
    // avec size, on peut calculer l'indice de début du pixel nous intéressant
    // en multipliant par 9 l'indice de colonne (vu qu'un pixel fait 9 caractères) et
    // en multipliant l'indice de ligne par la taille d'une ligne dans l'image.
    String get(String image, int line, int column) {
        int imageSize = size(image);
        int idxStart  = line * imageSize * 9 + column * 9;
        return substring(image, idxStart, idxStart + 9);
    }

    String generate(int size, int r, int g, int b, int stepR, int stepG, int stepB) {
        String image = "";
        int red = r, green = g, blue = b;
        for (int line = 0; line < size * size; line = line + 1) {
            if (line % size == 0) {
                red   = (red   + stepR) % 255;
                green = (green + stepG) % 255;
                blue  = (blue  + stepB) % 255;
            }
            image = image + color(red, green, blue);
        }
        return image;
    }

    void show(String image) {
        int imageSize = size(image);
        for (int line = 0; line < size(image); line = line + 1) {
            for (int column = 0; column < size(image); column = column + 1) {
                String color = get(image, line, column);
                String ansiColor = rgb(get(color, RED),
                                       get(color, GREEN),
                                        get(color, BLUE),
                                    false);
                print(ansiColor + ' ' + RESET);
            }
            println();
        }
    }


    void algorithm() {
        String image = generate(5, 200, 100, 150, 10, 20, 30);
        setCurrentImage(image);
        penDown = true;
        colorPen = color(255,0,0);  // rouge
        go(3, 3);
        show(currentImage);
        colorPen = color(0,255,0);  // vert
        move(NORTH);
        show(currentImage);
        colorPen = color(0,0,255);  // bleu
        move(SOUTH);
        show(currentImage);
        colorPen = color(255,255,0); // jaune
        move(EAST);
        show(currentImage);
        colorPen = color(255,0,255); // violet
        move(WEST);
        show(currentImage);
    }

    void togglePen() { penDown = !penDown; }

    boolean within(int min, int max, int value){
        if(value >= min && value <= max) return true; return false;
    }

    boolean inside(int imageSize, int line, int column){
        return within(0, imageSize - 1, line) && within(0, imageSize - 1, column);
    }

    void setCurrentImage(String image) {
        currentImage = image;
    }

    String set(String image, int line, int column, String color) {
        String newImage = "";
        int imageSize = size(image);
        int idxStart  = line * imageSize * 9 + column * 9;
        // on copie ce qui est avant le pixel ( possiblement rien en vrai)
        newImage = newImage + substring(image, 0, idxStart);
        // on ajoute la nouvelle couleur
        newImage = newImage + color;
        // on copie ce qui est après le pixel
        newImage = newImage + substring(image, idxStart + 9, length(image));
        return newImage;
    }

    void trace() {
        if (penDown) {
            currentImage = set(currentImage, lineTurtle, columnTurtle, colorPen);
        }
    }

    final int[] NORTH = {-1, 0};
    final int[] SOUTH = {1, 0};
    final int[] EAST = {0, 1};
    final int[] WEST = {0, -1};

    boolean go(int line, int column) {
        int imageSize = size(currentImage);
        if (inside(imageSize, line, column)) {
            lineTurtle = line;
            columnTurtle = column;
            trace();
            return true;
        }
        return false;
    }

    boolean move(int[] direction) {
        int newLine = lineTurtle + direction[0];
        int newColumn = columnTurtle + direction[1];
        return go(newLine, newColumn);
    }
}
