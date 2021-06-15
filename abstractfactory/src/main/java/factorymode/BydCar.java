package factorymode;

/**
 * 比亚迪汽车
 */
public class BydCar implements Car {
    @Override
    public void run() {
        System.out.println("比亚迪汽车...");
    }
}
