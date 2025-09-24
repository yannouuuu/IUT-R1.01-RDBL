class DiviseursParfait extends Program {

    void algorithm() {
        int n = readInt();
        print("Diviseurs :");

        int sum = 0;
        
        for (int i = n; i >= 1; i--) {
            if (n % i == 0) {
                print(" " + i);
                sum += i;
            }
        }
        print(".\n");

        if (sum == 2 * n) {
            println("Nombre parfait !");
        }
    }
}
