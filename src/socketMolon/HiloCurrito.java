package socketMolon;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

/**

 */
public class HiloCurrito implements Runnable{

    protected Socket clientSocket = null;
    private BufferedReader entrada;
	private DataOutputStream salida;	

    public HiloCurrito(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
        	int resultadoTirada;
			char repetir = 'S';
			Random tirada = new Random(101);
            
            entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			salida = new DataOutputStream(clientSocket.getOutputStream());
            
            //CONTENIDO HILO
            salida.writeUTF("Bienvenido al tiramonedas");
			
			do {
				resultadoTirada = tirada.nextInt();
				if (resultadoTirada < 50) {
					salida.writeUTF("\n\rHa salido cara");
				}
				else {
					salida.writeUTF("\n\rHa salido cruz");
				}				
				salida.writeUTF("\n\rQuieres tirar otra vez? S/N");
				salida.writeUTF("\n\r");
				repetir = entrada.readLine().charAt(0);
			} while (repetir == 'S' || repetir == 's');
			salida.writeUTF("\n\rHasta pronto");			
        } catch (IOException e) {
        	System.out.println("Conexión cerrada");
            //e.printStackTrace();        	
        } catch (Exception ex) {
        	System.out.println("El cliente cerró la conexión");        	
        } finally {
        	try {
				salida.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				entrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}