/* Invoker set the condition when the command is operated */

public class RemoteControl
{
    Command slot;

    public RemoteControl(){}

    public void setCommand(Command c){
        slot = c;
    }
    public void ButtPass(){
        System.out.println("light on button pass");
        slot.execute();
    }
}
