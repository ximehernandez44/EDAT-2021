/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;
/**
 *
 * @author ximeh
 */
public class Ej6 {
    public static void main(String[] args) {
        /* Dado un arreglo de números enteros, implementar un método recursivo que en un único recorrido imprima
        los elementos menores que el promedio de todos los números cargados. Por ejemplo: dado el arreglo
        [10,5,3,7,11,1] el promedio es (10+5+3+7+11+1)/6=37/6=6.166, luego debe imprimir 1, 3, 5

        (*) Pista: calcular el promedio a la ida de la recursión e imprimir los elementos menores a la vuelta
        
        Alto lvl:
        *El metodo los va a ir imprimiendo, no retorna nada: void
        *Hacer un arreglo precargado
        *Entrar a metodo, variables: suma, prom, pos
        *sumar todos los numeros a la ida hasta pos = arr.length-1, en el caso base dividir por arr.length y asignar a prom
        *comparar cada numero con el promedio a la vuelta, y si arr[pos] < prom, imprime por pantalla
        
        */
        
        int[] arr = {10, 5, 3, 7, 11, 1};
        imprimeMenor(arr, 0, 0);        
    }
    
    public static int imprimeMenor(int[] arr, int suma, int pos) {
        int prom;
        
        if (pos == arr.length - 1) {
            suma += arr[pos];
            prom = suma/arr.length;
            if (arr[pos] <= prom) 
                System.out.println(arr[pos]);
        } else {
            suma += arr[pos];
            prom = imprimeMenor(arr, suma, pos+1);
            
            if (arr[pos] <= prom) 
                System.out.println(arr[pos]);
            
        }
        return prom;
    }
}
