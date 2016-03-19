public class Soy extends CondimentDecor
{
    Beverage bev;

    public Soy(Beverage b){
        bev = b;
    }
    public String getDescription(){
        return bev.getDescription() + ", Soy";
    }
    public double cost(){
        return 0.15 + bev.cost();
    }
}
