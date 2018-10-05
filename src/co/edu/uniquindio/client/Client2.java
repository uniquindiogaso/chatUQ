package co.edu.uniquindio.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Client2 {

    public static final int PORT = 3400;
    public static final String SERVER_LOCATION = "127.0.0.1";

    private Socket clientSocket;
    private DataOutputStream salidaDatos;
    private BufferedReader entradaDatos;
    
     String msj = null;

    public static void main(String[] args) {
        new Client2();
    }

    public Client2() {
        System.out.println("TCP Client");
        try {
            clientSocket = new Socket(SERVER_LOCATION, PORT);
            salidaDatos = new DataOutputStream(clientSocket.getOutputStream());
            entradaDatos = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread escuchador = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            if (!clientSocket.isClosed() && entradaDatos.ready()) {
                                System.out.println("Mensaje entrante> " + entradaDatos.readLine());
                                
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("Comunicación finalizada!!!!");
                            break;
                        }
                    }
                }
            });
            escuchador.start();

            Scanner lector = new Scanner(System.in);
            msj = JOptionPane.showInputDialog(null,"mensaje");
            while ( JOptionPane.showInputDialog(null,"mensaje") != null) {
                try {
                    if (!clientSocket.isClosed()) {
                        //este se envia a todos!
                        salidaDatos.writeBytes("IP:/" + clientSocket.getLocalAddress() + " - " + msj + "\n");
                        msj = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
//        finally {
//            try {
//                if (entradaDatos != null) {
//                    entradaDatos.close();
//                }
//                if (salidaDatos != null) {
//                    salidaDatos.close();
//                }
//                if (clientSocket != null) {
//                    clientSocket.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
