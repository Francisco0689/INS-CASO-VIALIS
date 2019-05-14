
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Solea
 */
public class Conexion {
    private Connection cnn;

    public Conexion() {
        this.conectar();
    }

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }
    
    private void conectar() {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:orcl";
        cnn= DriverManager.getConnection(BaseDeDatos,"INS_2019","oracle");
            if(cnn==null)
            {
                System.out.println("Conexion fallida");
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {System.out.println("error"+e);}
        
    }
    
    public void desonectarBD() {
        try {
            this.getCnn().close();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }

    }

    
}
