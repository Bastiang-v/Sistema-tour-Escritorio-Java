package LABDAL;
import LABBLL.LABBoletaBLL;
import LABBLL.LABCliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author bastian
 */
public class LABClienteDAL {
    LABConectarDAL conectar;
    
    public LABClienteDAL()
    {
        conectar = new LABConectarDAL("turismo");
        
    }
 public LABCliente buscarCliente(String rut) 
    {
        Statement t = conectar.crearSentencia();
        ResultSet resultado = null;
       
         LABCliente cl = new LABCliente();
  
        try
        {
            resultado = t.executeQuery("SELECT * FROM cliente where run = '"+rut+"';");
            while(resultado.next())
            {
                cl.setId_cliente(resultado.getInt("id_cliente"));
                cl.setNombre(resultado.getString("nombre"));
                cl.setApellido(resultado.getString("apellido"));
                cl.setRun(resultado.getString("run"));
                cl.setDv(resultado.getString("dv"));
                cl.setEstado(resultado.getInt("estado"));
                cl.setCorreo(resultado.getString("correo"));
                cl.setSaldo(resultado.getInt("saldo"));
             }
            return cl;
        }
        catch(SQLException e)
        {
            return null;
        }
    }
   public int agregarCLiente(LABBLL.LABCliente cliente) 
    {
        Statement t = conectar.crearSentencia();
        try
        {
            int resultado = t.executeUpdate("INSERT INTO cliente (run,dv,nombre,apellido,correo,saldo,estado,sigla,f_ingreso) VALUES ('"+cliente.getRun()+"','"+cliente.getDv()+"','"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+cliente.getCorreo()+"','"+cliente.getSaldo()+"',1,'LAB',now())");
            return resultado;
        }
        catch(SQLException e)
        {
            return -1;
        }
    }
   public int actualizarCliente(LABBLL.LABCliente cliente) 
    {
        Statement t = conectar.crearSentencia();
        try
        {
            int resultado = t.executeUpdate("UPDATE cliente SET nombre = '"+cliente.getNombre()+"', apellido = '"+cliente.getApellido()+"', correo = '"+cliente.getCorreo()+"' where id_cliente = '"+cliente.getId_cliente()+"';");
            return resultado;
        }
        catch(SQLException e)
        {
            return -1;
        }
    }
   public int desactivarCliente(LABBLL.LABCliente cliente) 
     {
        Statement t = conectar.crearSentencia();
     
        try
        {
           int resultado = t.executeUpdate("UPDATE cliente SET estado = 0 WHERE id_cliente = '"+cliente.getId_cliente()+"';");
            return resultado;
        }
        catch(SQLException e)
        {
            return -1;
        }
        
    }
   public ArrayList<LABCliente> mostrarCliente()
    {
        Statement t = conectar.crearSentencia();
        ResultSet resultado = null;
        
        ArrayList<LABCliente> client = new ArrayList<LABCliente>();
        try
        {
            resultado = t.executeQuery("SELECT * from cliente where estado = 1 order by saldo desc");
            while(resultado.next())
            {
                LABCliente cl = new LABCliente();
                cl.setId_cliente(resultado.getInt("id_cliente"));
                cl.setNombre(resultado.getString("nombre"));
                cl.setApellido(resultado.getString("apellido"));
                cl.setRun(resultado.getString("run"));
                cl.setDv(resultado.getString("dv"));
                cl.setEstado(resultado.getInt("estado"));
                cl.setCorreo(resultado.getString("correo"));
                cl.setSaldo(resultado.getInt("saldo"));
                client.add(cl);
            }
            return client;
        }
        catch(SQLException e)
        {
            return null;
        }
    }
   
   //----------Seleccion de producto y servicio---ADG--///////
   
      public ArrayList<LABBoletaBLL> mostrarProducto()
    {
        Statement t = conectar.crearSentencia();
        ResultSet resultado = null;
        
        ArrayList<LABBoletaBLL> producto = new ArrayList<LABBoletaBLL>();
        try
        {
            resultado = t.executeQuery("SELECT producto.producto, producto.id_producto, producto.stock, producto.detalle, producto.precio, "
                    + "servicio.id_servicio, servicio.servicio, servicio.detalle, producto.f_termino, producto.f_ingreso "
                    + "FROM producto "
                    + "inner JOIN servicio on producto.id_servicio = servicio.id_servicio "
                    + "WHERE producto.estado = 1 "
                    + "AND servicio.estado = 1 ");
            
            while(resultado.next())
            {
                LABBoletaBLL cl = new LABBoletaBLL();
                cl.setProducto(resultado.getString("producto.producto"));
                cl.setId_producto(resultado.getInt("producto.id_producto"));
                cl.setStock(resultado.getInt("producto.stock"));
                cl.setProducto_detalle(resultado.getString("producto.detalle"));
                cl.setPrecio(resultado.getInt("producto.precio"));
                cl.setId_servicio(resultado.getInt("servicio.id_servicio"));
                cl.setServicio(resultado.getString("servicio.servicio"));
                cl.setServicioDetalle(resultado.getString("servicio.detalle"));
                cl.setFecha_inicio(resultado.getString("producto.f_termino"));
                cl.setFecha_termino(resultado.getString("producto.f_ingreso"));
                
                producto.add(cl);
            }
            return producto;
        }
        catch(SQLException e)
        {
            return null;
        }
    }
      
