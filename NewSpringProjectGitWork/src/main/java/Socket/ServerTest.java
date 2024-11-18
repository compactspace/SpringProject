package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
 
public class ServerTest {
 
    // 클라이언트로 연결 받는 소켓
    ServerSocket serverSocket;
 
    // 실제 통신을 담당할 소켓 필요
    Socket socket;
 
    public ServerTest() {
        initData();
    }
 
    private void initData() {
        try {
            // 서버 소켓 생성
            serverSocket = new ServerSocket(10000);
 
          
            socket = serverSocket.accept(); // 대기하고 있음 -> 클라이언트가 들어오면 -> 소켓 반환
            System.out.println("클라이언트 연결 완료");
 
           
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
           
            System.out.println(reader.readLine() + "\n");
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        new ServerTest();
    } //end of main
    
} //end of class