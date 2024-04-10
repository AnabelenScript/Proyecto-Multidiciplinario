import java.util.ArrayList;
import java.util.Scanner;

public class carritoDeCompras {
    static Inventario objInventario = new Inventario();
    private static ArrayList<Productos> listaProductos = objInventario.getListaProductos();

    private static ArrayList<Productos> listaCarrito = new ArrayList<>();

    public static void agregarProducto() {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {
            System.out.println("Ingrese el nombre del producto:");
            String nombreProducto = scanner.next();

            System.out.println("Ingrese el costo del producto:");
            float costoProducto = scanner.nextFloat();
            scanner.nextLine(); // Limpiar el buffer

            System.out.println("Ingrese la marca del producto:");
            String marcaProducto = scanner.next();

            System.out.println("Ingrese la descripción del producto:");
            String descripcionProducto = scanner.next();

            System.out.println("Ingrese la cantidad del producto:");
            int cantidadProducto = scanner.nextInt();

            Productos producto = new Productos(nombreProducto, costoProducto, marcaProducto, descripcionProducto, cantidadProducto);
            listaCarrito.add(producto);

            System.out.println("¿Desea agregar otro producto? (S/N)");
            respuesta = scanner.next();
        } while (respuesta.equalsIgnoreCase("S"));

        System.out.println("Productos en el carrito:");
        for (Productos producto : listaCarrito) {
            System.out.println("Nombre: "+producto.getnombreProducto()+ " Cantidad: "+producto.getCantidadProducto());
        }
        System.out.println("¿Desea eliminar algún producto del carrito? (S/N)");
        respuesta = scanner.next();
        if (respuesta.equalsIgnoreCase("S")) {
            modificarProducto();
        }
        else{
            ventaProducto venta = new ventaProducto(listaCarrito);
            venta.realizarPago();
        }
    }

    public static void modificarProducto() {
        Scanner scanner = new Scanner(System.in);
        boolean productoEliminado = false;

        while (!productoEliminado) {
            System.out.println("Seleccione el número del producto que desea eliminar:");
            int numeroProducto = scanner.nextInt();
            scanner.nextLine();
            if (numeroProducto >= 1 && numeroProducto <= listaCarrito.size()) {
                listaCarrito.remove(numeroProducto - 1);
                System.out.println("Producto eliminado exitosamente del carrito.");
                productoEliminado = true;
                ventaProducto venta = new ventaProducto(listaCarrito);
                venta.realizarPago();
            } else {
                System.out.println("Número de producto no válido. Por favor, seleccione un número válido.");
            }
        }
    }
}
