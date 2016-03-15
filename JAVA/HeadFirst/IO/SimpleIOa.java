/* storage the object status by serialization
 */
import java.io.*;

public class SimpleIOa implements Serializable
{
    private int width;
    private int height;

    public void setWidth(int w){
        width = w;
    }
    public void setHeight(int h){
        height = h;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public static void main(String[] args){
        SimpleIOa myIO = new SimpleIOa();
        myIO.setWidth(50);
        myIO.setHeight(20);

        try{                                // serialization
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("foo.ser"));
            os.writeObject(myIO);
            os.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }

        myIO = null;

        try{                                // deserialization
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("foo.ser")); 
            SimpleIOa reIO = (SimpleIOa)is.readObject();
            System.out.println("width:" + reIO.getWidth() + " height:" + reIO.getHeight());
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
