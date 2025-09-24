class DoublerCaracteres extends Program {
    void algorithm() {
     // TODO: implement the algorithm
        String str = readString();
        String result = "";
        for(int i = 0; i < length(str); i++){
            char c = charAt(str, i);
            char temp = c;
            result = result + c + temp; 
        }

        print(result);
    }
}
