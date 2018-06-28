
package LABDAL;

import LABBLL.LABBoletaBLL;
import LABBLL.LABCliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class LABBoletaDAL 
{
       LABConectarDAL conectar;
    
    public LABBoletaDAL()
    {
        conectar = new LABConectarDAL("turismo");
        
    }
    
   //----------Seleccion de Tour---ADG--///////
   
      public ArrayList<LABBoletaBLL> mostrarTour()
    {
        Statement t = conectar.crearSentencia();
        ResultSet resultado = null;
        
        ArrayList<LABBoletaBLL> producto = new ArrayList<LABBoletaBLL>();
        try
        {
            resultado = t.executeQuery("SELECT tour.id_tour, tour.tour, tour.detalle, producto.producto, "
                    + "producto.stock, producto.detalle, producto.precio, producto.id_producto, "
                    + "producto.f_inicio, producto.f_termino, servicio.servicio, servicio.detalle, tipoproducto.tipoproducto, "
                    + "servicio.id_servicio, servicio.servicio, servicio.detalle, producto.f_termino, producto.f_ingreso "
                    + "FROM tour "
                    + "INNER JOIN producto ON tour.id_producto = producto.id_producto "
                    + "INNER JOIN servicio ON producto.id_servicio = servicio.id_servicio "
                    + "INNER JOIN tipoproducto ON servicio.id_tipoproducto = tipoproducto.id_tipoproducto "
                    + "WHERE tour.estado = 1 "
                    + "AND servicio.estado = 1 "
                    + "AND tipoproducto.estado =1 ");
            
            while(resultado.next())
            {
                LABBoletaBLL cl = new LABBoletaBLL();
                cl.setId_tour(resultado.getInt("tour.id_tour"));
                cl.setTour(resultado.getString("tour.tour"));
                cl.setProducto(resultado.getString("producto.producto"));
                cl.setStock(resultado.getInt("producto.stock"));
                cl.setProducto_detalle(resultado.getString("producto.detalle"));
                cl.setId_producto(resultado.getInt("producto.id_producto"));
                cl.setPrecio(resultado.getInt("producto.precio"));
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
    
     
   //----------Agegar detalle Tour ----------/////////
   
  public int agregarDetalleThour(LABBLL.LABBoletaBLL cliente) 
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
   

   public ArrayList<LABBoletaBLL> mostrarDetalleBoleta(int id_boleta)
    {
        Statement t = conectar.crearSentencia();
        ResultSet resultado = null;
        
        ArrayList<LABBoletaBLL> producto = new ArrayList<LABBoletaBLL>();
        try
        {
            resultado = t.executeQuery("SELECT detalleboleta.id_boleta, detalleboleta.id_boleta, detalleboleta.cantidad, "
                    + "producto.precio, producto.producto "
                    + "FROM detalleboleta "
                    + "INNER JOIN producto on detalleboleta.id_producto = producto.id_producto "
                    + "INNER JOIN boleta ON detalleboleta.id_boleta = boleta.id_boleta "
                    + "WHERE detalleboleta.id_boleta ='"+id_boleta+"';");
            
            while(resultado.next())
            {
                LABBoletaBLL cl = new LABBoletaBLL();
                cl.setId_boleta(resultado.getInt("detalleboleta.id_boleta"));
                cl.setCantidad(resultado.getInt("detalleboleta.cantidad"));
                cl.setPrecio(resultado.getInt("producto.precio"));
                cl.setProducto(resultado.getString("producto.producto"));
             
                
                producto.add(cl);
            }
            return producto;
        }
        catch(SQLException e)
        {
            return null;
        }
    }  

    public int actualizarTotal(LABBLL.LABBoletaBLL T) 
    {
        Statement t = conectar.crearSentencia();
        try
        {
            int resultado = t.executeUpdate("UPDATE boleta SET total = "+T.getTotal()+" "
                    + "where id_boleta = "+T.getId_boleta()+"");
            return resultado;
        }
        catch(SQLException e)
        {
            return -1;
        }
    }    
       
    
   public LABBoletaBLL detallerBoleta(int bolrta) 
    {
        Statement t = conectar.crearSentencia();
        ResultSet resultado = null;
       
         LABBoletaBLL bo = new LABBoletaBLL();
  
        try
        {
            resultado = t.executeQuery("SELECT detalleboleta.id_boleta, detalleboleta.id_boleta, detalleboleta.cantidad, "
                    + "producto.precio, producto.producto "
                    + "FROM detalleboleta "
                    + "INNER JOIN producto on detalleboleta.id_producto = producto.id_producto "
                    + "INNER JOIN boleta ON detalleboleta.id_boleta = boleta.id_boleta "
                    + "WHERE detalleboleta.id_boleta = "+bo.getId_boleta()+ "");
            
            while(resultado.next())
            {
                LABBoletaBLL cl = new LABBoletaBLL();
                cl.setId_boleta(resultado.getInt("detalleboleta.id_boleta"));
                cl.setCantidad(resultado.getInt("detalleboleta.cantidad"));
                cl.setPrecio(resultado.getInt("producto.precio"));
                cl.setProducto(resultado.getString("producto.producto"));
             }
            return bo;
        }
        catch(SQLException e)
        {
            return null;
        }
    }
   
     public LABBoletaBLL totaBoleta(int boleta) 
    {
        Statement t = conectar.crearSentencia();
        ResultSet resultado = null;
       
         LABBoletaBLL bo = new LABBoletaBLL();
  
        try
        {
            resultado = t.executeQuery("SELECT total "
                    + "FROM boleta "
                    + "WHERE id_boleta = "+boleta+ "");
            
            while(resultado.next())
            {
                
                
                bo.setTotal(resultado.getInt("total"));
             }
            return bo;
        }
        catch(SQLException e)
        {
            return null;
        }
    } 
   
      public int actualizaBoletaPagada(LABBLL.LABBoletaBLL T) 
    {
        Statement t = conectar.crearSentencia();
        
       try
        {   
            int resultado = t.executeUpdate("UPDATE boleta SET estado = 1"
                    + " WHERE id_boleta = "+T.getId_boleta()+"");
            
            return resultado;
        }
        catch(SQLException e)
        {
            if(e.getErrorCode() == 1062){
                return -1;
            }
            else
                return -2;
        }
    }
      
       public int descuentoPago(LABBLL.LABBoletaBLL T) 
    {
        Statement t = conectar.crearSentencia();
        
       try
        {   
            int resultado = t.executeUpdate("UPDATE cliente SET saldo = "+T.getSaldo()+" WHERE id_cliente = "+T.getId_cliente()+"");
            
            return resultado;
        }
        catch(SQLException e)
        {
            if(e.getErrorCode() == 1062){
                return -1;
            }
            else
                return -2;
        }
    }     
      
      
}
