import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<CarbonFootprint> carbonFP = new ArrayList<>();
        Bicycle bicycle = new Bicycle();
        Car car = new Car();
        Building building = new Building();
        carbonFP.add(bicycle);
        carbonFP.add(car);
        carbonFP.add(building);
        for (CarbonFootprint i : carbonFP) {
            i.getCarbonFootprint();
        }
    }
}
