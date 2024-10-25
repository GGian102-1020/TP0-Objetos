public class Empleado {
    private String nombre;
    private String puesto;
    private double salario;
    private Maquina maquinaAsignada;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.maquinaAsignada = null;
    }

    public void asignarMaquina(Maquina maquina) {
        this.maquinaAsignada = maquina;
    }

    public void liberarMaquina() {
        this.maquinaAsignada = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void trabajar() {
        if (maquinaAsignada == null) {
            System.out.println(nombre + " no tiene una máquina asignada.");
        } else if (!maquinaAsignada.estaEnUso()) {
            System.out.println(nombre + " está trabajando en la máquina " + maquinaAsignada.getTipo());
            maquinaAsignada.usarMaquina(); // El empleado comienza a usar la máquina
        } else {
            System.out.println("La máquina ya está en uso.");
        }
    }
}
