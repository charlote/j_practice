import java.rmi.*;
import java.rmi.server.*;

public class TestRemoteImpl extends UnicastRemoteObject implements TestRemote
{
    public TestRemoteImpl() throws RemoteException{
        super();
    }
    public String sayHello(){
        return "server say: Hey~~~";
    }
}
