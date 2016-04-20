public class TestBeverage
{
    public static void main(String[] args){
        Tea t = new Tea();
        Coff cf = new Coff();

        System.out.println("Make tea...");
        t.prepareRecipe();

        System.out.println("Make Coff...");
        cf.prepareRecipe();
    }
}
