public class TestMenu
{
    public static void main(String args[]){
        MenuComponent allM = new Menu("ALL MENU", "all menus combined");
        
        MenuComponent pancakeM = new Menu("PANCAKE MENU", "Breakfast");
        MenuComponent dinerM = new Menu("DINER MENU", "Lunch");
        allM.add(pancakeM);
        allM.add(dinerM);
        
        pancakeM.add(new MenuItem("k&B Pancake", "Pancake with scrambled eggs and toast", 2.99));
        pancakeM.add(new MenuItem("Regular Pancake", "Pancake with fried eggs and sausage", 2.99));
        pancakeM.add(new MenuItem("Blueberry Pancake", "Pancake with fresh blueberry", 3.29));
        
        dinerM.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", 2.99));
        dinerM.add(new MenuItem("Soup of the day", "Soup of the day with a side of potato salad", 2.09));
        dinerM.add(new MenuItem("Hotdog", "A hot dog with saurkarut, relish, onions, topped with cheese", 3.09));

        MenuComponent dessertM = new Menu("DESSERT MENU", "dessert");
        dinerM.add(dessertM);
        dessertM.add(new MenuItem("Apple Pie", "Apple Pie with a flakey crust, topped with vanilla ice cream", 1.59));

        Waitress waitress = new Waitress(allM);
        waitress.printMenu();
    }
}
