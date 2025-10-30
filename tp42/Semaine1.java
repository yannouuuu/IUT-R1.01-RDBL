class Semaine1 extends Program {

    // Semaine 1 : couleurs
    // On représente une couleur par trois primaryColors numériques
    // correspondant au trois intensité de red, green et blue
    // Ces intensités varient entre 0 et 255.
    // Ainsi, une couleur peut-être représenté par : "255044138"
    // pour red = 255, green = 044 et blue = 138 (le 0 est important!)
    final int RED    = 0;
    final int GREEN  = 1;
    final int BLUE   = 2;



    void algorithm() {
        println(charToInt('4'));
    }


    int charToInt(char chiffre){
        return chiffre - '0';
    }

    String toString(int composante){
        if (composante < 10) {
            return "00" + composante;
        } else if (composante < 100) {
            return "0" + composante;
        } else {
            return "" + composante;
        }
    }

    String color(int red, int green, int blue){
        return toString(red) + toString(green) + toString(blue);
    }

    int primaryColorToInt(String primaryColor){
        return charToInt(charAt(primaryColor,0)) * 100 + 
            charToInt(charAt(primaryColor, 1))* 10 + 
            charToInt(charAt(primaryColor, 2));
    }

    int primaryColorIndex(int primaryColor){
        return primaryColor * 3;
    }

    int get(String color, int primaryColor){
        int startIndex = primaryColorIndex(primaryColor);
        String primaryColorString = substring(color, startIndex, startIndex + 3);
        return primaryColorToInt(primaryColorString);
    }

    String set(String color, int primaryColor, int value){
        int blue = get(color, BLUE);
        int green = get(color, GREEN);
        int red = get(color, RED);

        if(primaryColor == RED){
            red = value;
        } else if (primaryColor == GREEN){
            green = value;
        } else {
            blue = value;
        }
        return color(red, green, blue);
    }
}
