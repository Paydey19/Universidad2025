/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.universidad2025;

/**
 *
 * @author flore
 */
import java.util.Scanner;

public class Universidad2025 {
    private String rector;
    private String nombre;
    private String direccion;
    private String[] estudiantes;
    private int cantidadEstudiantes;
    private final int CAPACIDAD_MAXIMA = 500;

    public Universidad2025(String rector, String nombre, String direccion) {
        this.rector = rector;
        this.nombre = nombre;
        this.direccion = direccion;
        this.estudiantes = new String[CAPACIDAD_MAXIMA];
        this.cantidadEstudiantes = 0;
    }

    public boolean agregarEstudiante(String nombreEstudiante) {
        if (nombreEstudiante == null || nombreEstudiante.trim().isEmpty()) {
            System.out.println("Nombre inválido.");
            return false;
        }
        if (cantidadEstudiantes < CAPACIDAD_MAXIMA) {
            estudiantes[cantidadEstudiantes] = nombreEstudiante;
            cantidadEstudiantes++;
            System.out.println("Estudiante agregado: " + nombreEstudiante);
            return true;
        } else {
            System.out.println("Universidad llena.");
            return false;
        }
    }

    public boolean eliminarEstudiante(String nombreEstudiante) {
        if (nombreEstudiante == null || nombreEstudiante.trim().isEmpty()) {
            System.out.println("Nombre inválido.");
            return false;
        }
        for (int i = 0; i < cantidadEstudiantes; i++) {
            if (estudiantes[i].equalsIgnoreCase(nombreEstudiante)) {
                // para eliminar rápido: sustituir por el último y decrementar
                estudiantes[i] = estudiantes[cantidadEstudiantes - 1];
                estudiantes[cantidadEstudiantes - 1] = null;
                cantidadEstudiantes--;
                System.out.println("Estudiante eliminado: " + nombreEstudiante);
                return true;
            }
        }
        System.out.println("Estudiante no encontrado: " + nombreEstudiante);
        return false;
    }

    public String consultarEstudiante(int indice) {
        if (indice >= 0 && indice < cantidadEstudiantes) {
            return estudiantes[indice];
        }
        return "Índice inválido";
    }

    public void mostrarEstudiantes() {
        System.out.println("----- Estudiantes (" + cantidadEstudiantes + ") -----");
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println((i + 1) + ". " + estudiantes[i]);
        }
    }

    public void mostrarInfo() {
        System.out.println("Universidad: " + nombre);
        System.out.println("Rector: " + rector);
        System.out.println("Dirección: " + direccion);
        System.out.println("Capacidad: " + cantidadEstudiantes + " / " + CAPACIDAD_MAXIMA);
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public String getRector() {
        return rector;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese nombre del rector: ");
        String rector = sc.nextLine();

        System.out.print("Ingrese nombre de la universidad: ");
        String nombreUni = sc.nextLine();

        System.out.print("Ingrese dirección: ");
        String direccion = sc.nextLine();

        Universidad2025 miUni = new Universidad2025(rector, nombreUni, direccion);

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\nMENU:");
            System.out.println("1. Mostrar info");
            System.out.println("2. Agregar estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Consultar estudiante por índice");
            System.out.println("5. Mostrar estudiantes");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            if (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Ingrese un número válido.");
                continue;
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    miUni.mostrarInfo();
                    break;
                case 2:
                    System.out.print("Nombre estudiante a agregar: ");
                    String nuevo = sc.nextLine();
                    miUni.agregarEstudiante(nuevo);
                    break;
                case 3:
                    System.out.print("Nombre estudiante a eliminar: ");
                    String elim = sc.nextLine();
                    miUni.eliminarEstudiante(elim);
                    break;
                case 4:
                    System.out.print("Índice (0 a " + (miUni.getCantidadEstudiantes() - 1) + "): ");
                    if (sc.hasNextInt()) {
                        int idx = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Resultado: " + miUni.consultarEstudiante(idx));
                    } else {
                        sc.nextLine();
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 5:
                    miUni.mostrarEstudiantes();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}

    

