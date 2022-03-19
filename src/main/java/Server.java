import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8085;

        while (true) {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter((clientSocket.getOutputStream()));

            System.out.println("New connection accepted. Port is " + clientSocket.getPort());
            BufferedReader in = new BufferedReader((new InputStreamReader(clientSocket.getInputStream())));

            final String name = in.readLine();
            out.println(String.format("Hi, %s. Port is %d", name, clientSocket.getPort()));
            serverSocket.close();
        }
    }
}
