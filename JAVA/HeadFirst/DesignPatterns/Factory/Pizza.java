public abstract class Pizza
{
    String name;

    public void prepare(){
        System.out.println("preparing" + name);
    }
    public void bake(){
        System.out.println("bake" + name);
    }
    public void cut(){
        System.out.println("cut" + name);
    }
    public void box(){
        System.out.println("box" + name);
    }
    public String getName(){
        return name;
    }
}
