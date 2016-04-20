public class HasQuarter implements State
{
    CandyMachine candyM;
    public HasQuarter(CandyMachine m){
        candyM = m;
    }
    public void insertQuarter(){
        System.out.println("too much");
    }
    public void ejectQuarter(){
        System.out.println("eject quarter");
        candyM.setState(candyM.getNoQuarterState());
    }
    public void turnCrank(){
        System.out.println("you turned");
        candyM.setState(candyM.getSoldState());
    }
    public void dispense(){
        System.out.println("no candy dispense");
    }
}
