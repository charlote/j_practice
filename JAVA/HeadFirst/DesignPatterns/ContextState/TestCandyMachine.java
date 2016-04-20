public class TestCandyMachine
{
    public static void main(String[] args){
        CandyMachine candyM = new CandyMachine(3);

        candyM.insertQuarter();
        candyM.turnCrank();
        candyM.insertQuarter();
        candyM.turnCrank();
        candyM.insertQuarter();
        candyM.turnCrank();
        candyM.insertQuarter();
        candyM.turnCrank();
    }
}
