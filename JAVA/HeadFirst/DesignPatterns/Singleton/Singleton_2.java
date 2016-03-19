/* for thread pool, cache, the registy */
/* double-checked locking */

public class Singleton_2
{
    private volatile static Singleton_2 uniqueInstance;
    
    private Singleton_2(){}

    public static Singleton_2 getInstance(){
        if(uniqueInstance == null){
            synchronized(Singleton_2.class){
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton_2();
                }
            }
        }
        return uniqueInstance;
    }
}
