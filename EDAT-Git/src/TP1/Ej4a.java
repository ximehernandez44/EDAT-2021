/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;
import java.util.Scanner;
/**
 *
 * @author ximeh
 */
public class Ej4a {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String cadena;
        char letra;
        int pos, opc;
        
        System.out.println("Ingrese la cadena");
        cadena = sc.nextLine();
        System.out.println("Ingrese la letra");
        letra = sc.nextLine().charAt(0);
        System.out.println("1- Primera, 2- Ultima, 3- Inversa");
        opc = sc.nextInt();
        
        switch (opc) {
            case 1: 
                pos = primera(cadena, letra, 0);
                System.out.println("La primera posicion en la que aparece la letra es " +pos);
                break;
            case 2:
                pos = ultima(cadena, letra, 0);
                System.out.println("La ultima posicion en la que aparece la letra es " +pos);
                break;
            case 3:
                cadena = invertir(cadena, 0);
                System.out.println("La cadena junto a su invertida es " +cadena);
        }
        
    }
    
    public static int primera(String cadena, char letra, int pos) {
        //Devuelve la primera posición en la que aparece una letra dada
        int salida = -1;
        
        if (pos == cadena.length()) {
            if (letra == cadena.charAt(pos))
                salida = pos;
            
        } else {
            if (letra == cadena.charAt(pos)) {
                salida = pos;
            } else {
                salida = primera(cadena, letra, pos + 1);
            }
        }
        
        return salida;
    }
    
    public static int ultima(String cadena, char letra, int pos) {
        //Devuelve la última posición en la que aparece una letra dada.
        int salida = -1;
        
        if (pos == cadena.length() - 1) {
            if (letra == cadena.charAt(pos))
                    salida = pos;        
        } else {
            salida = ultima(cadena, letra, pos+1);
            if (letra == cadena.charAt(pos) && pos > salida) {
                salida = pos;
            }
        }
        
        return salida;
    }
    
    public static String invertir(String cadena, int pos) {
        //Devuelve un String que es la cadena de caracteres original seguida de su inversa.
        String cadInv = cadena;
        
        if (pos == cadena.length() - 1) {
            cadInv = cadInv + cadena.charAt(pos);
        } else {
            cadInv = invertir(cadena, pos+1);
            cadInv = cadInv + cadena.charAt(pos);
        }
        return cadInv;
    }
}
