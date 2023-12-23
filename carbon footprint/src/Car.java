public class Car implements CarbonFootprint {
    String horn = "horn";
    double emissionFactor = 2.33;

    @Override
    public void getCarbonFootprint() {
        //terrapass calculator
        System.out.println("quantity of co2 per liter is: " + emissionFactor);
    }

}
