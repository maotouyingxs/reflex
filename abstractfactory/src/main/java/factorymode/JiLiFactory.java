package factorymode;

/**
 * 吉利汽车4S店销售
 */
public class JiLiFactory implements CarFactory {
    @Override
    public Car createCar(String name) {
        return new JiliCar();
    }
}
