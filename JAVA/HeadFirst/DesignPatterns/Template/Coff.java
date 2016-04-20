import java.io.*;

public class Coff extends CaffBeverage
{
    public void brew(){
        System.out.println("Dripping Coff through filter");
    }
    public void addCondiments(){
        System.out.println("add Milk and Sugar");
    }
    @Override
        public boolean customerCondiments(){
            String ans = getUserAns();
            if(ans.toLowerCase().startsWith("y")){
                return true;
            } else {
                return false;
            }
        }
    private String getUserAns(){
        String ans = null;
        System.out.println("Would you like milk and sugar? (y/n)");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{
            ans = in.readLine();
        } catch(IOException ioe){
            System.out.println("IO error try to read answer");
        }
        if(ans == null){
            return "no";
        }
        return ans;
    }
}
