package unlu.poo.mastermind.juego;

public class Clave {

    private FichaCodificadora[] miCombinacion = new FichaCodificadora[5];

    public Clave(FichaCodificadora[] miCombinacion) {
        if (miCombinacion.length <= 5) {
            int i = 0;
            for(FichaCodificadora f : miCombinacion){
                this.miCombinacion[i++] = f;
            }
        }
    }

    public Clave() {

    }

    public FichaCodificadora getColor(int pos) throws Exception{

        if(pos >= 1 && pos <= miCombinacion.length) {
            return miCombinacion[pos - 1];
        }else{
            throw new Exception("Posicion fuera de rango!!!");
        }
    }

    public void setColor(FichaCodificadora ficha, int pos) throws Exception {
        if(pos >= 1 && pos <= miCombinacion.length) {
            miCombinacion[pos - 1] = ficha;
        }else{
            throw new Exception("Posicion fuera de rango!!!");
        }
    }

    public Boolean isCompleta() {
        Boolean flag = true;
        for(FichaCodificadora f : miCombinacion){
            flag &= (f != null);
        }
        return flag;
    }
}
