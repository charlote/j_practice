public class TestCoffeeShop
{
    public static void main(String args[]){
        Beverage bev_1 = new Espresso();
        System.out.println(bev_1.getDescription() + " $" + bev_1.cost());

        Beverage bev_2 = new Whip(new Mocha(new Mocha(new Espresso())));
        System.out.println(bev_2.getDescription() + " $" + bev_2.cost());

        Beverage bev_3 = new Whip(new Mocha(new Soy(new HouseBlend())));
        System.out.println(bev_3.getDescription() + " $" + bev_3.cost());
    }
}
