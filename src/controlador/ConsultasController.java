package controlador;
import vistas.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultasController {
    public static VistaConsultas ventana = new VistaConsultas();
    public static void mostrar(){ 
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.labelNombre.setText(PrincipalController.ventana.txtNombre.getText());
        ventana.setTitle("Aplicación para Visualizar Reportes - MinVivienda");
        DefaultTableModel t_vacia = new DefaultTableModel();
        t_vacia.setRowCount(0);
        ventana.tablaRegistros.setModel(t_vacia);
    }
    public static void ocultar(){ ventana.setVisible(false); }
    
    public static void eventoInforme1(){
        String[] camposTabla ={"ID_Lider", "Nombre", "Primer_Apellido", "Ciudad_Residencia"};
        String[] resultadosConsulta = new String[4];
        DefaultTableModel resultadosTabla = new DefaultTableModel(null, camposTabla);
        String query = "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Consultas.conn();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            while(rs.next()){
                resultadosConsulta[0] = rs.getString("ID_Lider");
                resultadosConsulta[1] = rs.getString("Nombre");
                resultadosConsulta[2] = rs.getString("Primer_Apellido");
                resultadosConsulta[3] = rs.getString("Ciudad_Residencia");
                resultadosTabla.addRow(resultadosConsulta);
            }
            
        } catch (Exception e) {
        }
        ventana.tablaRegistros.setModel(resultadosTabla);
        ventana.tablaRegistros.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    public static void eventoInforme2(){
        String[] camposTabla ={"ID_Proyecto", "Constructora", "Numero_Habitaciones", "Ciudad"};
        String[] resultadosConsulta = new String[4];
        DefaultTableModel resultadosTabla = new DefaultTableModel(null, camposTabla);
        String query = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN('Santa Marta', 'Cartagena', 'Barranquilla')";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Consultas.conn();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            while(rs.next()){
                resultadosConsulta[0] = rs.getString("ID_Proyecto");
                resultadosConsulta[1] = rs.getString("Constructora");
                resultadosConsulta[2] = rs.getString("Numero_Habitaciones");
                resultadosConsulta[3] = rs.getString("Ciudad");
                resultadosTabla.addRow(resultadosConsulta);
            }
            
        } catch (Exception e) {
        }
        ventana.tablaRegistros.setModel(resultadosTabla);
        ventana.tablaRegistros.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    public static void eventoInforme3(){
        String[] camposTabla ={"ID_Compra", "Constructora", "Banco_Vinculado"};
        String[] resultadosConsulta = new String[3];
        DefaultTableModel resultadosTabla = new DefaultTableModel(null, camposTabla);
        String query = "SELECT Compra.ID_Compra, Proyecto.Constructora, Proyecto.Banco_Vinculado FROM Compra INNER JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto WHERE Compra.Proveedor = 'Homecenter' AND Proyecto.Ciudad = 'Salento';";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Consultas.conn();
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            while(rs.next()){
                resultadosConsulta[0] = rs.getString("ID_Compra");
                resultadosConsulta[1] = rs.getString("Constructora");
                resultadosConsulta[2] = rs.getString("Banco_Vinculado");
                resultadosTabla.addRow(resultadosConsulta);
            }
            
        } catch (Exception e) {
        }
        ventana.tablaRegistros.setModel(resultadosTabla);
        ventana.tablaRegistros.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    public static void eventoVolver(){
        ConsultasController.ocultar();
        PrincipalController.mostrar();
        PrincipalController.ventana.txtNombre.setText("");
    }
        
}
