public class Cliente {
    private String nombreCliente;
    private int numTelefono;

    public Cliente(String nombreCliente, int numTelefono) {
        this.nombreCliente = nombreCliente;
        this.numTelefono = numTelefono;
    }

    public Cliente() {

    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }
    public int getNumTelefono() {
        return numTelefono;
    }
}
