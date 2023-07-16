package FileWrappers;

public class ConfigReader {
    public static String PatternURL;

    public static void loadTestConfigurations() {

        PatternURL = PropertiesReader.getValue("dummyUrl");

    }
}
