public class DinerMenu
{
    static final int MAX_ITEM = 6;
    int NumOfItem = 0;
    MenuItem[] menuItems;

    public DinerMenu(){
        menuItems = new MenuItem[MAX_ITEM];
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", 2.99);
        addItem("Soup of the day", "Soup of the day with a side of potato salad", 2.09);
        addItem("Hotdog", "A hot dog with saurkarut, relish, onions, topped with cheese", 3.09);
    }
    public void addItem(String n, String desc, double p){
        MenuItem item = new MenuItem(n, desc, p);
        if(NumOfItem >= MAX_ITEM){
            System.out.println("Sorry menu is full");
        } else {
            menuItems[NumOfItem] = item;
            NumOfItem = NumOfItem + 1;
        }
    }

    private class DinerMenuI implements Iterator
    {
        MenuItem[] items;
        int num = 0;
        public DinerMenuI(MenuItem[] items){
            this.items = items;
        }
        public Object next(){
            MenuItem menuItem = items[num];
            num = num + 1;
            return menuItem;
        }
        public boolean hasNext(){
            if(num >= items.length || items[num] == null){
                return false;
            } else {
                return true;
            }
        }
    }
    public Iterator createIterator(){
        return new DinerMenuI(menuItems);
    }
}
