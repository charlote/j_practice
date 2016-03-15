import java.rmi.*;

public class TestRemoteS
{
    public static void main(String[] args){
        try{
            TestRemote service = new TestRemoteImpl();
            Naming.rebind("Remote_Hello", service);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
