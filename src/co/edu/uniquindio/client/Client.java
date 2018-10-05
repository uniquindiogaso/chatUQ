package co.edu.uniquindio.client;

import co.edu.uniquindio.gui.Ventana;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    public static final int PORT = 3400;
    public static final String SERVER_LOCATION = "127.0.0.1";

    private Socket clientSocket;
    private DataOutputStream salidaDatos;
    private BufferedReader entradaDatos;
    public String nombre;
    private Color color;
    private String msj = "";
    Ventana v;

    /**
     * Constructor que permite ejecutar instancia de Cliente
     *
     * @param nombre Nombre de Usuario
     * @param color Color a Visualizar
     * @param v Ventana que se encarga de mostrar la información
     */
    public Client(String nombre, Color color, Ventana v) {
        this.v = v;
        this.color = color;
        this.nombre = nombre;
        System.out.println("TCP Client .... ¡Hola! " + nombre);
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
                                v.actualizarChar(entradaDatos.readLine() + "\n");
                                msj = "";

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("Comunicación finalizada!!!!");
                            // break;
                        }
                    }
                }
            });
            escuchador.start();

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

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    /**
     * Permite enviar el mensaje a todos los demas
     *
     * @param msj
     */
    public void enviar(String msj) {
        try {
            String t = String.format("%s|%s|%s", nombre, color.getRGB(), msj);
            salidaDatos.writeBytes(t + "\n");

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
