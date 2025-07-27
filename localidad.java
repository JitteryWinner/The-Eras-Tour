public class localidad {
    private String nombre;
    private double precio;
    private int capacidad;
    private int vendidos;

    public localidad(String nombre, double precio, int capacidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidad = capacidad;
        this.vendidos = 0;
    }

    public boolean puedeVender(int cantidad) {
        return (vendidos + cantidad) <= capacidad;
    }

    public int vender(int cantidad) {
        int disponibles = capacidad - vendidos;
        int vendidosAhora = Math.min(cantidad, disponibles);
        vendidos += vendidosAhora;
        return vendidosAhora;
    }

    public int getDisponibilidad() {
        return capacidad - vendidos;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVendidos() {
        return vendidos;
    }
}
