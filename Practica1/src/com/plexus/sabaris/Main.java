package com.plexus.sabaris;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        int opcion = -1;
        while(opcion != 4) {
            System.out.println("Bienvenido a la APP Taller de Reparaciones Benito");
            System.out.println("==================================================");
            System.out.println("1. Gestionar los Clientes");
            System.out.println("2. Gestionar los Vehículos");
            System.out.println("3. Gestionar las Reparaciones");
            System.out.println("4. Salir");
            System.out.print("Introduzca unha opción: ");

            try {
                opcion = Integer.parseInt(bf.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (opcion) {
                case 1:
                    menu1();
                    break;
                case 2:
                    menu2();
                    break;
                case 3:
                    menu3();
                    break;
                case 4:
                    System.out.println("Hasta otra, gracias por utilizar nuestros servicios");
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    break;
            }
        }
    }

    private static void menu1() {
        int opcion = -1;
        while(opcion != 5) {
            System.out.println("Gestionar los Clientes");
            System.out.println("==================================================");
            System.out.println("1. Insertar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Modificar Cliente");
            System.out.println("4. Borrar Cliente");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Introduzca unha opción: ");

            try {
                opcion = Integer.parseInt(bf.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (opcion) {
                case 1:

                    break;
                case 2:
                    menu1_1();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    break;
            }
        }
    }

    private static void menu1_1() {
        int opcion = -1;
        while(opcion != 3 && opcion != 4) {
            System.out.println("Buscar Cliente");
            System.out.println("==================================================");
            System.out.println("1. Por DNI");
            System.out.println("2. Por Nombre y Apellidos");
            System.out.println("3. Volver a Gestionar los Clientes");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Introduzca unha opción: ");

            try {
                opcion = Integer.parseInt(bf.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    menu1();
                    break;
                case 4:
                    menu();
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    break;
            }
        }
    }

    private static void menu2() {
        int opcion = -1;
        while(opcion != 5) {
            System.out.println("Gestionar los Vehículos");
            System.out.println("==================================================");
            System.out.println("1. Insertar Vehículo");
            System.out.println("2. Buscar Vehículo");
            System.out.println("3. Modificar Vehículo");
            System.out.println("4. Borrar Vehículo");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Introduzca unha opción: ");

            try {
                opcion = Integer.parseInt(bf.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (opcion) {
                case 1:
                    menu1();
                    break;
                case 2:
                    menu2_1();
                    break;
                case 3:
                    menu3();
                    break;
                case 4:
                    System.out.println("Hasta otra, gracias por utilizar nuestros servicios");
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    break;
            }
        }
    }

    private static void menu2_1() {
        int opcion = -1;
        while(opcion != 5 && opcion != 4) {
            System.out.println("Buscar Vehículo");
            System.out.println("==================================================");
            System.out.println("1. Por Matricula");
            System.out.println("2. Por Marca y Modelo");
            System.out.println("3. Por Marca, Modelo y Año");
            System.out.println("4. Volver a Gestionar los Vehículos");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Introduzca unha opción: ");

            try {
                opcion = Integer.parseInt(bf.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    menu2();
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    break;
            }
        }
    }

    private static void menu3() {
        int opcion = -1;
        while(opcion != 4) {
            System.out.println("Gestionar las Reparaciones");
            System.out.println("==================================================");
            System.out.println("1. Insertar Reparación");
            System.out.println("2. Modificar Reparación");
            System.out.println("3. Buscar Reparación");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Introduzca unha opción: ");

            try {
                opcion = Integer.parseInt(bf.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    menu3_1();
                    break;
                case 4:
                    menu();
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    break;
            }
        }
    }

    private static void menu3_1() {
        int opcion = -1;
        while(opcion != 4 && opcion != 5) {
            System.out.println("Buscar Reparación");
            System.out.println("==================================================");
            System.out.println("1. Por Cliente");
            System.out.println("2. Por Vehículo");
            System.out.println("3. Por Fecha");
            System.out.println("4. Volver a Gestionar las Reparaciones");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Introduzca unha opción: ");

            try {
                opcion = Integer.parseInt(bf.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    menu3();
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    break;
            }
        }
    }
}
