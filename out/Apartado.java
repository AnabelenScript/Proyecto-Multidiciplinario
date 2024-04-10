import java.util.Scanner;
import java.util.ArrayList;

public class Apartado {
    private ArrayList<Productos> listaProductos = new ArrayList<>();
    private float anticipo;
    private int fechaLimiteAnticipo;
    private float costoTotal;
    private Cliente objCliente;

    public Apartado() {
    }

    public void ingresarProductosApartados() {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {
            System.out.println("Ingrese el nombre del producto:");
            String nombreProducto = scanner.next();

            System.out.println("Ingrese el costo del producto:");
            float costoProducto = scanner.nextFloat();

            System.out.println("Ingrese la marca del producto:");
            String marcaProducto = scanner.next();

            System.out.println("Ingrese la descripción del producto:");
            String descripcionProducto = scanner.next();

            System.out.println("Ingrese la cantidad del producto:");
            int cantidadProducto = scanner.nextInt();

            Productos producto = new Productos(nombreProducto, costoProducto, marcaProducto, descripcionProducto, cantidadProducto);
            listaProductos.add(producto);

            System.out.println("¿Desea agregar más productos? (S/N)");
            respuesta = scanner.next();
        } while (respuesta.equalsIgnoreCase("S"));

        // Cuando se selecciona "N", llamar automáticamente a la función crearCuentaPendiente
        if (respuesta.equalsIgnoreCase("N")) {
            crearCuentaPendiente();
        }
    }

    public void crearCuentaPendiente() {
        Scanner scanner = new Scanner(System.in);
        costoTotal = 0;
        for (Productos producto : listaProductos) {
            costoTotal += producto.getcostoProducto() * producto.cantidadProducto();
        }
        System.out.println("El costo total es: " + costoTotal);
        float anticipoMinimo = 0.3f * costoTotal;
        System.out.println("Anticipo Mínimo(referente al costo total): " + anticipoMinimo);
        float anticipo;
        do {
            System.out.println("Ingrese el anticipo");
            anticipo = scanner.nextFloat();
            scanner.nextLine();
            if (anticipo < anticipoMinimo) {
                System.out.println("Ingrese un anticipo válido, el anticipo debe ser al menos el 30% del costo total");
            }
        } while (anticipo < anticipoMinimo);
        
        System.out.println("Ingrese la fecha límite del anticipo:");
        fechaLimiteAnticipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = scanner.next();
        this.objCliente.setNombreCliente(nombreCliente);
        

        System.out.println("Ingrese el número de teléfono del cliente:");
        int numTelefono = scanner.nextInt();
        this.objCliente.setNumTelefono(numTelefono);
        scanner.next();

        System.out.println("---- Informe de Cuenta Pendiente ----");
        System.out.println("Nombre del Cliente: " + nombreCliente);
        System.out.println("Número de Teléfono del Cliente: " + numTelefono);
        System.out.println("Anticipo: " + anticipo);
        System.out.println("Costo Total: " + costoTotal);
        System.out.println("Fecha Límite de Anticipo: " + fechaLimiteAnticipo);
        System.out.println("Productos:");
        for (Productos prod : listaProductos) {
            System.out.println("- Nombre: " + prod.getNombreProducto() + ", Cantidad: " + prod.getCantidadProducto());
        }
        System.out.println("-------------------------------------");

        System.out.println("¿Desea realizar otro apartado? (S/N)");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
            ingresarProductosApartados();
        }
        scanner.close();
    }
}
