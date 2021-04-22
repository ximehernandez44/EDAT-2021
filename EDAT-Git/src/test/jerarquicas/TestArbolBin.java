/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;
import jerarquicas.ArbolBin;

public class TestArbolBin {

    public static void main(String[] args) {
        ArbolBin arbol = new ArbolBin();

        System.out.println("--------- Inserta elementos --------------");
        System.out.println(arbol.insertar('A', 'A', 'I') ? "Ok" : "Err");
        System.out.println(arbol.insertar('B', 'A', 'I') ? "Ok" : "Err");
        System.out.println(arbol.insertar('C', 'A', 'D') ? "Ok" : "Er");
        System.out.println(arbol.insertar('D', 'B', 'I') ? "Ok" : "Err");
        System.out.println(arbol.insertar('E', 'B', 'D') ? "Ok" : "Er");

        /*          A
                   / \
                  B   C
                 / \
                D   E
         */
        
        System.out.println("\n----------Arbol es vacio?-----------");
        System.out.println(arbol.esVacio());

        System.out.println("\n-------- Muestra como String -----");
        System.out.println(arbol.toString());
        

        
        System.out.println("\n-------- Lista en Preorden --------");
        System.out.println(arbol.listarPreorden().toString());
        
        System.out.println("\n--------- Lista en Inorden ----------");
        System.out.println(arbol.listarInorden());

        System.out.println("\n----------- Lista en Posorden ---------");
        System.out.println(arbol.listarPosorden());
        
        System.out.println("\n------- Lista por niveles --------");
        System.out.println(arbol.listarNiveles());
        
        
        
        
        System.out.println("\n---------- Muestra altura -----------");
        System.out.println(arbol.altura());
        

        System.out.println("\n-- Solicita padre de elemento existente (C) --");
        System.out.println("Espera 'A': " +arbol.padre('C'));

        System.out.println("\n-- Solicita padre de elemento no existente --");
        System.out.println(arbol.padre('Z'));
        
        
        
        
        System.out.println("\n---------- Muestra el nivel de la raiz -----------");
        System.out.println("Espera 0: " +arbol.nivel('A'));
        
        System.out.println("\n---------- Muestra el nivel de D -----------");
        System.out.println("Espera 2: " +arbol.nivel('D'));
        
        System.out.println("\n--- Muestra el nivel de un elem inexistente ---");
        System.out.println(arbol.nivel('X'));
    }
}
