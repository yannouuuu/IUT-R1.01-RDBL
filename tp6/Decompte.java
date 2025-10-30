class Decompte extends Program {

        void test_genereNombresPairs1() {
            assertEquals("8642",     genereNombresPairs1(8));
            assertEquals("12108642", genereNombresPairs1(12));
            assertEquals("2",        genereNombresPairs1(2));
        }

        void test_genereNombresPairs2() {
            assertEquals("*8642*",     genereNombresPairs2(8));
            assertEquals("*12108642*", genereNombresPairs2(12));
            assertEquals("*2*",        genereNombresPairs2(2));
        }

        void test_genereNombresPairs3() {
            assertEquals("8*6*4*2",       genereNombresPairs3(8));
            assertEquals("12*10*8*6*4*2", genereNombresPairs3(12));
            assertEquals("2",             genereNombresPairs3(2));
        }

        void algorithm() {
        }

        String genereNombresPairs1(int nb) {
            String suite = "";
            for (int i = nb; i >= 2; i -= 2) {
                suite += i;
            }
            return suite;
        }

        String genereNombresPairs2(int nb) {
            String suite = "*";
            for (int i = nb; i >= 2; i -= 2) {
                suite += i;
            }
            suite += "*";
            return suite;
        }

        String genereNombresPairs3(int nb) {
            String suite = "";
            for (int i = nb; i >= 2; i -= 2) {
                suite += i;
                if (i > 2) {
                    suite += "*";
                }
            }
            return suite;
        }

}
