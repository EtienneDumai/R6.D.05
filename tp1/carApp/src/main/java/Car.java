public class Car {
    private static final int MAX_SPEED = 120;
    private static final int INCREASE_SPEED = 10;
    private static final int DECREASE_SPEED = 10;
    private static final int MINIMAL_SPEED = 0;
    private String model;
    private String color;
    private int speed;

    public Car(final String pModel, final String pColor) {
        this.model = pModel;
        this.color = pColor;
        this.speed = 0;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void accelerate() {
        if (speed + INCREASE_SPEED <= MAX_SPEED) {
            speed += INCREASE_SPEED;
            // afficher détails
            printDetails();
        } else {
            System.out.println("Max speed has been reached.");
        }
    }

    public void slowDown() {
        if (speed - DECREASE_SPEED >= MINIMAL_SPEED) {
            speed -= DECREASE_SPEED;
            // afficher détails
            printDetails();
        } else {
            System.out.println("the car is alreday stopped.");
        }
    }
    public void startCar(final Driver driver) {
        if (driver.isAdult()) {
            System.out.println(driver.getName() + " starting the car.");
        } else {
            System.out.println("The driver does not respect the age limit.");
        }
    }

    public void stopCar(final Driver driver) {
        System.out.println(driver.getName() + " stops the car.");
    }
    public void printDetails() {
        System.out.println("Model : " + model);
        System.out.println("Color : " + color);
        System.out.println("Actual speed : " + speed);
    }
    public void changeSpeed(final Car car, final int newSpeed, final Driver driver) {
        System.out.println(driver.getName() + " change car speed to " + newSpeed);
        int actualSpeed;
        if (car.getSpeed() >= newSpeed) {
            while (car.getSpeed() > newSpeed) {
                car.slowDown();
            }
        } else  {
            while (car.getSpeed() < newSpeed) {
                car.accelerate();
            }
        }
    }
}

