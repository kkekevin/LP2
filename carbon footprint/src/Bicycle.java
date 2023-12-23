public class Bicycle implements CarbonFootprint {
    String bicyle = "riding";
    double emissionFactor = 25;

    @Override
    public void getCarbonFootprint() {
        //terrapass calculator
        System.out.println("quantity of co2 riding a conventional bike is: " + emissionFactor);
    }
}
