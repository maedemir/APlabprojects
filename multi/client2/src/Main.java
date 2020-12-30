import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        try (Socket client = new Socket("127.0.0.1", 7657)) {
            System.out.println("Connected to server.");
            OutputStream out = client.getOutputStream();
            InputStream in = client.getInputStream();
            byte[] buffer = new byte[2048];
            String massage = obj.nextLine();
            while (true) {
                out.write(massage.getBytes());
                System.out.println("SENT: " + massage);
                int read = in.read(buffer);
                if(read==-1){
                    break;
                }
                System.out.println("RECV: " + new String(buffer, 0, read));
                massage=obj.nextLine();
            }
            System.out.print("All messages sent.\nClosing ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");

    }
}
