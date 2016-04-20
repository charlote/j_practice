public class SoldOut implements State
{
    CandyMachine candyM;
    public SoldOut(CandyMachine m){
        candyM = m;
    }
    public void insertQuarter(){
        System.out.println("with out candy");
    }
    public void ejectQuarter(){
        System.out.println("no quarter to eject when sold out");
    }
    public void turnCrank(){
        System.out.println("turned twice, but no candy");
    }
    public void dispense(){
        System.out.println("candy empty");
    }
}
