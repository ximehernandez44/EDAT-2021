/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;
import jerarquicas.ArbolBin;
import lineales.dinamicas.Lista;

public class TestArbolBin {

    public static void main(String[] args) {
        ArbolBin arbol = new ArbolBin();
        ArbolBin arbol2 = new ArbolBin();
        Lista patron = new Lista();

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
        System.out.println(arbol.listarPorNiveles());
        
        
        
        
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
        
        System.out.println("\n----------Cargo la lista-----------");
        patron.insertar('A', 1);
        patron.insertar('B', 2);
        patron.insertar('D', 3);
        System.out.println(patron.toString());
        
        System.out.println("\n------Compruebo el patron---------");
        System.out.println(arbol.verificarPatron(patron));
        
        /*Ejemplo: si en el árbol de la izquierda recibe los elementos pp=63, hi=50, hd=96, 
        debe buscar el primer nodo que tenga elemento igual a 63, cambiar el elemento 87 por 96 
        (sin tocar a sus hijos) y agregarle el hijo izquierdo 50*/
        /* yo hago: pp= B, hi = F, hd = G*/
        
        System.out.println("\n----------Metodo alterar parte---------");
        System.out.println("El arbol inicial es: " +arbol.toString());
        System.out.println("PP = B, Hi = F, hd = G");
        arbol.alterarParte('F', 'G', 'B');
        System.out.println("El arbol resultante es: " +arbol.toString());
        
        System.out.println("\n----------Inserta los numeros a ArbolBin2-------");
        System.out.println(arbol2.insertar(45, 45, 'I') ? "Ok" : "Err");
        System.out.println(arbol2.insertar(32, 45, 'I') ? "Ok" : "Err");
        System.out.println(arbol2.insertar(63, 45, 'D') ? "Ok" : "Er");
        System.out.println(arbol2.insertar(3, 32, 'I') ? "Ok" : "Err");
        System.out.println(arbol2.insertar(5, 32, 'D') ? "Ok" : "Er");
        System.out.println(arbol2.insertar(87, 63, 'D') ? "Ok" : "Err");
        System.out.println(arbol2.insertar(20, 87, 'I') ? "Ok" : "Er");
        System.out.println(arbol2.toString());
        
        System.out.println("\n--------Metodo alterar parte------");
        System.out.println("Pp = 63, Hi = 50, Hd = 96");
        arbol2.alterarParte(50, 96, 63);
        System.out.println("El arbol resultante es: " +arbol2.toString());

    }
}
