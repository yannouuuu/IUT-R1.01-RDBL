class ValeursMinMax extends Program {

    void test_minMax() {
        assertArrayEquals(new int[]{1,3}, minMax(new int[]{2,1,3}));
        assertArrayEquals(new int[]{2,2}, minMax(new int[]{2,2,2}));
        assertArrayEquals(new int[]{-1,3}, minMax(new int[]{3,-1,2}));
    }
    
    void test_indicesMinMax() {
        assertArrayEquals(new int[]{1,2}, indicesMinMax(new double[]{2.1, 1.5, 3.0}));
        assertArrayEquals(new int[]{0,0}, indicesMinMax(new double[]{2.1, 2.1, 2.1}));
        assertArrayEquals(new int[]{1,0}, indicesMinMax(new double[]{3.0, -1.9, 2.5}));
    }
    
    void algorithm() {
    }
    
    int[] minMax(int[] tab){
        int min = tab[0];
        int max = tab[0];
        
        for(int i = 1; i < length(tab); i++){
            if(tab[i] < min){
                min = tab[i];
            }
            if(tab[i] > max){
                max = tab[i];
            }
        }
        
        return new int[]{min, max};
    }
    
    int[] indicesMinMax(double[] tab){
        int indiceMin = 0;
        int indiceMax = 0;
        
        for(int i = 1; i < length(tab); i++){
            if(tab[i] < tab[indiceMin]){
                indiceMin = i;
            }
            if(tab[i] > tab[indiceMax]){
                indiceMax = i;
            }
        }
        
        return new int[]{indiceMin, indiceMax};
    }
}
