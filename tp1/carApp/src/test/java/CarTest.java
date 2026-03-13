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
    private Driver me;

    @BeforeEach
    public void setUp() {
        car = new Car("Sedan", "Bleu");
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
    @Test
    public void testAccelerate() {
        car.accelerate();
        assertThat(car.getSpeed()).isEqualTo(10);
    }

    @Test
    public void testSlowDown() {
        car.accelerate();
        car.slowDown();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    public void testStartCar() {
        Car car = new Car("Sedan", "Bleu");
        Driver me = new Driver("John", 25);
        car.startCar(me);
        // How to assert that the demarrerVoiture method was called?
    }

    @Test
    public void testStopCar() {
        Car car = new Car("Sedan", "Bleu");
        Driver me = new Driver("John", 25);
        car.stopCar(me);
        // How to assert that the arreterVoiture method was called?
    }

    @Test
    public void testChangeSpeed() {
        Car car = new Car("Sedan", "Bleu");
        Driver me = new Driver("John", 25);

        car.changeSpeed(car, 80, me);
        assertThat(car.getSpeed()).isEqualTo(80);
    }

    @Test
    public void testMaxSpeed() {
        Car car = new Car("Sedan", "Bleu");
        Driver me = new Driver("John", 25);
        car.changeSpeed(car, 200, me);
        assertThat( outputStreamCaptor.toString()
                .trim()).contains("Max speed has been reached.");
    }
}
