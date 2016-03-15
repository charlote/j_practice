import java.rmi.*;

public interface TestRemote extends Remote
{
    public String sayHello() throws RemoteException;
}
