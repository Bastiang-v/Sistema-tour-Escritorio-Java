
package LABBLL;


public class LABBoletaBLL 
{
 int id_boleta;
 int id_cliente;
 int cantidad;
 int id_producto;
 int estado;
 int id_detalleboleta;
 String fechapago;
 String producto;
 int id_servicio;
 String servicio;
 int stock;
 int precio;
 int saldo;
 String fecha_inicio;
 String fecha_termino;
 String producto_detalle;
 String detalle_tour;
 String tour;
 String tipo_producto;
 String tour_detalle;
 String rut;
 int id_tour;
 String servicioDetalle;
int total;

    public LABBoletaBLL() {
    }

    public LABBoletaBLL(int id_boleta, int id_cliente, int cantidad, int id_producto, int estado, int id_detalleboleta, String fechapago, String producto, int id_servicio, String servicio, int stock, int precio, int saldo, String fecha_inicio, String fecha_termino, String producto_detalle, String detalle_tour, String tour, String tipo_producto, String tour_detalle, String rut, int id_tour, String servicioDetalle, int total) {
        this.id_boleta = id_boleta;
        this.id_cliente = id_cliente;
        this.cantidad = cantidad;
        this.id_producto = id_producto;
        this.estado = estado;
        this.id_detalleboleta = id_detalleboleta;
        this.fechapago = fechapago;
        this.producto = producto;
        this.id_servicio = id_servicio;
        this.servicio = servicio;
        this.stock = stock;
        this.precio = precio;
        this.saldo = saldo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.producto_detalle = producto_detalle;
        this.detalle_tour = detalle_tour;
        this.tour = tour;
        this.tipo_producto = tipo_producto;
        this.tour_detalle = tour_detalle;
        this.rut = rut;
        this.id_tour = id_tour;
        this.servicioDetalle = servicioDetalle;
        this.total = total;
    }

    public int getId_boleta() {
        return id_boleta;
    }

    public void setId_boleta(int id_boleta) {
        this.id_boleta = id_boleta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId_detalleboleta() {
        return id_detalleboleta;
    }

    public void setId_detalleboleta(int id_detalleboleta) {
        this.id_detalleboleta = id_detalleboleta;
    }

    public String getFechapago() {
        return fechapago;
    }

    public void setFechapago(String fechapago) {
        this.fechapago = fechapago;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(String fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public String getProducto_detalle() {
        return producto_detalle;
    }

    public void setProducto_detalle(String producto_detalle) {
        this.producto_detalle = producto_detalle;
    }

    public String getDetalle_tour() {
        return detalle_tour;
    }

    public void setDetalle_tour(String detalle_tour) {
        this.detalle_tour = detalle_tour;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getTour_detalle() {
        return tour_detalle;
    }

    public void setTour_detalle(String tour_detalle) {
        this.tour_detalle = tour_detalle;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getId_tour() {
        return id_tour;
    }

    public void setId_tour(int id_tour) {
        this.id_tour = id_tour;
    }

    public String getServicioDetalle() {
        return servicioDetalle;
    }

    public void setServicioDetalle(String servicioDetalle) {
        this.servicioDetalle = servicioDetalle;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

   
}
