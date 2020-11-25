package citybikes.api.owner;

import citybikes.api.owner.config.Configurator;
import org.aeonbits.owner.ConfigFactory;

public class ConfigurationProvider {

    private static ConfigurationProvider instance;

    private final Configurator configuration;

    private ConfigurationProvider() {
        configuration = ConfigFactory.newInstance().create(Configurator.class);
    }

    public Configurator getConfiguration() {
        return configuration;
    }

    public static ConfigurationProvider getInstance() {
        if (instance == null) {
            instance = new ConfigurationProvider();
        }
        return instance;
    }
}
