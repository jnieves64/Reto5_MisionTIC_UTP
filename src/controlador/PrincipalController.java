package controlador;
import vistas.*;

public class PrincipalController {
    
    public static VistaPrincipal ventana = new VistaPrincipal();
    public static void mostrar(){ 
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Aplicación para Visualizar Reportes - MinVivienda");
        ventana.txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        }
    public static void ocultar(){ ventana.setVisible(false); }
    
    public static void eventoBoton1(){
        PrincipalController.ocultar();
        ConsultasController.mostrar();
    }
}
