
package fuerzabrutaproyecto;    

import javax.swing.JOptionPane;

public class FuerzaBrutaProyecto {
    /*
       * Este proyecto te da todas las claves en el codigo Cesar, justo en el ejemplo 1, tenemos en el codigo 13 
        donde puedes ingresar el mensaje normal o el que queieres decifrar en diferentes claves del codigo Cesar.
       -----------------------------------------------------------------------------------------------------------
       si quisiéramos cifrar la letra a con una clave = 6, 
       simplemente desplazaríamos nuestra letra 6 posiciones en el alfabeto: a, b, c, d, e, f, g. Para descifrar la g, 
       repetiríamos el proceso pero en orden contrario: g, f, e, d, c, b, a.
      --------------------------------------------------------------------------------------------------------------
    
    ejemplo1:
       para la clave 13 : 
       A B C D E F G H I J K L M --> 13 LETRAS 
       N O P Q R S T U V W X Y Z
      *Si queremos decifrar hola en clave 13 seria asi 
                H O L A
                U B Y N
    */

    private Character[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private char[] textoDecodificado;
    private String[] resultado;
    private java.util.List<Character> ListAlfabeto; // lista de caracteres con el objeto Character 

    public FuerzaBrutaProyecto(){
        //asList que devuelve un tipo List cuando se le invoca pasándole un array como parámetro. 
        ListAlfabeto = java.util.Arrays.asList(alfabeto);
        resultado = new String[alfabeto.length];
    }

    public String[] busquedaDecifrado(String cifradoTexto) {
        // .toCharArray -->     convierte un String en un arreglo de caracteres
        //pone cada letra que se le pasa en una arreglo de caracteres y todos los convierte en Mayusculas.
        char[] mensaje = cifradoTexto.toUpperCase().toCharArray();
        //vamos hacer un loop para ver todas las posibilidades 
        for (int i = 0; i < alfabeto.length; i++) {
            //hacer que el textoDecodificado tenga el mismo largo cifradoTexto en otras palabras el mismo .length
            textoDecodificado = new char[mensaje.length];
            // interatar con todos los caracteres del cifradoTexto
            for (int j = 0; j < mensaje.length; j++) {

                // si  el mensaje no tiene espacio
                if (mensaje[j] != ' ') {
                                                                 // indexof() retorna el indice del string
                    textoDecodificado[j] = alfabeto[(ListAlfabeto.indexOf(mensaje[j])+i) % alfabeto.length];
                }else
                    textoDecodificado[j] = ' ';
               } // retorna en una representacion de String todo el arreflo del char [] en este caso, porque  puede ser double 
                // boolean , long 
            resultado[i] = String.valueOf(textoDecodificado);
        }
        return resultado;
    }

    public static void main(String[] args) {
        FuerzaBrutaProyecto t = new FuerzaBrutaProyecto();
        String palabra = JOptionPane.showInputDialog("Ingresar la palabra para Encriptar o Desencriptar: ");
        // iteratar todo lo que el metodo String[] nos devuelve mediante un for especial y se almacena pt 
        for(String pt : t.busquedaDecifrado(palabra)) {
          System.out.println(pt); //  0 - 25 salidas
        }
    
    }
}