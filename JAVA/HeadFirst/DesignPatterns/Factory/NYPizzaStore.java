public class NYPizzaStore extends PizzaStore
{
    public Pizza createPizza(String type){
        if(type.equals("cheese")){
            return new NYCheese();
        } else if(type.equals("pepperoni")){
            return new NYPepperoni();
        } else if(type.equals("veggie")){
            return new NYVeggie();
        } else {
            return null;
        }
    }
}
