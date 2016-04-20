public abstract class CaffBeverage
{
    final void prepareRecipe(){
        boilWater();
        brew();
        pourIncup();
        if(customerCondiments()){
            addCondiments();
        }
    }
    
    void boilWater(){
        System.out.println("Boiling Water");
    }
    
    abstract void brew();
    
    void pourIncup(){
        System.out.println("Pouring into cup");
    }

    abstract void addCondiments();
    
    boolean customerCondiments(){
        return true;
    }
}
