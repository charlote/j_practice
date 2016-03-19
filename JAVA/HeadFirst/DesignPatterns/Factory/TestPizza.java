public class TestPizza
{
    public static void main(String[] args){
        PizzaStore NY = new NYPizzaStore();
        PizzaStore Chi = new ChiPizzaStore();

        Pizza pizza = NY.orderPizza("cheese");
        System.out.println("order cheese");
        pizza = Chi.orderPizza("pepperoni");
        System.out.println("order pepperoni");
    }
}
