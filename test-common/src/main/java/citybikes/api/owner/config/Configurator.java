package citybikes.api.owner.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

//@Sources({"classpath:env/${env}.properties"})
@Sources({"classpath:env/qa1.properties"})
public interface Configurator extends Config {

    @Key("citybikes.base_url")
    String baseUrl();

    @Key("citybikes.base_path")
    String basePath();

}
