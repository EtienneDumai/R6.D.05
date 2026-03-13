import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private Car car;
    private Driver driver;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        car = new Car("Sedan", "Bleu");
        driver = new Driver("John", 25);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void givenNewCar_whenCreated_thenSpeedIsZero() {
        // GIVEN
        Car car = new Car("Sedan", "Bleu");

        // WHEN
        int speed = car.getSpeed();

        // THEN
        assertThat(speed).isEqualTo(0);
    }

    @Test
    void givenCarStopped_whenAccelerate_thenSpeedBecomes10() {
        // GIVEN
        Car car = new Car("Sedan", "Bleu");

        // WHEN
        car.accelerate();

        // THEN
        assertThat(car.getSpeed()).isEqualTo(10);
    }

    @Test
    void givenCarAt10_whenSlowDown_thenSpeedBecomes0() {
        // GIVEN
        car.accelerate();

        // WHEN
        car.slowDown();

        // THEN
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void givenCarStopped_whenSlowDown_thenMessageDisplayed() {
        // GIVEN
        Car car = new Car("Sedan", "Bleu");

        // WHEN
        car.slowDown();

        // THEN
        assertThat(outputStreamCaptor.toString())
                .contains("the car is alreday stopped.");
    }

    @Test
    void givenAdultDriver_whenStartCar_thenCarStarts() {
        // GIVEN
        Driver driver = new Driver("John", 25);

        // WHEN
        car.startCar(driver);

        // THEN
        assertThat(outputStreamCaptor.toString())
                .contains("John starting the car.");
    }

    @Test
    void givenMinorDriver_whenStartCar_thenRefused() {
        // GIVEN
        Driver youngDriver = new Driver("Tom", 7);

        // WHEN
        car.startCar(youngDriver);

        // THEN
        assertThat(outputStreamCaptor.toString())
                .contains("The driver does not respect the age limit.");
    }

    @Test
    void givenDriver_whenStopCar_thenStopMessageDisplayed() {
        // GIVEN
        Driver driver = new Driver("John", 25);

        // WHEN
        car.stopCar(driver);

        // THEN
        assertThat(outputStreamCaptor.toString())
                .contains("John stops the car.");
    }

    @Test
    void givenCarStopped_whenChangeSpeedTo80_thenSpeedIs80() {
        // GIVEN
        int newSpeed = 80;

        // WHEN
        car.changeSpeed(newSpeed, driver);

        // THEN
        assertThat(car.getSpeed()).isEqualTo(80);
    }

    @Test
    void givenCarAt80_whenChangeSpeedTo40_thenSpeedIs40() {
        // GIVEN
        car.changeSpeed(80, driver);

        // WHEN
        car.changeSpeed(40, driver);

        // THEN
        assertThat(car.getSpeed()).isEqualTo(40);
    }

    @Test
    void givenCarAt110_whenAccelerate_thenSpeedIs120() {
        // GIVEN
        car.changeSpeed(110, driver);

        // WHEN
        car.accelerate();

        // THEN
        assertThat(car.getSpeed()).isEqualTo(120);
    }

    @Test
    void givenCarAtMaxSpeed_whenAccelerate_thenMessageDisplayed() {
        // GIVEN
        car.changeSpeed(120, driver);
        outputStreamCaptor.reset();

        // WHEN
        car.accelerate();

        // THEN
        assertThat(outputStreamCaptor.toString())
                .contains("Max speed has been reached.");
    }

    @Test
    void givenCar_whenPrintDetails_thenModelColorAndSpeedPrinted() {
        // GIVEN
        Car car = new Car("Sedan", "Bleu");

        // WHEN
        car.printDetails();

        // THEN
        assertThat(outputStreamCaptor.toString())
                .contains("Model : Sedan")
                .contains("Color : Bleu")
                .contains("Actual speed : 0");
    }

    @Test
    void givenDriver_whenChangeSpeed_thenDriverNamePrinted() {
        // GIVEN
        Driver driver = new Driver("John", 25);

        // WHEN
        car.changeSpeed(50, driver);

        // THEN
        assertThat(outputStreamCaptor.toString())
                .contains("John change car speed to 50");
    }
}