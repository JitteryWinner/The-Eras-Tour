import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        sistemadeventa sistema = new sistemadeventa();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\nEliga una opcion");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");

            String input = scanner.nextLine();
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero que sea valido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    System.out.println("Cantidad de boletos: ");
                    int cantidad;
                    try {
                        cantidad = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Cantidad invalida.");
                        break;
                    }
                    System.out.println("Presupuesto: ");
                    double presupuesto;
                    try {
                        presupuesto = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Presupuesto invalido.");
                        break;
                    }
                    sistema.nuevoComprador(nombre, email, cantidad, presupuesto);
                    break;

                case 2:
                    sistema.solicitudBoletos();
                    break;

                case 3:
                    sistema.consultarDisponibilidad();
                    break;

                case 4:
                    System.out.println("Nombre de la localidad: ");
                    String loc = scanner.nextLine();
                    sistema.consultarDisponibleIndividual(loc);
                    break;

                case 5:
                    sistema.reporteCaja();
                    break;

                case 6:
                    System.out.println("Gracias por usar nuestro programa");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
