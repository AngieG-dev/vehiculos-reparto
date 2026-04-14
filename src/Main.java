public class Main {
    public static void main(String[] args) {

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