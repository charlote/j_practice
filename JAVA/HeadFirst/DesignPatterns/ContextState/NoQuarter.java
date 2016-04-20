public class NoQuarter implements State
{
    CandyMachine candyM;
    public NoQuarter(CandyMachine m){
        candyM = m;
    }
    public void insertQuarter(){
        System.out.println("insert a quarter");
        candyM.setState(candyM.getHasQuarterState()); 
    }
    public void ejectQuarter(){
        System.out.println("no quarter to eject");
    }
    public void turnCrank(){
        System.out.println("you turned, but no quarter for candy");
    }
    public void dispense(){
        System.out.println("you need to pay");
    }
}
