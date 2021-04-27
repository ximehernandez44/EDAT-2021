/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.Lista;
/**
 *
 * @author ximeh
 */
public class TestLista {
    public static void main (String [] args) {
        Lista lista = new Lista();
        Lista clon = new Lista();
        Object[] arr = {1,2,3,4,5 ,6};
        
        System.out.println("//////////////////////// INT ///////////////////////////////");
        System.out.println("\nPongo 3, 5, 7");
        lista.insertar(3, 1);
        lista.insertar(5, 2);
        lista.insertar(7, 3);
        System.out.println("\n------------------- Muestra en String --------------------");
        System.out.println(lista.toString());
        System.out.println("\nRecupera el elemento en la pos 2, debe decir 5:       " +lista.recuperar(2));
        System.out.println("Recupera el elemento en la pos 1, debe decir 3:       " +lista.recuperar(1));
        System.out.println("Busca el elemento 7, debe decir 3:                    " +lista.localizar(7));
        System.out.println("\nLa longitud es: " +lista.longitud());
        
        /*System.out.println("\n ------------------ La muestro invertida -----------------");
        lista.invertir();
        System.out.println(lista.toString());*/
        
        System.out.println("\n--------------------- Saco el elem en la pos 2 (5) ------------------------");
        lista.eliminar(2);
        System.out.println("\nEsta vacía? " +lista.esVacia());
        System.out.println("\nMuestra el String: " +lista.toString());
        System.out.println("\nLa longitud es: " +lista.longitud());
        
        System.out.println("\n-------------------- Agrego un 2 en la primera pos ------------------------");
        lista.insertar(2,1);
        System.out.println("\nMuestro el String: " +lista.toString());
        System.out.println("Quito el 2");
        lista.eliminar(1);
        System.out.println("Muestro el String: " +lista.toString());
        
        System.out.println("\n---------------- Clono y muestro clon ------------------");
        clon = lista.clone();
        System.out.println(clon.toString());
        
        System.out.println("\n--------------- Vacío la original y muestro -------------");
        lista.vaciar();
        System.out.println("Esta vacía? " + lista.esVacia());
        
        System.out.println("\n--------------- Intento quitar de la vacía ---------------");
        System.out.println("Se pudo sacar el objeto en la 1? " +lista.eliminar(2));
        System.out.println("La longitud es: " +lista.longitud());
        System.out.println("La lista resultante es: " +lista.toString());
        
        System.out.println("\n------------------ Muestro el clon -----------------------");
        System.out.println(clon.toString());
        /*clon.invertir();
        System.out.println("Lo muestro invertido: " + clon.toString());*/
        
        System.out.println("\n-----------------Le pongo 3, 7---------------------------");
        clon.insertar(3, 3);
        clon.insertar(7, 4);
        System.out.println(clon.toString());
        
        /*System.out.println("\n---------------Elimino los 3------------------------------");
        clon.eliminarApariciones(3);
        System.out.println(clon.toString());*/
     
        System.out.println("\n-------------Muestro multiplos de 1 del clon--------------------");
        System.out.println(clon.obtenerMultiplos(1).toString());
        
        System.out.println("\n-----Inserto [1,2,3,4,5,6] en el original-----------");
        lista.preCargar(arr);
        System.out.println(lista.toString());
        
        System.out.println("\n---------Muestro multiplos de 2 del original----------");
        System.out.println(lista.obtenerMultiplos(3).toString());
     
        System.out.println("\n---------Muestro el clon----------------");
        System.out.println(clon.toString());
        
        System.out.println("\n-------Inserto otro [3,7]------------------");
        clon.insertar(3, 3);
        clon.insertar(7, 4);
        System.out.println(clon.toString());
        
        System.out.println("\n-------------Elimino los 3----------------");
        clon.eliminarApariciones(3);
        System.out.println(clon.toString());
        
    }
}
