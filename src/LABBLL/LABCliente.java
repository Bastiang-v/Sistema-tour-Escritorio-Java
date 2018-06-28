
package LABBLL;

/**
 *
 * @author bastian
 */
public class LABCliente {
    int id_cliente;
    String run;
    String dv;
    String nombre;
    String apellido;
    String correo;
    int saldo;
    int estado;

    public LABCliente() {
    }

    public LABCliente(int id_cliente, String run, String dv, String nombre, String apellido, String correo, int saldo, int estado) {
        this.id_cliente = id_cliente;
        this.run = run;
        this.dv = dv;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.saldo = saldo;
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Run=" + run + ", dv=" + dv + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", saldo=" + saldo;
    }
    
    
    
}
