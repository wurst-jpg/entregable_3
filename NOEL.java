import java.util.Scanner;

public class NOEL {

    public static void listarProductos(String[] array) {
        System.out.println("--- Productos Disponibles ---");
        for (String producto : array) {
            if (producto != null) {
                System.out.println("- " + producto);
            }
        }
    }

    public static boolean buscarProducto(String[] array, String nombreBuscado) {
        for (String producto : array) {
            if (producto != null && producto.equals(nombreBuscado)) {
                return true;
            }
        }
        return false;
    }

    public static boolean agregarProducto(String[] array, String nuevo) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = nuevo;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String[] productos = new String[5];
        productos[0] = "Ducales";
        productos[1] = "Festival";
        productos[2] = "Tosh";
        boolean salir = false;

        do {
            System.out.println("╔══════════════════════════════════════════╗\n" + //
                                "║    ███╗   ██╗ ██████╗ ███████╗ ██       ║\n" + //
                                "║    ████╗  ██║██╔═══██╗██╔════╝ ██       ║\n" + //
                                "║    ██╔██╗ ██║██║   ██║█████╗   ██       ║\n" + //
                                "║    ██║╚██╗██║██║   ██║██╔══╝   ██       ║\n" + //
                                "║    ██║ ╚████║╚██████╔╝███████╗ ███████╗ ║\n" + //
                                "║    ╚═╝  ╚═══╝ ╚═════╝ ╚══════╝ ╚══════╝ ║\n" + //
                                "║   ────────────────────────────────────   ║\n" + //
                                "║   1. Listar Productos                    ║\n" + //
                                "║   2. Buscar Producto                     ║\n" + //
                                "║   3. Agregar Producto                    ║\n" + //
                                "║   4. Salir                               ║\n" + //
                                "║   ────────────────────────────────────   ║\n" + //
                                "╚══════════════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            String opcion = leer.nextLine();

            switch (opcion) {
                case "1":
                    listarProductos(productos);
                    break;

                case "2":
                    System.out.println("Productos disponibles para buscar:");
                    listarProductos(productos);
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String buscar = leer.nextLine();
                    if (buscarProducto(productos, buscar)) {
                        System.out.println("El producto \"" + buscar + "\" existe.");
                    } else {
                        System.out.println("El producto \"" + buscar + "\" no existe.");
                    }
                    break;

                case "3":
                    System.out.print("Ingrese el nombre del nuevo producto: ");
                    String nuevo = leer.nextLine();
                    if (agregarProducto(productos, nuevo)) {
                        System.out.println("Producto \"" + nuevo + "\" agregado.");
                    } else {
                        System.out.println("Inventario lleno, no se pudo agregar.");
                    }
                    break;

                case "4":
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción incorrecta, intente de nuevo.");
            }
        } while (!salir);

        leer.close();
    }
}