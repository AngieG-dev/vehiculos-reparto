package modelo;

public class MotoReparto extends Vehiculo {

    private boolean tieneCajaTermica;

    public MotoReparto(String patente, String marca, String modelo, double capacidadCarga, boolean disponible, boolean tieneCajaTermica) {
        super(patente, marca, modelo, capacidadCarga, disponible);
        this.tieneCajaTermica = tieneCajaTermica;
    }

    // Getter
    public boolean isTieneCajaTermica() {
        return tieneCajaTermica;
    }

    // Setter
    public void setTieneCajaTermica(boolean tieneCajaTermica) {
        this.tieneCajaTermica = tieneCajaTermica;
    }

    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle();
        System.out.println("Caja térmica: " + (tieneCajaTermica ? "Sí" : "No"));
    }
}