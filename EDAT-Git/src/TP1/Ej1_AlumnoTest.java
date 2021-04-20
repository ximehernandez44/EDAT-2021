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
public class Ej1_AlumnoTest {
    public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);

        Alumno[] listaAlumnos = new Alumno[30];
        String cadena;
        int cant, pos, opc;
        boolean valido;
        
        cant = prodCargados(listaAlumnos);
        
        do {
        System.out.println("Actualmente hay " +cant+ " alumnos cargados. \nIngrese el numero de alumno que desea ver/modificar");
        pos = leer.nextInt();
        pos = pos - 1;
        
        System.out.println("Ha seleccionado el alumno " +(pos + 1));
        System.out.println(listaAlumnos[pos].toString());
        
        menu();
        opc = leer.nextInt();
        leer.nextLine();
        
        switch(opc) {
            case 1: System.out.println("CAMBIO DE NOMBRE");
                System.out.println("Ingrese el nuevo nombre y apellido");
                cadena = leer.nextLine();
                listaAlumnos[pos].setNombre(cadena);
                break;
            case 2: System.out.println("CAMBIO DE DIRECCION");
                System.out.println("Indique si desea modificar la Calle (1), el Numero (2) o ambos (3)");
                opc = leer.nextInt();
                leer.nextLine();
                switch (opc) {
                    case 1: System.out.println("Ingrese la nueva calle");
                            cadena = leer.nextLine();
                            listaAlumnos[pos].setCalle(cadena);
                            break;
                    case 2: System.out.println("Ingrese el nuevo numero");
                            opc = leer.nextInt();
                            listaAlumnos[pos].setNumero(opc);
                            break;
                    case 3: System.out.println("Ingrese la nueva calle");
                            cadena = leer.nextLine();
                            listaAlumnos[pos].setCalle(cadena);
                            
                            System.out.println("Ingrese el nuevo numero");
                            opc = leer.nextInt();
                            listaAlumnos[pos].setNumero(opc);
                            break;
                }
                break;
            case 3: System.out.println("CAMBIO DE CIUDAD");
                cadena = leer.next();
                listaAlumnos[pos].setCiudad(cadena);
                break;
            case 4: System.out.println("CAMBIO DE TELEFONO");
                opc = leer.nextInt();
                listaAlumnos[pos].setTelefono(opc);
                break;
            case 5: System.out.println("CAMBIO DE CLAVE");
            do {
                System.out.println("Ingrese la clave vieja");
                cadena = leer.next();
                valido = listaAlumnos[pos].verificaClave(cadena);
                if (valido) {
                    System.out.println("Ingrese la nueva clave");
                    cadena = leer.next();
                    listaAlumnos[pos].setClave(valido, cadena);
                } else {
                    System.out.println("Clave ingresada incorrecta");
                }
            } while (!valido); 
        }
        
        } while (opc != 6);
    }
    
        public static int prodCargados(Alumno[] lista) {
        //Carga 4 alumnos en el arreglo. Retorna el 5

        lista[0] = new Alumno("FAI-2915", "Ximena Hernandez", "DNI", 40825394, "España", 555, "Catriel", 156065357, "40825394");
        lista[1] = new Alumno("FACA-302", "Enzo Saavedra", "DNI", 41978846, "Batilana", 444, "Nequen", 155125770, "Rammstein");
        lista[2] = new Alumno("FAIN-6067", "Ailen Hernandez", "DNI", 40825394, "Leloir", 231, "Nequen", 156065357, "155350545");
        lista[3] = new Alumno("1111", "Sujeto Prueba", "DU", 44000111, "Av Argentina", 01, "Nequen", 4912339, "hola123");
       
        return 4;
        }
        
        public static void menu() {
            System.out.println("Seleccione una opción:");
            System.out.println("1- Cambiar nombre");
            System.out.println("2- Cambiar direccion");
            System.out.println("3- Cambiar ciudad");
            System.out.println("4- Cambiar telefono");
            System.out.println("5- Cambiar clave de SIU");
            System.out.println("6- Salir");
        }
                
}
