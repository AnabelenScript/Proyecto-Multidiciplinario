import java.util.ArrayList;

public class registroVenta {
    private ArrayList<Productos> listaProductos;
    private Cliente objCliente;

    public registroVenta(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void imprimirRegistroDelDia() {
        System.out.println("Registro del día:");
        for (Productos producto : listaProductos) {
            System.out.println("Nombre: " + producto.getNombreProducto());
            System.out.println("Costo: " + producto.getCostoProducto());
            System.out.println("Cantidad: " + producto.getCantidadProducto());
            System.out.println("----------------------");
        }
    }
}
