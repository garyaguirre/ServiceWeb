
package paquetews;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author CASA
 */
@WebService(serviceName = "ServiceBin")
public class ServiceBin {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "getFicheroAdjunto")
    public byte[] getFicheroAdjunto(){
        String ruta  = "D:\\texto.txt";
        File file = new File(ruta);
        try{
        
        FileInputStream fis = new FileInputStream(file);
            try (BufferedInputStream input = new BufferedInputStream(fis)) {
                byte[] salida = new byte[(int) file.length()];
                input.read(salida);
                input.close();
                return salida;
            }        
        } catch (IOException ex){
                return null;
        }
        
    }
}
