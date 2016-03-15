import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleServer
{
    ArrayList clientlist;
    public static void main(String[] args){
        new SimpleServer().go();
    }
    public void go(){
        int i = 0;
        clientlist = new ArrayList();
        try{
            ServerSocket serverSoc = new ServerSocket(4242);
            while(true){
                Socket clientSoc = serverSoc.accept();
                PrintWriter writer = new PrintWriter(clientSoc.getOutputStream());
                writer.println("Client " + i + " connect!!!");
                clientlist.add(writer);

                Thread t = new Thread(new ClientHandler(clientSoc));
                t.start();
                System.out.println("Client " + i + " connect!!!");
                i++;
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public class ClientHandler implements Runnable
    {
        BufferedReader reader;
        Socket soc;

        public ClientHandler(Socket clientSoc){
            try{
                soc = clientSoc;
                reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        public void run(){
            String mesg;
            try{
                while((mesg = reader.readLine()) != null){
                    System.out.println("read " + mesg);
                    tellAll(mesg);
                }
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        private void tellAll(String mesg){
            Iterator it = clientlist.iterator();
            while(it.hasNext()){
                try{
                    PrintWriter writer = (PrintWriter)it.next();
                    writer.println(mesg);
                    writer.flush();
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}
