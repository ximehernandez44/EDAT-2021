/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
/**
 *
 * @author ximeh
 */
public class MixLineales {
    public static void main(String[] args) {
        Cola c1 =  new Cola();
        Cola aux = new Cola();
       
        /*nueva clase MixLineales en el paquete test.lineales, implementar el método: generarOtraCola(Cola
c1) que recibe por parámetro una estructura de tipo Cola c1 con elementos de tipo char que tiene el
siguiente formato: a1$a2$a3$. . . :$an, donde cada ai en una sucesión de letras mayúsculas y a partir de c1
debe generar como salida otra Cola de la forma: a1a1$a2a2$ : : : :$anan donde cada ai es la secuencia de
letras de ai invertida. Ejemplo: Si c1 es : AB$C$DEF, la operación generarOtraCola devolverá una Cola
con el siguiente formato: ABBA$CC$DEFFED
NOTA: Para lograr los tramos invertidos de la Cola de salida debe utilizar una estructura Pila auxiliar.*/
        
        c1.poner('A');
        c1.poner('B');
        c1.poner('$');
        c1.poner('C');
        c1.poner('$');
        c1.poner('D');
        c1.poner('E');
        c1.poner('F');
        
        aux = generarOtraCola(c1);
        System.out.println(aux.toString());
        
    }
    
    public static Cola generarOtraCola(Cola c1) {
        Cola nueva = new Cola();
        Cola clon = c1.clone();
        Pila aux = new Pila();
        
        while(!clon.esVacia()) {
            if ((char) clon.obtenerFrente() == '$' )  {
                while (!aux.esVacia()) {
                    nueva.poner(aux.obtenerTope());
                    aux.desapilar();
                }
            } else {
                aux.apilar(clon.obtenerFrente());
            }
            nueva.poner(clon.obtenerFrente());
            clon.sacar();
            
            if (clon.esVacia()) {
                while (!aux.esVacia()) {
                nueva.poner(aux.obtenerTope());
                aux.desapilar();
                }
            }
        }
        
            
        return nueva;
    }
     
     
    }
 

