class Diviseurs extends Program {

    void algorithm() {
        int n = readInt();
        print("Diviseurs :");

        for (int i = n; i >= 1; i--) {
            if (n % i == 0) {
                print(" " + i);
            }
        }
        
        println(".");
    }
}
