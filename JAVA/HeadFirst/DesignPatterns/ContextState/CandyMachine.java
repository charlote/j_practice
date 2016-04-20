public class CandyMachine
{
    private State soldOut;
    private State noQuarter;
    private State hasQuarter;
    private State sold;

    State state = soldOut;
    final int total;
    int num = 0;

    public CandyMachine(int total){
        soldOut = new SoldOut(this);
        noQuarter = new NoQuarter(this);
        hasQuarter = new HasQuarter(this);
        sold = new Sold(this);
        this.total = total;
        num = total;
        if(num > 0){
            state = noQuarter; 
        }
    }
    public void insertQuarter(){
        state.insertQuarter();
    }
    public void ejectQuarter(){
        state.ejectQuarter();
    }
    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }
    public void setState(State s){
        state = s;
    }
    public void releaseCandy(){
        System.out.println("candy comes rolling out");
        if(num != 0){
            num = num - 1;
        }
    }
    public int getCandyNum(){
        return num;
    }
    public State getNoQuarterState(){
        return noQuarter;
    }
    public State getHasQuarterState(){
        return hasQuarter;
    }
    public State getSoldState(){
        return sold;
    }
    public State getSoldOutState(){
        return soldOut;
    }
}
