class Tournoi extends Program {

    void algorithm() {
    }

    public Joueuse newJoueuse(String nom) {
        Joueuse j = new Joueuse();
        j.nom = nom;
        return j;
    }

    public Joueuse newJoueuse(String nom, boolean[] parties) {
        Joueuse j = new Joueuse();
        j.nom = nom;
        j.parties = j.parties;
        return j;
    }

    public String toString(Joueuse j) {
        return j.nom;
    }
    
}
