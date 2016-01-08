package socketMolon;

public class ConductorServidor {

	public static void main(String[] args) {
		//HiloServidorLanzarMoneda servidor = new HiloServidorLanzarMoneda();		
		//servidor.run();
		ServidorLanzarMoneda server = new ServidorLanzarMoneda();
		server.initServer();
	}
}
