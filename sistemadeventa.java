import java.util.ArrayList;
import java.util.Random;

public class sistemadeventa {
    private ArrayList<localidad> localidades;
    private comprador compradorActivo;

    public sistemadeventa() {
        localidades = new ArrayList<>();
        localidades.add(new localidad("Localidad 1", 100.0, 20));
        localidades.add(new localidad("Localidad 5", 500.0, 20));
        localidades.add(new localidad("Localidad 10", 1000.0, 20));
    }

    public void nuevoComprador(String nombre, String email, int cantidad, double presupuesto) {
        compradorActivo = new comprador(nombre, email, cantidad, presupuesto);
        System.out.println("Nuevo comprador registrado: " + compradorActivo.getNombre());
    }

    public void solicitudBoletos() {
        if (compradorActivo == null) {
            System.out.println("Primero debes registrar un comprador");
            return;
        }

        ticket ticket = new ticket();
        ticket.validarAptitud();

        if (!ticket.isApto()) {
            System.out.println("El ticket "+ ticket.getNumero() + " no fue apto para comprar.");
            return;
        }

        Random random = new Random();
        localidad localidad = localidades.get(random.nextInt(localidades.size()));

        if (compradorActivo.getPresupuesto() < localidad.getPrecio()) {
            System.out.println("El presupuesto no alcanza para la localidad " + localidad.getNombre());
            return;
        }

        int vendidos = localidad.vender(compradorActivo.getCantidad());
        if (vendidos > 0) {
            System.out.println("Se vendieron "+ vendidos +" boletos en "+ localidad.getNombre());
        } else {
            System.out.println("No hay espacio en la localidad seleccionada");
        }
    }

    public void consultarDisponibilidad() {
        for (localidad loc : localidades) {
            System.out.println(loc.getNombre() + "Disponibles: " + loc.getDisponibilidad() + " - Vendidos: " + loc.getVendidos());
        }
    }

    public void consultarDisponibleIndividual(String nombreLocalidad) {
        for (localidad loc : localidades) {
            if (loc.getNombre().equalsIgnoreCase(nombreLocalidad)) {
                System.out.println(loc.getNombre() + "Disponibles: " + loc.getDisponibilidad());
                return;
            }
        }
        System.out.println("La Localidad no fue encontrada");
    }

    public double reporteCaja() {
        double total = 0;
        for (localidad loc : localidades) {
            total += loc.getVendidos() * loc.getPrecio();
        }
        System.out.println("Reporte de caja: $" + total);
        return total;
    }
}
