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
public class Ej8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, b;
        
        System.out.println("Ingrese el numero (n)");
        n = sc.nextInt();
        System.out.println("Ingrese la bomba (b)");
        b = sc.nextInt();
        
        explotar(n,b);
        
    }
    
    public static void explotar(int n, int b) {
        /**ingresan por parametro n y b, declaro n1 y n2 o los recibo?
         * si n menor a b, imprime n por pantalla (caso base)
         * sino, divide en n1 y n2, y llama de nuevo con c/ uno
         * se ejecutaria hasta que todos los numeros sean menores que b */
        int n1, n2;
        
        if (n <= b) {
            System.out.println(n);
        } else {
            n1 = n / b;
            n2 = n - (n/b);
            explotar(n1, b);
            explotar(n2,b);
        }
    } 
}
