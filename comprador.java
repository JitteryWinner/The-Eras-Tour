public class comprador {
    private String nombre;
    private String email;
    private int cantidad;
    private double presupuesto;

    public comprador(String nombre, String email, int cantidad, double presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.cantidad = cantidad;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPresupuesto() {
        return presupuesto;
    }
}
