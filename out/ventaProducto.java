import java.util.ArrayList;
import java.util.Scanner;
public class ventaProducto {
    protected float cuentaTotal;
    protected float pago;
    protected ArrayList<Productos> listaProductos;

    public ventaProducto(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ventaProducto() {

    }

    protected void realizarPago() {
        Scanner scanner = new Scanner(System.in);
        for (Productos producto : listaProductos) {
            cuentaTotal += producto.getcostoProducto() * producto.getCantidadProducto();
        }

        if (cuentaTotal >= 1000) {
            ventaConDescuento descuento = new ventaConDescuento(listaProductos, cuentaTotal);
            descuento.realizarPago();
        } else if (cuentaTotal >= 800) {
            ventaConPromocion promocion = new ventaConPromocion(listaProductos, cuentaTotal);
            promocion.realizarPago();
        } else {
            System.out.println("Costo total de la compra: " + cuentaTotal);
            System.out.println("Ingrese su efectivo:");
            pago = scanner.nextFloat();
            while (pago < cuentaTotal) {
                System.out.println("Ingrese un pago válido, el pago debe cubrir el costo total");
                pago = scanner.nextFloat();
            }
            float cambio = pago - cuentaTotal;
            System.out.println("La compra fue realizada con éxito. Su cambio es de: " + cambio);
        }
        registroVenta objRegistroVenta = new registroVenta(listaProductos);
        objRegistroVenta.imprimirRegistroDelDia();
    }
}