public class Application {
    public static void main(final String[] args) {
        Driver me = new Driver("John", 20);
        Car maCar = new Car("Sedan", "Bleu");


        maCar.startCar(me);
        maCar.accelerate();
        me.changeSpeed(maCar,80);
        maCar.slowDown();
        me.changeSpeed(maCar,30);
        maCar.stopCar(me);
        System.out.println("finished");
    }
}
