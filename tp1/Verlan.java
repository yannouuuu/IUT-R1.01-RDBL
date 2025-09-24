class Verlan extends Program {
    void algorithm(){
            /* TODO: Complete this */ String mot = readString(); // louche
            /* TODO: Complete this */ int tailleMot = length(mot); // 6
            /* TODO: Complete this */ String indiceMilieu = substring(mot, 0, length(mot) / 2); // lou 
            /* TODO: Complete this */ String debut = indiceMilieu; 
            /* TODO: Complete this */ String fin = substring(mot, (tailleMot/2) , length(mot));
            println(fin + debut);
        }
}
