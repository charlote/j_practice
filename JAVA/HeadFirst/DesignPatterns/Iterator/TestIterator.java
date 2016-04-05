public class TestIterator
{
    public static void main(String args[]){
        PancakeMenu pm = new PancakeMenu();
        DinerMenu dm = new DinerMenu();

        Waitress waitress = new Waitress(pm, dm);
        waitress.printMenu();
    }
}
