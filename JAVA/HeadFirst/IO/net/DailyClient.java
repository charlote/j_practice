import java.io.*;
import java.net.*;

public class DailyClient
{
    public static void main(String[] args){
        DailyClient client = new DailyClient();
        client.go();
    }
    public void go(){
        try{
            Socket soc = new Socket("127.0.0.1", 4242);
            BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String adv = reader.readLine();
            System.out.println(adv);
            reader.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
