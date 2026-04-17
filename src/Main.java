import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Vehiculo> vehiculos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarCamion();
                case 2 -> registrarFurgon();
                case 3 -> registrarMotoReparto();
                case 4 -> mostrarTodosLosVehiculos();
                case 5 -> mostrarVehiculosDisponibles();
                case 6 -> marcarVehiculoNoDisponible();
                case 7 -> mostrarReporteGeneral();
                case 8 -> salir();
                default -> System.out.println("Opción inválida. Elige entre 1 y 8.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    public static void mostrarMenu() {

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      === SISTEMA DE VEHICULOS ===      ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║   1. Registrar Camion                  ║");
        System.out.println("║   2. Registrar Furgon                  ║");
        System.out.println("║   3. Registrar Moto de Reparto         ║");
        System.out.println("║   4. Mostrar todos los vehiculos       ║");
        System.out.println("║   5. Mostrar vehiculos disponibles     ║");
        System.out.println("║   6. Mostrar vehiculos no disponibles  ║");
        System.out.println("║   7. Mostrar reporte general           ║");
        System.out.println("║   8. Salir                             ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║           Elige una opción             ║");
        System.out.println("╚════════════════════════════════════════╝");

    }

    public static void registrarCamion() {
        // Julio
    }

    // Tu método registrarFurgon
    private static void registrarFurgon() {
        System.out.println("\n--- Registro de Furgón ---");
        String patente = leerPatenteUnica();
        String marca = leerStringNoVacio("Marca: ");
        String modelo = leerStringNoVacio("Modelo: ");
        double capacidad = leerDouble("Capacidad de carga (kg): ");
        double volumen = leerDouble("Volumen interior (m³): ");

        try {
            Furgon furgon = new Furgon(patente, marca, modelo, capacidad, volumen);
            vehiculos.add(furgon);
            System.out.println(" Furgón registrado con éxito.");
        } catch (IllegalArgumentException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public static void registrarMotoReparto() {
        // Diego
    }

    public static void mostrarTodosLosVehiculos(List<Vehiculo> vehiculos) {
        System.out.println("\n===============================================");
        System.out.println("       LISTADO COMPLETO DE VEHÍCULOS");
        System.out.println("===============================================");

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados en el sistema.");
        } else {
            for (Vehiculo v : vehiculos) {
                // Polimorfismo en acción:
                // Si 'v' es un Camion, llamará al mostrarDetalle() de Camion.
                // Si 'v' es una Moto, llamará al de Moto.
                v.mostrarDetalle();
            }
        }
        System.out.println("===============================================\n");
    }

    public static void mostrarVehiculosDisponibles() {
        // Alexander
    }
    
    public static void marcarVehiculoNoDisponible() {

        System.out.println("=== MARCAR VEHICULO COMO NO DISPONIBLE ===\n");

        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.isDisponible()) {
                disponibles.add(vehiculo);
            }
        }

        if (disponibles.isEmpty()) {
            System.out.println(" No hay vehiculos disponibles.");
            System.out.println("\nPresione Enter para volver al menú...");
            scanner.nextLine();
            return;
        }

        System.out.println("Vehiculos disponibles:");
        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i).getPatente());
        }

        System.out.print("\nElige el número del vehiculo a marcar: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        if (seleccion < 1 || seleccion > disponibles.size()) {
            System.out.println(" Selección no válida.");
            System.out.println("\nPresione Enter para volver al menú...");
            scanner.nextLine();
            return;
        }

        // Agregar lógica para marcar el vehículo como no disponible
    }

    public void mostrarReporteGeneral() {
        int totalCamiones = 0, totalFurgones = 0, totalMotos = 0;
        int totalDisponibles = 0, totalNoDisponibles = 0;

        for (Vehiculo v : vehiculos) {
            // La sintaxis instanceof pregunta si algo es de cierta clase y revuelve true o false
            // en este caso: ¿v es una instancia de la clase Camion?
            if (v instanceof Camion) {
                totalCamiones++;
            }
            else if (v instanceof Furgon) {
                totalFurgones++;
            }
            else if (v instanceof MotoReparto) {
                totalMotos++;
            }

            if (v.isDisponible()){
                totalDisponibles++;
            }
            else {
                totalNoDisponibles++;
            }
        }

        System.out.println("\n========== REPORTE GENERAL ==========");
        System.out.println("Total de vehículos registrados : " + vehiculos.size());
        System.out.println("  Camiones                     : " + totalCamiones);
        System.out.println("  Furgones                     : " + totalFurgones);
        System.out.println("  Motos de reparto             : " + totalMotos);
        System.out.println("-------------------------------------");
        System.out.println("Disponibles                    : " + totalDisponibles);
        System.out.println("No disponibles                 : " + totalNoDisponibles);
        System.out.println("=====================================\n");

        System.out.printf("%-12s %-12s %-15s %-15s %-10s%n",
                "Patente", "Tipo", "Marca", "Modelo", "Disponible");
        System.out.println("-------------------------------------------------------------");

        for (Vehiculo v : vehiculos) {
            String tipo;
            if (v instanceof Camion){
                tipo = "Camión";
            }
            else if (v instanceof Furgon){
                tipo = "Furgón";
            }
            else {
                tipo = "Moto";
            }

            System.out.printf("%-12s %-12s %-15s %-15s %-10s%n",
                    v.getPatente(),
                    tipo,
                    v.getMarca(),
                    v.getModelo(),
                    // Operador ternario, es básicamente un if resumido
                    v.isDisponible() ? "Sí" : "No");
        }
    }
  
    public static void salir() {
        System.out.println("\nCerrando sistema");
        System.out.println("Saliendo...");
    }

    // Métodos auxiliares
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");
            }
        }
    }

    private static String leerStringNoVacio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String valor = scanner.nextLine().trim();
            if (!valor.isEmpty()) return valor;
            System.out.println("Error: este campo no puede estar vacío.");
        }
    }

    private static boolean patenteExiste(String patente) {
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                return true;
            }
        }
        return false;
    }

    private static String leerPatenteUnica() {
        while (true) {
            String patente = leerStringNoVacio("Patente: ");
            if (!patenteExiste(patente)) {
                return patente;
            }
            System.out.println(" Error: ya existe un vehículo con esa patente. Ingrese otra.");
        }
    }


}
