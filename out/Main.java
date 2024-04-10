import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        verMenu();
    }

    public static void verMenu() {
        Scanner sc = new Scanner(System.in);
        Inventario objInventario = new Inventario();
        int menu = 0;
        boolean valida = false;
        do {
            System.out.println("Bienvenida Patricia");
            System.out.println("Que desea realizar?");
            System.out.println("1) Ingresar nuevos productos  2) Modificar productos  3) Eliminar productos 4)Realizar pago  5)Realizar apartado  6) Imprimir registro 7) Ver inventario  8) Salir ");
            while (valida == false) {
                try {
                    menu = sc.nextInt();
                    valida = true;
                } catch (InputMismatchException e) {
                    System.err.println("Intentelo de nuevo");
                    sc.nextLine();
                }
            }
            valida = false;
            switch (menu) {
                case 1:
                    objInventario.IngresarProductos();
                    break;

                case 2:
                    objInventario.modificarListaProductos();
                    break;

                case 3:
                    objInventario.eliminarProductos();
                    break;

                case 4:
                    carritoDeCompras.agregarProducto();
                    break;

                case 7:
                    objInventario.imprimirListaProducto();
                    break;

                default:
                    break;
            }
        } while (menu != 8);
    }
}
