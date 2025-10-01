class Iut extends Program {

void algorithm(){
    print("Taille : ");
    int t = readInt();
    // à compléter
    dessinerI(t, 'I');
    println("");
    dessinerU(t, 'U');
    println("");
    dessinerT(t, 'T');
}

void dessineLigne(int n, char c){
    for (int i = 0; i < n; i++) {
        print(c);
    }
    println("");
}

void dessineMilieu(int n, char c){
    for (int i = 0; i < n / 2; i++) {
        print(' ');
    }
    print(c);
    println("");
}

void dessineExtremites(int n, char c){
    print(c);
    for (int i = 0; i < n - 2; i++) {
        print(' ');
    }
    if (n > 1) {
        print(c);
    }
    println("");
}

void dessinerI(int n, char c) {
    int i;
    dessineLigne(n, c);
    for (i = 0; i < n - 2; i = i + 1) {
        dessineMilieu(n, c);
    }
    dessineLigne(n, c);
}

void dessinerU(int n, char c) {
    int i;
    for (i = 0; i < n - 1; i = i + 1) {
        dessineExtremites(n, c);
    }
    dessineLigne(n, c);
}

void dessinerT(int n, char c) {
    int i;
    dessineLigne(n, c);
    for (i = 0; i < n - 1; i = i + 1) {
        dessineMilieu(n, c);
    }
}
}
