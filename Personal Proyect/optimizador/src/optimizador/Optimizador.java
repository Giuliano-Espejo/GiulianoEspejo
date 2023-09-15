package optimizador;

import java.io.File;
import javax.swing.JOptionPane;

public class Optimizador {

    public static void main(String[] args) {
        try {
            // Ruta de la carpeta %temp%
            String rutaTemp = System.getenv("TEMP");
            eliminarArchivos(new File(rutaTemp));

            // Ruta de la carpeta temp
            String rutaTemp2 = "C:\\Windows\\Temp";
            eliminarArchivos(new File(rutaTemp2));
            
            String rutaPre = "C:\\Windows\\Prefetch";
            eliminarArchivos(new File(rutaPre));
            
            JOptionPane.showMessageDialog(null, "Se borraron los archivos temporales");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en los temporales WINDOWS");
        }
        
    }


private static void eliminarArchivos(File carpeta) {
        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    eliminarArchivos(archivo);
                }
            }
        }
        carpeta.delete();
    }
}
