package factorymode;

public class Client {
    public static void main(String[] args) {
        CarFactory carFactory = new BydFactory();
        Car car = carFactory.createCar("比亚迪");
        car.run();
        JiLiFactory jiLiFactory = new JiLiFactory();
        Car jiLiCar = jiLiFactory.createCar("吉利");
        jiLiCar.run();
    }
}
