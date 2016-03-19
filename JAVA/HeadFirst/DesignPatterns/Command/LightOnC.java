/* the command accept the Receiver_Object */
/* Receiver will execute its function throught the command */

public class LightOnC implements Command
{
    Light l;
    public LightOnC(Light l){
        this.l = l;
    }

    public void execute(){
        l.on();
    }
}
