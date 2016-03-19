public class ChiPizzaStore extends PizzaStore
{
    public Pizza createPizza(String type){
        if(type.equals("cheese")){
            return new ChiCheese();
        } else if(type.equals("pepperoni")){
            return new ChiPepperoni();
        } else if(type.equals("veggie")){
            return new ChiVeggie();
        } else {
            return null;
        }
    }
}
