import java.io.*;
import java.net.*;

public class DailyServer
{
    public static void main(String[] args){
        DailyServer server = new DailyServer();
        server.go();
    }
    public void go(){
        try{
            ServerSocket serverSoc = new ServerSocket(4242);
            while(true){
                Socket soc = serverSoc.accept();
                PrintWriter writer = new PrintWriter(soc.getOutputStream());    // build output message
                writer.println("connect!!!");
                writer.close();
                System.out.println("connect!!!");
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
