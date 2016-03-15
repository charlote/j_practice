/* the announce way of generic in method:
 * public <T extends Animal> void takeAnimal(ArrayList<T> l){}
 * public void takeAnimal(ArrayList<? extends Animal> l){}
 */
import java.util.*;

public class TestGenericA
{
    public static void main(String[] args){
        new TestGenericA().go();
    }
    public void go(){
        ArrayList<Animal> ans = new ArrayList<Animal>();
        ans.add(new Dog());
        ans.add(new Dog());
        ans.add(new Cat());

        takeAnimal(ans);
    }
    public void takeAnimal(ArrayList<? extends Animal> animals){
        for(Animal a: animals){
            a.eat();
        }
    }

    abstract class Animal
    {
        public void eat(){
            System.out.println("animal eat!!!");
        }
    }
    class Dog extends Animal
    {
        @Override
            public void eat(){
                System.out.println("dog eat!!!");
            }
        public void bark(){}
    }
    class Cat extends Animal
    {
        @Override
            public void eat(){
                System.out.println("cat eat!!!");
            }
        public void meow(){}
    }
}
