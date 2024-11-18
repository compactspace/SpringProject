package Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class ClientTest {
 
   
    Socket socket;

    final String IP = "localhost";
    final int PORT = 10000;
 
    BufferedReader reader;
    BufferedWriter writer;
 
    public ClientTest() {
        initData();
    }
 
    private void initData() {
        System.out.println("clinent req connection");
 
        try {
            socket = new Socket(IP, PORT);
 
          
            reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
 
           
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
 
            writer.write(input);
            writer.newLine(); 
            writer.flush();
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    public static void main(String[] args) {
        new ClientTest();
    } 
 
} 
