import java.util.*;

public class PancakeMenu
{
    ArrayList menuItems;
    public PancakeMenu(){
        menuItems = new ArrayList();
        addItem("k&B Pancake", "Pancake with scrambled eggs and toast", 2.99);
        addItem("Regular Pancake", "Pancake with fried eggs and sausage", 2.99);
        addItem("Blueberry Pancake", "Pancake with fresh blueberry", 3.29);
    }
    public void addItem(String n, String desc, double p){
        MenuItem item = new MenuItem(n, desc, p);
        menuItems.add(item);
    }

    private class PancakeMenuI implements Iterator
    {
        ArrayList items;
        int num = 0;
        public PancakeMenuI(ArrayList items){
            this.items = items;
        }
        public Object next(){
            MenuItem item = (MenuItem) items.get(num);
            num = num + 1;
            return item;
        }
        public boolean hasNext(){
            if(num >= items.size()){
                return false;
            } else {
                return true;
            }
        }
    }
    
    public Iterator createIterator(){
        return new PancakeMenuI(menuItems);
    }
}
