/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.conjuntistas;
import conjuntistas.ArbolHeap;

/**
 *
 * @author Xime Hernandez
 */
public class TestArbolHeap {
    static String sOk = "\u001B[32m OK! \u001B[0m", sErr = " \u001B[31m ERROR \u001B[0m";
    
    public static void main(String[] args) {
        ArbolHeap a = new ArbolHeap();
        ArbolHeap b = new ArbolHeap();
        
        System.out.println("********************************");
        System.out.println("*      Insercion basica        *");
        System.out.println("********************************");
        System.out.println("Checkeo si es vacio " + ((a.esVacio()) ? sOk : sErr));
        System.out.println("Intento vaciar arbol vacio ");
        a.vaciar();
        System.out.println("Inserto el 10" + ((a.insertar(10)) ? sOk : sErr));
         System.out.println("\n toString()  deberia dar:\n"
                + "\n        10"
                + "\n");
        System.out.println(a.toString());
        System.out.println("");
        System.out.println("Inserto el 9 " + ((a.insertar(9)) ? sOk : sErr));
        System.out.println("Inserto el 7 " + ((a.insertar(7)) ? sOk : sErr));
        System.out.println("Inserto el 3 " + ((a.insertar(3)) ? sOk : sErr));
        System.out.println("Inserto el 15" + ((a.insertar(15)) ? sOk : sErr));
        System.out.println("Inserto el 12" + ((a.insertar(12)) ? sOk : sErr));
        System.out.println("Inserto el 20" + ((a.insertar(20)) ? sOk : sErr));
        System.out.println("\n toString() deberia dar:\n"
                + "[3, 7, 9, 10, 15, 12, 20\n");
        System.out.println(a.toString());
        
        System.out.println("*********************************");
        System.out.println("*            Cima               *");
        System.out.println("*********************************");
        
        System.out.println("Checkeo si es vacio. Tiene que dar " + sErr + " --> " + ((a.esVacio()) ? sOk : sErr));
        System.out.println("Recuperar cima, deberia dar 3: " + a.recuperarCima());
        System.out.println("Eliminar cima, deberia dar " + sOk + " --> " + ((a.eliminarCima()) ? sOk : sErr));
        System.out.println("toString: " +a.toString());
        System.out.println("Vuelvo a insertar 3 " + ((a.insertar(3)) ? sOk : sErr));
        System.out.println("toString: " +a.toString());
        
        System.out.println("********************************");
        System.out.println("*         Test de clon         *");
        System.out.println("********************************");
        b = a.clone();
        System.out.println("Es vacio? Deberia dar " + sErr + " --> " + ((b.esVacio()) ? sOk : sErr));
        System.out.println("");
        System.out.println("\n toString() deberia dar:\n"
                + "[3, 7, 9, 10, 12, 15, 20\n");
        System.out.println(b.toString());
        System.out.println("Inserto el 25 en CLON" + ((b.insertar(25)) ? sOk : sErr));
        System.out.println("Inserto el 27 en CLON" + ((b.insertar(27)) ? sOk : sErr));
        System.out.println("Inserto el 35 en CLON" + ((b.insertar(35)) ? sOk : sErr));
        System.out.println("Clon toString deberia dar:\n"
                + "[3, 7, 9, 10, 12, 15, 20, 25, 27, 35]\n");
        System.out.println("\n CLON toString() \t\t\n" + b.toString() + "\n\n");
        System.out.println("ORIGINAL toString()\t\t\n " + a.toString() + "\n\n");
        System.out.println("Recuperar cima del clon, deberia dar 3: " + b.recuperarCima());
        System.out.println("Vacio el CLON");
        b.vaciar();
        System.out.println("Es vacio? Deberia dar " + sOk + " --> " + ((b.esVacio()) ? sOk : sErr));
    }
    
}
