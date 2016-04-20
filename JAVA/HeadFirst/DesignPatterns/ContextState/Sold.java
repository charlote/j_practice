public class Sold implements State
{
    CandyMachine candyM;
    public Sold(CandyMachine m){
        candyM = m;
    }
    public void insertQuarter(){
        System.out.println("please wait");
    }
    public void ejectQuarter(){
        System.out.println("no quarter to eject");
    }
    public void turnCrank(){
        System.out.println("turned twice");
    }
    public void dispense(){
        candyM.releaseCandy();
        if(candyM.getCandyNum() > 0){
            candyM.setState(candyM.getNoQuarterState());
        } else {
            System.out.println("candy sold out");
            candyM.setState(candyM.getSoldOutState());
        }
    }
}
