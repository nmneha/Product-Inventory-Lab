import Services.CakeService;
import Services.IceCreamService;

public class App {
    private CakeService cakeService = new CakeService();
    private IceCreamService iceCreamService = new IceCreamService();

    public static void main(String... args){
        App application = new App();
        application.init();

    }

    private void init() {
    }
}
