public class TestControl
{
    public static void main(String[] args){
        RemoteControl remote = new RemoteControl();
        Light l = new Light();
        LightOnC lighton = new LightOnC(l);

        remote.setCommand(lighton);
        remote.ButtPass();
    }
}
