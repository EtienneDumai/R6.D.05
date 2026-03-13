public class Driver {
    private static final int MINIMUM_AGE_ADULT = 10;
    private  String name;

    private int age;

    public Driver(final String pName, final int years) {
        this.name = pName;
        this.age = years;
    }
    public String getName (){
        return this.name;
    }
    public boolean isAdult() {
        return age >= MINIMUM_AGE_ADULT;
    }



}
