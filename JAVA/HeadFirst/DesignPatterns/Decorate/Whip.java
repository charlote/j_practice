public class Whip extends CondimentDecor
{
    Beverage bev;

    public Whip(Beverage b){
        bev = b;
    }
    public String getDescription(){
        return bev.getDescription() + ", Whip";
    }
    public double cost(){
        return 0.1 + bev.cost();
    }
}
