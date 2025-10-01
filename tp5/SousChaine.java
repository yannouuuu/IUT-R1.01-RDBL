class SousChaine extends Program {

boolean contient(String chaine, String motif){
    int n = length(chaine);
    int m = length(motif);

    if (m == 0) {
        return true;
    }
    if (n == 0 || m > n) {
        return false;
    }

    int i = 0;
    while (i <= n - m) {
        int j = 0;
        while (j < m && charAt(chaine, i + j) == charAt(motif, j)) {
                j++;
        }
        if (j == m) {
            return true;
        }
        i++;
    }
    return false;
}

void algorithm() {
    String chaine, motif;
    print("Veuillez entrer un texte : ");
    chaine = readString();
    print("Motif à chercher : ");
    motif = readString();
    if(contient(chaine,motif)) {
        println("trouvé");
    } else {
        println("pas trouvé");
    }
}

}
