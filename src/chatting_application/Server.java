package chatting_application;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server implements Runnable {

    Socket socket;

    public static Vector client = new Vector();

    public Server(Socket socket) {
        try {
            this.socket = socket;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            client.add(writer);

            while (true) {
                String rcv = reader.readLine();

                if (rcv == null) {
                    System.out.println("Client disconnected.");
                    break;

                } else {
                    String data = rcv.trim();

                    System.out.println("Received " + data);

                    for (int i = 0; i < client.size(); i++) {

                        try {
                            BufferedWriter bw = (BufferedWriter) client.get(i);
                            bw.write(data);
                            bw.write("\r\n");
                            bw.flush();
                        } catch (IOException e) {
                        }
                    }
                }
            }
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(2003);
        while (true) {
            Socket socket = s.accept();
            Server server = new Server(socket);
            Thread thread = new Thread(server);
            thread.start();
        }
    }
}
