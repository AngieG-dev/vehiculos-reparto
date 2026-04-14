public class Main {
    public static void main(String[] args) {

    }
  
    public static void marcarVehiculo(){

        System.out.println("=== MARCAR VEHICULO COMO NO DISPONIBLE ===\n");

        List<String> disponibles = new ArrayList<>();
        for (String vehiculo : nombreVehiculos) {
            if (estadoVehiculo.get(vehiculo).equals("Disponible")) {
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
            String vehiculos = disponibles.get(i);
            String marca = marcaVehiculo.get(vehiculo);
            System.out.println((i + 1) + ". " + animal + " (" + especie + ")");
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
}
