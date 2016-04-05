public class MenuItem
{
    String name;
    String description;
    double price;

    public MenuItem(String n, String desc, double p){
        name = n;
        description = desc;
        price = p;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public double getPrice(){
        return price;
    }
}
