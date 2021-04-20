/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;
import jerarquicas.ArbolBin;

public class TestArbolBin {

    public static void main(String[] args) {
        ArbolBin arbol1 = new ArbolBin();

        System.out.println("COMIENZA TEST **************************************");
        //PRUEBA INSERTAR
        System.out.println("PRUEBA INSERTAR");
        System.out.println(arbol1.insertar('A', 'A', 'I') ? "Bien" : "Mal");
        System.out.println(arbol1.insertar('B', 'A', 'I') ? "Bien" : "Mal");
        System.out.println(arbol1.insertar('C', 'A', 'D') ? "Bien" : "Mal");
        System.out.println(arbol1.insertar('D', 'B', 'I') ? "Bien" : "Mal");
        System.out.println(arbol1.insertar('E', 'B', 'D') ? "Bien" : "Mal");

        /*
                    A
                   / \
                  B   C
                 / \
                D   E
         */
        System.out.println("PRUEBA ES VACIA");
        //PRUEBA ES VACIO
        System.out.println(arbol1.esVacio());
        System.out.println("");

        /*System.out.println("PRUEBA TO STRING");
        //PRUEBA TO STRING 
        System.out.println(arbol1.toString());
        System.out.println("");*/

        System.out.println("PRUEBA LISTAR PRE ORDEN");
        //PRUEBA LISTAR PRE ORDEN
        System.out.println(arbol1.listarPreorden().toString());
        System.out.println("");
        
        System.out.println("PRUEBA ALTURA");
        //PRUEBA ALTURA
        System.out.println(arbol1.altura());
        System.out.println("");
        
        /*System.out.println("PRUEBA LISTAR IN ORDEN");
        //PRUEBA LISTAR IN ORDEN
        System.out.println(arbol1.listarInOrden());
        System.out.println("");

        System.out.println("PRUEBA LISTAR POS ORDEN");
        //PRUEBA LISTAR POS ORDEN
        System.out.println(arbol1.listarPosOrden());
        System.out.println("");

        */System.out.println("PRUEBA PADRE ELEMENTO EXISTENTE");
        //PRUEBA LISTAR POS ORDEN
        System.out.println(arbol1.padre('C'));
        System.out.println("");

        System.out.println("PRUEBA PADRE ELEMENTO NO EXISTENTE");
        //PRUEBA LISTAR POS ORDEN
        System.out.println(arbol1.padre('Z'));
        System.out.println("");
        
        System.out.println("PRUEBA DE NIVEL DE ELEMENTO EXISTENTE");
        System.out.println(arbol1.nivel('A'));
        System.out.println("");
        
        System.out.println("PRUEBA DE NIVEL DE ELEMENTO NO EXISTENTE");
        System.out.println(arbol1.nivel('X'));
        System.out.println("");
    }
}
