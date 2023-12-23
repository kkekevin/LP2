public class Building implements CarbonFootprint {
    String building = "constructing";
    double emissionFactor = 11.7;

    @Override
    public void getCarbonFootprint() {
        System.out.println("the emission factor of natural gas used is: "
        + emissionFactor);
    }
}
