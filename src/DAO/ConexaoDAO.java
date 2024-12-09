package DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {

    private final static String USER = "root";
    private final static String PASSWORD = "";
    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/mercado_central";

    public Connection conexaoDAO() {
        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados " + e + "ConexaoDAO" + JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e.getMessage());
        }
        
        return conn;
    }

}
