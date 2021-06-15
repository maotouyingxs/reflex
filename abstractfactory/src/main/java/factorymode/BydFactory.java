package factorymode;

/**
 * 比亚迪汽车4S店销售
 */
public class BydFactory implements CarFactory {
    @Override
    public Car createCar(String name) {
        return new BydCar();
    }
}
