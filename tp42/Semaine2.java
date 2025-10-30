import java.io.BufferedReader;
import java.nio.file.spi.FileSystemProvider;

public class Semaine2 extends Program{

    // Semaine 1 : couleurs
    // On représente une couleur par trois primaryColors numériques
    // correspondant au trois intensité de red, green et blue
    // Ces intensités varient entre 0 et 255.
    // Ainsi, une couleur peut-être représenté par : "255044138"
    // pour red = 255, green = 044 et blue = 138 (le 0 est important!)
    final int RED    = 0;
    final int GREEN  = 1;
    final int BLUE   = 2;


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

    void algorithm() {
        String image = generate(5, 200, 255, 155, -20, -30, -15);
        println(rgb(255,125,75, false) + image + RESET);
        show(image);
        image = generate(10, 0, 0, 0, 25, 40, 55);
        
        println(rgb(255,125,75, true) + image + RESET);
        show(image);
    }

    // Semaine 2 : Représenter des images

    int size(String image){
        return sqrt(length(image) / 9 );
    }

    String get(String image, int line, int column) {
        int imageSize = size(image);
        int pixelSize = 9;
        int lineSize = imageSize * pixelSize; 
        
        int startIndex = line * lineSize + column * pixelSize;
        return substring(image, startIndex, startIndex + pixelSize);
    }

    String generate(int size, int red, int green, int blue, int stepR, int stepG, int stepB){
        String image = "";
        for (int i = 0; i < size; i++) {
            red = (red + stepR) % 255;
            blue = (blue + stepB) % 255;
            green = (green + stepG) % 255;
            String r = toString(red);
            String g = toString(green);
            String b = toString(blue);

            for (int j = 0; j < size; j++) {
                image+= r+g+b;
            }
        }
        return image;
    }

    void show(String image){
        int imageSize = size(image);
        
        for (int line = 0; line < imageSize; line++) {
            for (int col = 0; col < imageSize; col++) {
                String pixel = get(image, line, col);
                int r = get(pixel, RED);
                int g = get(pixel, GREEN);
                int b = get(pixel, BLUE);
                print(rgb(r, g, b, false) + "  " + RESET);
            }
            println(); 
        }
    }
}
