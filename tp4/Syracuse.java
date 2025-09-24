class Syracuse extends Program {
    
    void algorithm() {
        print("Entrez un nombre: ");
        int n = readInt();
        print("Trajectoire: ");
        // à compléter /* TODO: Complete this */

        while(n != 1){
            print(n + ", ");
            if(n%2==0){
                n = n / 2;
            } else {
                n = (n*3) + 1;
            }
        }
        print(1 + ".\n");
    }

}
