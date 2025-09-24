class JeuxDeType extends Program {

    void algorithm(){
            /* TODO: Complete this */ String prenom = "Alan";
            /* TODO: Complete this */ String nom = "Turing";
            /* TODO: Complete this */ int naissance = 1912;
            /* TODO: Complete this */ int annee = 2022;
            /* TODO: Complete this */ int age = annee - naissance;
            /* TODO: Complete this */ char initiale = charAt(prenom,0);
            println(initiale + ". " + nom + " aurait eu " + age + " ans en " + annee);
        }
}
