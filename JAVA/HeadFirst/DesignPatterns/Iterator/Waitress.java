public class Waitress
{
    PancakeMenu pancakeM;
    DinerMenu dinerM;

    public Waitress(PancakeMenu pm, DinerMenu dm){
        pancakeM = pm;
        dinerM = dm;
    }
    public void printMenu(){
        Iterator pancakeI = pancakeM.createIterator();
        Iterator dinerI = dinerM.createIterator();
        System.out.println("Menu\n---\nBREAKFAST");
        printMenu(pancakeI);
        System.out.println("\nLUNCH");
        printMenu(dinerI);
    }
    public void printMenu(Iterator i){
        while(i.hasNext()){
            MenuItem item = (MenuItem)i.next();
            System.out.println(item.getName() + ", " + item.getDescription() + ", $" + item.getPrice());
        }
    }
}
