import java.util.*;

public class Menu extends MenuComponent
{
    ArrayList menuCs = new ArrayList();
    String name;
    String description;

    public Menu(String n, String desc){
        name = n;
        description = desc;
    }
    public void add(MenuComponent menuC){
        menuCs.add(menuC);
    }
    public void remove(MenuComponent menuC){
        menuCs.remove(menuC);
    }
    public MenuComponent getChild(int i){
        return (MenuComponent)menuCs.get(i);
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public void print(){
        System.out.println("\n" + getName() + ", " + getDescription() + "---");
        Iterator i = menuCs.iterator();
        while(i.hasNext()){
            MenuComponent menuC = (MenuComponent)i.next();
            menuC.print();
        }
    }
}
