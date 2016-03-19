/* for thread pool, cache, the registy */
/* eagerly setup the singleton */

public class Singleton_1
{
    private static Singleton_1 uniqueInstance = new Singleton_1();
    
    private Singleton_1(){}

    public static Singleton_1 getInstance(){
        return uniqueInstance;
    }
}
