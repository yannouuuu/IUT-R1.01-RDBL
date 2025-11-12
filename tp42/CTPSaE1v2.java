class CTPSaE1v2 extends Program {
            // Q1 : Définition de la fonction colorCode (4 pt)

            // 1. On attribue un indice palette
            // 2. Condition + 
            int colorCode(String[] palette, String color){ 
                for(int i = 0; i < length(palette); i++){
                    if(color == palette[i])
                        return i;
                }
                return -1;
            }

            // Q2 : Définition de la fonction numberOfPixels (2 pt)
            int numberOfPixels(String image){
                final int imageSize = 9;
                int occ = 0; 
                for(int i = 0; i < length(image) - imageSize ; i++){
                    String pixel = substring(image, i, i + imageSize);
                    occ++;
                }
                return occ;
            }

            // Q3 : int[] convertOldToNew(String image, String[] palette) (4 pts)
            // int[] convertOldToNew(String image, String[] palette){
            //     int[] tab = new int[numberOfPixels(image)];
                
            //     // Dire que tel pixel = cette couleur dans la palette et faire ça sous un tab entier
            //     // 1. Prend une longueur de l'image de taille 9
            //     // 2. Vérifie quelle est la couleur avec colorCode()
            //     // 3. On retourne la valeur dans l'indice i à tab 
            //     // 1 for qui parcourt la taille de l'image, 1 
                
            //     for(int j = 0; i < length(tab) ; i++){
            //         for(int i = 0; i < length(numberOfPixels(image)); i+9){
            //             tab[i] = substring(image, i, );
            //         }
            //     }

            //    return tab;
            // }


            // Q4 : String convertNewToOld(int[] image, String[] palette) (4 pts)

            // Q5 : String[] shift(String[] palette, boolean right) (3 pts)
            String[] shift(String[] palette, boolean right){
                String[] tab = new String[5];

                if(right == true){ // vers la droite
                    tab[0] = palette[length(palette) - 1];
                    for(int i = 1; i < length(tab) - 1; i++){
                        tab[i] = palette[i+1];
                    }
                } // else {  // vers la gauche
                //     for(int i = 0; i < length(tab) - 1; i++){

                //     }
                // }

                return tab;
            }

            // Q6 : void show(int[] image, String[] palette) (3 pts)
            // void show(int[] image, String[] palette){
            //     int imageSize = 9;
            //     for (int line = 0; line < 9; line = line + 1) {
            //         for (int column = 0; column < 9; column = column + 1) {
            //             String color = get(image, line, column);
            //             String ansiColor = rgb(get(color, RED),
            //                                 get(color, GREEN),
            //                                 get(color, BLUE),
            //                                 false);
            //             print(ansiColor + ' ' + RESET);
            //         }
            //         println();
            //     }
            // }

            // String get(String image, int line, int column) {
            //     int imageSize = 9;
            //     int idxStart  = line * imageSize * 9 + column * 9;
            //     return substring(image, idxStart, idxStart + 9);
            // }

            // int size(String image) {
            //     return sqrt(length(image)/9);
            // }

            void algorithm() {
                final String IMAGE_3x3 = "255000000"+"000255000"+"000000255"+
                                        "000000000"+"255000000"+"000255000"+
                                        "255255255"+"000000000"+"255000000";
                final String[] PALETTE = {
                    "255000000", // rouge
                    "000255000", // vert
                    "000000255", // bleu
                    "000000000", // noir
                    "255255255"  // blanc
                };

                //show(convertOldToNew(IMAGE, PALETTE), PALETTE);
            }


}
