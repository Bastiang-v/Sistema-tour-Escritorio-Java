package LABDAL;
import java.sql.*;
/**
 *
 * @author Alumno
 */
public class LABConectarDAL {
       Connection conn;
   public LABConectarDAL(String baseDatos)
   {
       verificar();
       conectarse(baseDatos);
   }
   
   public String verificar()
   {
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
           return "Exito";
       }
       catch(ClassNotFoundException e)
       {
           return "Falta el conector";
       }
   }
   public String conectarse(String baseDatos)
   {
       try
       {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+baseDatos,"root","");
           return "exito";
       }
       catch(SQLException e)
       {
           return "Servidor no encontrado";
       }
   }
   public Statement crearSentencia()
   {
    try
       {
           return conn.createStatement();
       }
       catch(SQLException e)
       {
          return null;
       }
   }
}