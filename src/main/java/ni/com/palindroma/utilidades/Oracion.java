package ni.com.palindroma.utilidades;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

public class Oracion {
    private @Getter @Setter String palabraEnviada;
    private @Getter @Setter boolean palabraPolindroma = false;
    private @Getter @Setter String sCadenaInvertida;


    public String getResultado(){
        if(this.palabraPolindroma) {
            return "La palabra " + this.palabraEnviada + ", es una PALABRA POLINDROMA.......";
        }
        else {
            return "La palabra " + this.palabraEnviada + ",no es políndroma......." ;
        }
    }

    public Oracion(String parametroOracion){
        this.palabraEnviada=parametroOracion;
        this.retornaReverso();
        String sCadenaCompara = this.palabraEnviada.toLowerCase();
        sCadenaCompara=sCadenaCompara.replaceAll(" ","");
        String sCadenaEnviada = this.getSCadenaInvertida();
        if(sCadenaCompara.equals(sCadenaEnviada)){
            this.palabraPolindroma=true;
        }else{
            this.palabraPolindroma=false;
        }
    }

    public void retornaReverso(){
        this.sCadenaInvertida="";
        for (int x=this.palabraEnviada.length()-1;x>=0;x--){
            this.sCadenaInvertida = this.sCadenaInvertida + this.palabraEnviada.charAt(x);
        }
        String sCadenaTemporal = this.sCadenaInvertida.replace(" ","");
        this.sCadenaInvertida=sCadenaTemporal.toLowerCase();
    }

    public static boolean esSi(boolean variable){
        return variable==true;
    }

    public static boolean esPalindrama(String cadenaTexto){
        String cadenaInvertida= StringUtils.reverse(cadenaTexto);
        cadenaInvertida = StringUtils.upperCase(cadenaInvertida).replaceAll(" ","");
        cadenaTexto = StringUtils.upperCase(cadenaTexto).replaceAll(" ","");
        return StringUtils.equals(cadenaInvertida,cadenaTexto);
    }

}
