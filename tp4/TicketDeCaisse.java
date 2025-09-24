class TicketDeCaisse extends Program {
    
    void algorithm() {
        int total = 0;
        int entier;
        do {
            entier = readInt();
            total = total + entier;
        } while (entier != 0);
        println("Total=" + total);
    }
}
