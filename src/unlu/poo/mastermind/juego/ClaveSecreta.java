package unlu.poo.mastermind.juego;

public class ClaveSecreta extends Clave {
    public ClaveSecreta() {
        super();

        try {
            for (int i = 1; i <= 5; i++)
                this.setColor(FichaCodificadora.ROJO, i);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FichaResultado[] comparar(Clave claveAProbar) {

        int[] frecuencias = calcularFrecuencias();

        FichaResultado[] respuesta = {FichaResultado.BUENA,
                FichaResultado.MALA,
                FichaResultado.MALA,
                FichaResultado.MALA,
                FichaResultado.MALA};

        // Obtener las buenas
        for (int i = 1; i <= 5; i++) {
            try {
                if (this.getColor(i) == claveAProbar.getColor(i)) {
                    respuesta[i-1] = FichaResultado.BUENA;
                    frecuencias[this.getColor(i).ordinal()]--;
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Clave probada incompleta!!");
            }
        }

        // Obtener regulares
        for (int i = 1; i <= 5; i++) {
            if(respuesta[i-1].equals(FichaResultado.MALA)){
                try {
                    if (frecuencias[claveAProbar.getColor(i).ordinal()] > 0) {
                        respuesta[i-1] = FichaResultado.REGULAR;
                        frecuencias[this.getColor(i).ordinal()]--;
                    }
                } catch (Exception e) {
                    throw new IllegalArgumentException("Clave probada incompleta!!");
                }
            }
        }

        return respuesta;
    }

    private int[] calcularFrecuencias() {
        int[] resultado = new int[FichaCodificadora.values().length];

        for (int f : resultado) f = 0;
        int pos = 0;
        for (int i = 1; i <= 5; i++) {

            try {
                pos = this.getColor(i).ordinal();
                resultado[pos]++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

}
