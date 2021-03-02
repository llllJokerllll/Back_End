package com.plexus.sabaris;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static ClienteDAO c = new ClienteDAO();
    static VehiculoDAO v = new VehiculoDAO();
    static ReparacionesDAO r = new ReparacionesDAO();
    static int opcion;

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        int opcion = -1;
            System.out.println("Bienvenido a la APP Taller de Reparaciones Benito");
            System.out.println("==================================================");
            System.out.println("1. Gestionar los Clientes");
            System.out.println("2. Gestionar los Vehículos");
            System.out.println("3. Gestionar las Reparaciones");
            System.out.println("4. Informes");
            System.out.println("5. Salir");
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
                    menu4();
                    break;
                case 5:
                    System.out.println("Hasta otra, gracias por utilizar nuestros servicios");
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    menu();
                    break;
            }
        }


    private static void menu1() {
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
                    try {
                        System.out.println("Por favor, introduzca el DNI del cliente");
                        String dni = bf.readLine().toUpperCase();
                        System.out.println("For favor, introduzca el Nombre del cliente");
                        String nombre = bf.readLine();
                        System.out.println("Por favor, introduzca los Apellidos del cliente");
                        String apellidos = bf.readLine();
                        System.out.println("Por favor, introduzca la Edad del cliente");
                        String edad = bf.readLine();
                        c.insertar(new Cliente(dni, nombre, apellidos, Integer.parseInt(edad)));
                        System.out.println("Cliente añadido correctamente");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu1();
                    }
                    break;
                case 2:
                    menu1_1();
                    break;
                case 3:
                    try {
                        System.out.println("Por favor, introduzca el DNI del cliente a modificar");
                        String dni = bf.readLine().toUpperCase();
                        System.out.println("For favor, introduzca el nuevo Nombre del cliente");
                        String nombre = bf.readLine();
                        System.out.println("Por favor, introduzca los nuevos Apellidos del cliente");
                        String apellidos = bf.readLine();
                        System.out.println("Por favor, introduzca la nueva Edad del cliente");
                        String edad = bf.readLine();
                        c.modificar(new Cliente(dni, nombre, apellidos, Integer.parseInt(edad)));
                        System.out.println("Cliente modificado correctamente");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu1();
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Por favor, introduzca el DNI del cliente a eliminar");
                        String dni = bf.readLine().toUpperCase();
                        c.eliminar(dni);
                        System.out.println("Cliente eliminado correctamente");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu1();
                    }
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    menu1();
                    break;
            }
        }


    private static void menu1_1() {
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
                    try {
                        System.out.println("Por favor, introduzca el DNI del cliente a buscar");
                        String dni = bf.readLine().toUpperCase();
                        System.out.println(c.buscarDni(dni));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu1_1();
                    }
                    break;
                case 2:
                    try {
                        System.out.println("For favor, introduzca el Nombre del cliente a buscar");
                        String nombre = bf.readLine();
                        System.out.println("Por favor, introduzca los Apellidos del cliente a buscar");
                        String apellidos = bf.readLine();
                        c.buscarNomApe(nombre, apellidos).stream().forEach(e -> System.out.println(e));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu1_1();
                    }
                    break;
                case 3:
                    menu1();
                    break;
                case 4:
                    menu();
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    menu1_1();
                    break;
            }
        }


    private static void menu2() {
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
                    try {
                        System.out.println("Por favor, introduzca la Matricula del vehículo");
                        String matricula= bf.readLine().toUpperCase();
                        System.out.println("For favor, introduzca la Marca del vehículo");
                        String marca = bf.readLine();
                        System.out.println("Por favor, introduzca el Modelo del vehículo");
                        String modelo = bf.readLine();
                        System.out.println("Por favor, introduzca el Año del vehículo");
                        String ano = bf.readLine();
                        System.out.println("Por favor, introduzca el Color del vehículo");
                        String color = bf.readLine();
                        v.insertar(new Vehiculo(matricula, marca, modelo, Integer.parseInt(ano), color));
                        System.out.println("Vehículo añadido correctamente");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu2();
                    }
                    break;
                case 2:
                    menu2_1();
                    break;
                case 3:
                    try {
                        System.out.println("Por favor, introduzca la Matricula del vehículo a modificar");
                        String matricula= bf.readLine().toUpperCase();
                        System.out.println("For favor, introduzca la nueva Marca del vehículo");
                        String marca = bf.readLine();
                        System.out.println("Por favor, introduzca el nuevo Modelo del vehículo");
                        String modelo = bf.readLine();
                        System.out.println("Por favor, introduzca el nuevo Año del vehículo");
                        String ano = bf.readLine();
                        System.out.println("Por favor, introduzca el nuevo Color del vehículo");
                        String color = bf.readLine();
                        v.modificar(new Vehiculo(matricula, marca, modelo, Integer.parseInt(ano), color));
                        System.out.println("Vehículo modificado correctamente");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu2();
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Por favor, introduzca la Matricula del vehículo");
                        String matricula= bf.readLine().toUpperCase();
                        v.eliminar(matricula);
                        System.out.println("Vehiculo eliminado correctamente");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu2();
                    }
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    menu2();
                    break;
            }
        }


    private static void menu2_1() {
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
                    try {
                        System.out.println("Por favor, introduzca la Matricula del vehículo a buscar");
                        String matricula= bf.readLine().toUpperCase();
                        System.out.println(v.buscarMatricula(matricula));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu2_1();
                    }
                    break;
                case 2:
                    try {
                        System.out.println("For favor, introduzca la Marca del vehículo a buscar");
                        String marca = bf.readLine();
                        System.out.println("Por favor, introduzca el Modelo del vehículo a buscar");
                        String modelo = bf.readLine();
                        v.buscarMarMod(marca, modelo).stream().forEach(e -> System.out.println(e));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu2_1();
                    }
                    break;
                case 3:
                    try {
                        System.out.println("For favor, introduzca la Marca del vehículo a buscar");
                        String marca = bf.readLine();
                        System.out.println("Por favor, introduzca el Modelo del vehículo a buscar");
                        String modelo = bf.readLine();
                        System.out.println("Por favor, introduzca el Año del vehículo a buscar");
                        String ano = bf.readLine();
                        v.buscarMarModAno(marca, modelo, Integer.parseInt(ano)).stream().forEach(e -> System.out.println(e));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu2_1();
                    }
                    break;
                case 4:
                    menu2();
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    menu2_1();
                    break;
            }
        }

    private static void menu3() {
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
                    try {
                        System.out.println("Por favor, introduzca el DNI del cliente de la reparación");
                        String dni= bf.readLine().toUpperCase();
                        System.out.println("For favor, introduzca la Mátricula del vehículo de la reparación");
                        String matricula = bf.readLine();
                        System.out.println("Por favor, introduzca la Descripción de la reparación");
                        String descripcion = bf.readLine();
                        System.out.println("Por favor, introduzca el Tiempo de la reparación");
                        String tiempo = bf.readLine();
                        System.out.println("Por favor, introduzca el Total de la reparación");
                        String total = bf.readLine();
                        Date fecha = new Date();
                        r.insertar(new Reparacion(c.buscarDni(dni), v.buscarMatricula(matricula), descripcion, fecha, Double.parseDouble(tiempo), Double.parseDouble(total)));
                        System.out.println("Reparación añadida correctamente");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu3();
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Por favor, introduzca el ID de la reparación a modificar");
                        String id = bf.readLine().toUpperCase();
                        System.out.println("For favor, introduzca el nuevo DNI del cliente de la reparación");
                        String dni = bf.readLine();
                        System.out.println("For favor, introduzca la nueva Mátricula del vehículo de la reparación");
                        String matricula = bf.readLine();
                        System.out.println("Por favor, introduzca la nueva Descripción de la reparación");
                        String descripcion = bf.readLine();
                        System.out.println("Por favor, introduzca el nuevo Tiempo de la reparación");
                        String tiempo = bf.readLine();
                        System.out.println("Por favor, introduzca el nuevo Total de la reparación");
                        String total = bf.readLine();
                        Date fecha = new Date();
                        r.modificar(new Reparacion(c.buscarDni(dni), v.buscarMatricula(matricula), descripcion, fecha, Double.parseDouble(tiempo), Double.parseDouble(total)));
                        System.out.println("Reparación modificada correctamente");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu3();
                    }
                    break;
                case 3:
                    menu3_1();
                    break;
                case 4:
                    menu();
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    menu3();
                    break;
            }
        }

    private static void menu3_1() {
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
                    try {
                        System.out.println("For favor, introduzca el DNI del cliente a buscar en las reparaciones");
                        String dni = bf.readLine();
                        r.buscarCliente(dni).stream().forEach(e -> System.out.println(e));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu3_1();
                    }
                    break;
                case 2:
                    try {
                        System.out.println("For favor, introduzca la Matrícula del vehículo a buscar en las reparaciones");
                        String matricula = bf.readLine();
                        r.buscarVehiculo(matricula).stream().forEach(e -> System.out.println(e));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu3_1();
                    }
                    break;
                case 3:
                    try {
                        System.out.println("For favor, introduzca la Fecha a buscar (dd-MM-yyyy HH:mm:ss) en las reparaciones");
                        String fecha = bf.readLine();
                        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        Date fechaDate = null;
                        try {
                            fechaDate = formato.parse(fecha);
                        }
                        catch (ParseException ex)
                        {
                            System.out.println(ex);
                        }
                        r.buscarFecha(fechaDate).stream().forEach(e -> System.out.println(e));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        menu3_1();
                    }
                    break;
                case 4:
                    menu3();
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    menu3_1();
                    break;
            }
        }

    private static void menu4() {
        System.out.println("Informes");
        System.out.println("==================================================");
        System.out.println("1. Listas Clientes ordenados por Edad");
        System.out.println("2. 10 clientes con más reparaciones");
        System.out.println("3. Reparación más costosa");
        System.out.println("4. Reparación más barata");
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
                c.clientes.stream().sorted(Comparator.comparing(Cliente::getEdad)).forEach(System.out::println);
                menu4();
                break;
            case 2:
                Map<Cliente, Long> mapa = r.reparaciones.stream().collect(Collectors.groupingBy(Reparacion::getCliente, Collectors.counting()));
                Stream<Map.Entry<Cliente, Long>> reparaciones = mapa.entrySet().stream().sorted(Map.Entry.comparingByValue());
                reparaciones.forEach(System.out::println);
                menu4();
                break;
            case 3:
                System.out.println(r.reparaciones.stream().max(Comparator.comparing(Reparacion::getTotalReparacion)));
                menu4();
                break;
            case 4:
                System.out.println(r.reparaciones.stream().min(Comparator.comparing(Reparacion::getTotalReparacion)));
                menu4();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Opción seleccionada incorrecta");
                menu3_1();
                break;
        }
    }
}
