/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import java.util.Scanner;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
/**
 *
 * @author ximeh
 */
public class PruebaLista {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc;
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        
        System.out.println("Elija una opcion:");
        menu();
        opc = sc.nextInt();
        
        switch (opc) {
            case 1: 
                l1.insertar(2, 1);
                l1.insertar(4,2);
                l1.insertar(6,3);
                
                l2.insertar(5,1);
                l2.insertar(1,2);
                l2.insertar(6,3);
                l2.insertar(7,4);
                
                System.out.println("Las listas a concatenar son " +l1.toString()+ " y " +l2.toString());
                System.out.println(concatenar(l1,l2).toString());
                break;
        
            case 2: //9,6,5,0,9,6,5,0,5,6,9
                l1.insertar(9,1);
                l1.insertar(6,2);
                l1.insertar(5,3);
                l1.insertar(0,4);
                l1.insertar(9,5);
                l1.insertar(6,6);
                l1.insertar(5,7);
                l1.insertar(0,8);
                l1.insertar(5,9);
                l1.insertar(6,10);
                l1.insertar(9,11);
                
                System.out.println("La lista a comprobar es " +l1.toString());
                System.out.println("Cumple con la condicion?" +comprobar(l1));
                break;
                
            case 3: //[2,4,6]
                l1.insertar(2,1);
                l1.insertar(4,2);
                l1.insertar(6,3);
                
                System.out.println("La lista a invertir es " +l1.toString());
                System.out.println("La lista invertida es: " +invertir(l1));
                break;
                
            default: System.out.println("Opcion incorrecta");
        }
    }
    
    public static void menu() {
        System.out.println("1- Concatenar: Recibe dos listas y devuelve una con las dos listas concatenadas");
        System.out.println("2- Comprobar: Recibe una lista y verifica si tiene la forma cadena0cadena0cadena'");
        System.out.println("3- Invertir: Recibe una lista y la devuelve invertida");
    }
    
    public static Lista concatenar(Lista l1, Lista l2) {
        //recibe dos listas L1 y L2 y devuelve una lista nueva con los elementos de L1 y L2 concatenados
        Lista nueva = l1.clone();
        int aux1 = l1.longitud();
        int aux2 = l2.longitud();
        
        for (int i = 1; i <= aux2; i++) {
            nueva.insertar(l2.recuperar(i), aux1 + i);
        }
        
        return nueva;
    }
    
    public static boolean comprobar(Lista l1) {
        /*comprobar : recibe una lista L1 cargada con dígitos enteros (de 0 a 9) y verica si los elementos
que contiene tienen la forma cadena0cadena0cadena' (donde cadena' es cadena invertida).*/

        Cola cola = new Cola();
        Pila pila = new Pila();
        int i = 1;
        boolean t = true;
        boolean exito = true;
        
        while ((int) l1.recuperar(i) != 0) {
            cola.poner(l1.recuperar(i));
            pila.apilar(l1.recuperar(i));
            i++;
        }
        i++;
        
        while ((int) l1.recuperar(i) != 0 && !cola.esVacia() && exito){
            exito = (l1.recuperar(i) == cola.obtenerFrente()) && (!cola.esVacia());
            cola.sacar();
            i++;
        }
                
        i++;
        
        while ((l1.recuperar(i) != null) && !pila.esVacia() && exito) {
            exito = (l1.recuperar(i) == pila.obtenerTope()) && (!pila.esVacia());
            pila.desapilar();
            i++;
        }
        
        return exito;
    }
    
    public static Lista invertir(Lista l1) {
        Lista nueva = new Lista();
        Pila aux = new Pila();
        int i, longitud = l1.longitud();
        
        for (i = 1; i <= longitud; i++) {
            aux.apilar(l1.recuperar(i));
        }
        
        for (i = 1; i <= longitud; i++) {
            nueva.insertar(aux.obtenerTope(), i);
            aux.desapilar();
        }
        
        return nueva;
    }
    
}
