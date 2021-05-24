/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
import lineales.dinamicas.Lista;

/**
 *
 * @author ximeh
 */
public class MixLineales {

    public static void main(String[] args) {
        Cola c1 = new Cola();
        Cola aux = new Cola();

        /*nueva clase MixLineales en el paquete test.lineales, implementar el método: generarOtraCola(Cola
c1) que recibe por parámetro una estructura de tipo Cola c1 con elementos de tipo char que tiene el
siguiente formato: a1$a2$a3$. . . :$an, donde cada ai en una sucesión de letras mayúsculas y a partir de c1
debe generar como salida otra Cola de la forma: a1a1$a2a2$ : : : :$anan donde cada ai es la secuencia de
letras de ai invertida. Ejemplo: Si c1 es : AB$C$DEF, la operación generarOtraCola devolverá una Cola
con el siguiente formato: ABBA$CC$DEFFED
NOTA: Para lograr los tramos invertidos de la Cola de salida debe utilizar una estructura Pila auxiliar.*/
 /*c1.poner('A');
        c1.poner('B');
        c1.poner('$');
        c1.poner('C');
        c1.poner('$');
        c1.poner('D');
        c1.poner('E');
        c1.poner('F');

        aux = generarOtraCola(c1);
        System.out.println(aux.toString());*/
        //AB#C#DEF
        c1.poner('A');
        c1.poner('B');
        c1.poner('#');
        c1.poner('C');
        c1.poner('#');
        c1.poner('D');
        c1.poner('E');
        c1.poner('F');

        aux = generar(c1);
        System.out.println(aux);

        System.out.println("---------------------PARCIAL------------------");
        //Si cola1 es  RTZ$TY$ZR$WYX, entonces la operación crearLista devolverá una Lista con el siguiente formato: ZTR$TY$RZ$WYX.
        System.out.println("Vacio la cola c1");
        c1.vaciar();
        System.out.println("La cargo");
        c1.poner('R');
        c1.poner('T');
        c1.poner('Z');
        c1.poner('$');
        c1.poner('T');
        c1.poner('Y');
        c1.poner('$');
        c1.poner('Z');
        c1.poner('R');
        /*c1.poner('$');
        c1.poner('W');
        c1.poner('Y');
        c1.poner('X');*/
        System.out.println("Antes del metodo la cola es " + c1.toString());
        System.out.println("genero la lista nueva, es:");
        System.out.println(crearLista(c1).toString());

    }

    public static Cola generarOtraCola(Cola c1) {
        Cola nueva = new Cola();
        Cola clon = c1.clone();
        Pila aux = new Pila();

        while (!clon.esVacia()) {
            if ((char) clon.obtenerFrente() == '$') {
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

    public static Cola generar(Cola c1) {
        Pila pila = new Pila();
        Cola nueva = new Cola();
        Lista lista = new Lista();
        int pos = 0;
        Cola clon = c1.clone();

        if (!clon.esVacia()) {
            while (clon.obtenerFrente() != null) {
                if ((char) clon.obtenerFrente() == '#') {
                    while (!pila.esVacia()) {
                        nueva.poner(pila.obtenerTope());
                        pila.desapilar();
                    }
                    while (!lista.esVacia()) {
                        nueva.poner(lista.recuperar(1));
                        lista.eliminar(1);
                        pos--;
                    }
                    nueva.poner('#');
                } else {
                    pila.apilar(clon.obtenerFrente());
                    lista.insertar(clon.obtenerFrente(), pos + 1);
                    nueva.poner(clon.obtenerFrente());
                    pos++;
                }
                clon.sacar();
            }
            if (!pila.esVacia()) {
                nueva.poner(pila.obtenerTope());
                pila.desapilar();
            }
            while (!lista.esVacia()) {
                nueva.poner(lista.recuperar(1));
                lista.eliminar(1);
            }
        }
        return nueva;

    }

    public static Lista crearLista(Cola c1) {
        int cad = 1;
        int pos = 1;
        Cola clon = c1.clone();
        Lista nueva = new Lista();
        Pila pilaAux = new Pila();

        if (!clon.esVacia()) {
            while (clon.obtenerFrente() != null) {
                if (cad % 2 == 0) { //si la cadena es de numero par
                    if ((char) clon.obtenerFrente() == '$') {
                        cad++;
                    }

                    //si es par, va insertando lo que esta en la cola clon
                    nueva.insertar(clon.obtenerFrente(), pos);
                    pos++;

                } else { //si la cadena es de numero impar
                    if ((char) clon.obtenerFrente() == '$') {
                        cad++;
                        while (!pilaAux.esVacia()) {
                            nueva.insertar(pilaAux.obtenerTope(), pos);
                            pilaAux.desapilar();
                            pos++;
                        }
                        nueva.insertar('$', pos);
                        pos++;

                    } else {
                        //si es impar y aun no llega a $, carga en la pila
                        pilaAux.apilar(clon.obtenerFrente());

                    }
                }
                clon.sacar();
            }
            //si ya termino el recorrido y la ultima cadena fue impar, la carga de la pila
            if (cad % 2 != 0) {
                while (!pilaAux.esVacia()) {
                    nueva.insertar(pilaAux.obtenerTope(), pos);
                    pilaAux.desapilar();
                    pos++;
                }
            }
        }
        return nueva;
    }
}