      //------------Genera Boleta en estado 0-----------//
      
 public int agregarBoleta(LABBLL.LABBoletaBLL cliente) 
    {
        Statement t = conectar.crearSentencia();
        try
        {
            int resultado = t.executeUpdate("INSERT INTO boleta (id_boleta, id_cliente, fechapago, total, estado, sigla, f_ingreso) "
                    + "                      VALUES (NULL,'"+cliente.getId_cliente()+"' ,now(),0 ,0 ,'LAB', now())");
            return resultado ;
        }
        catch(SQLException e)
        {
            return -1;
        }
    }     
      
   //------------BuscarBoleta-------
 
  public LABBoletaBLL ultimaBoleta(String cliente) 
    {
        Statement t = conectar.crearSentencia();
        ResultSet resultado = null;
       
         LABBoletaBLL cl = new LABBoletaBLL();
  
        try
        {
            resultado = t.executeQuery("select * from boleta order by id_boleta desc limit 1 ");
            while(resultado.next())
            {
                cl.setId_boleta(resultado.getInt("id_boleta"));
                
             }
            return cl;
        }
        catch(SQLException e)
        {
            return null;
        }
    }
   
   //---------------------------Metodos Saldo ------------------------------------/////////////
   public int recargarSaldo(LABBLL.LABCliente cliente, int recarga) 
    {
        Statement t = conectar.crearSentencia();
        try
        {
            int resultado = t.executeUpdate("UPDATE cliente SET saldo = '"+(cliente.getSaldo()+recarga)
                                            +"' where id_cliente = '"+cliente.getId_cliente()+"';");
            return resultado;
        }
        catch(SQLException e)
        {
            return -1;
        }
    }
    public int eliminarSaldo(LABBLL.LABCliente cliente) 
    {
        Statement t = conectar.crearSentencia();
        try
        {
            int resultado = t.executeUpdate("UPDATE cliente set saldo = 0  where id_cliente = '"+cliente.getId_cliente()+"';");
            return resultado;
        }
        catch(SQLException e)
        {
            return -1;
        }
    }
   
   //----------Agegar Productos ----------/////////
   
  public int agregarDetalle(LABBLL.LABBoletaBLL cliente) 
    {
        Statement t = conectar.crearSentencia();
        try
        {
            int resultado = t.executeUpdate("INSERT INTO detalleboleta (id_detalleboleta, id_boleta, cantidad, id_producto, estado, sigla, f_ingreso) "
                    + "                      VALUES (NULL, "+cliente.getId_boleta()+", "+cliente.getCantidad()+", "+cliente.getId_producto()+",1 , 'LAB', now())");
            return resultado ;
        }
        catch(SQLException e)
        {
            return -1;
        }
    }      
   
   
   
     ///-----------Metodos apoyo-----------/////
   public String FormatoRutUsuario(String rut) {
 
        int cont = 0;
        String format;
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        format = "-" + rut.substring(rut.length() - 1);
        for (int i = rut.length() - 2; i >= 0; i--) {
            format = rut.substring(i, i + 1) + format;
            cont++;
            if (cont == 3 && i != 0) {
                format = "." + format;
                cont = 0;
            }
        }
        return format;
}  
public  boolean validarRut(String rut) {
 
boolean validacion = false;
try {
rut =  rut.toUpperCase();
rut = rut.replace(".", "");
rut = rut.replace("-", "");
int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
 
char dv = rut.charAt(rut.length() - 1);
 
int m = 0, s = 1;
for (; rutAux != 0; rutAux /= 10) {
s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
}
if (dv == (char) (s != 0 ? s + 47 : 75)) {
validacion = true;
}
 
} catch (java.lang.NumberFormatException e) {
} catch (Exception e) {
}
return validacion;
}
   
    
}
