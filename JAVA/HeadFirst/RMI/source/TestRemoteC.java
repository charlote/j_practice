import java.rmi.*;

public class TestRemoteC
{
    public static void main(String[] args){
        new TestRemoteC().go();
    }
    public void go(){
        try{
            TestRemote service = (TestRemote) Naming.lookup("rmi://127.0.0.1/Remote_Hello");
            String s = service.sayHello();
            System.out.println(s);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
