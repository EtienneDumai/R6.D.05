public class Application {
    public static void main(final String[] args) {
        Driver me = new Driver("John", 20);
        Car maCar = new Car("Sedan", "Bleu");


        maCar.startCar(me);
        maCar.accelerate();
        maCar.changeSpeed(maCar,80, me);
        maCar.slowDown();
        maCar.changeSpeed(maCar,30, me);
        maCar.stopCar(me);
        System.out.println("finished");
    }
}
