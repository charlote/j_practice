public class Mocha extends CondimentDecor
{
    Beverage bev;

    public Mocha(Beverage b){
        bev = b;
    }
    public String getDescription(){
        return bev.getDescription() + ", Mocha";
    }
    public double cost(){
        return 0.2 + bev.cost();
    }
}
