package azovceva.autotests.config.demowebshop;

import org.aeonbits.owner.ConfigFactory;

public class App {
    public static azovceva.autotests.config.demowebshop.AppConfig config = ConfigFactory.create(azovceva.autotests.config.demowebshop.AppConfig.class, System.getProperties());
}
