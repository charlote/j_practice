public class Waitress
{
    MenuComponent allMenus;
    public Waitress(MenuComponent allM){
        allMenus = allM;
    }
    public void printMenu(){
        allMenus.print();
    }
}
