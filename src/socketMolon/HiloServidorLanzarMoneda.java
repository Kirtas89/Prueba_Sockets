package socketMolon;

public class HiloServidorLanzarMoneda extends Thread {
	ServidorLanzarMoneda servidor;
	
	public void run() {
		servidor = new ServidorLanzarMoneda();
		servidor.initServer();
	}
}
