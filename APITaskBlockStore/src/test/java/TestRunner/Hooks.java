package TestRunner;

import FileWrappers.ConfigReader;
import io.cucumber.java.Before;

public class Hooks   {
    @Before(order = 1)
    public  void initialization() {

        ConfigReader.loadTestConfigurations();
    }
}
