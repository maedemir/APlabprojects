import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(7657)) {
            System.out.print("Server started.\nWaiting for a client ... ");
            try (Socket connectionSocket = server.accept()) {
                System.out.println("client accepted!");
                OutputStream out = connectionSocket.getOutputStream();
                InputStream in = connectionSocket.getInputStream();
                byte[] buffer = new byte[2048];
                String response = "";
                while (true){
                    int read = in.read(buffer);
                    System.out.println("RECV: " + new String(buffer, 0, read));
                    String temp = new String(buffer,0,read);
                    if(temp.equals("over")){
                        break;
                    }
                    response+=temp;
                    out.write(response.getBytes());
                    System.out.println("SENT: " + response);
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
            System.out.print("done.\nClosing server ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }
}
