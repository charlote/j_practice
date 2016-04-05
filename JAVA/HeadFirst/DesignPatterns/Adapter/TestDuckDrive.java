public class DuckTestDrive
{
    public static void main(String[] args){
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Duck TurkeyA = new TurkeyAdapter(turkey);

        System.out.println("Duck say...");
        testDuck(duck);

        System.out.println("Turkey say...");
        turkey.gobble();
        turkey.fly();

        System.out.println("Adapter say...");
        testDuck(TurkeyA);
    }
    static void testDuck(Duck d){
        d.quack();
        d.fly();
    }
}
