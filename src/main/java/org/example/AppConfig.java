package org.example;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {
    public AppConfig(){
        // endereço em que a classe do endpoint está
        packages("org.example");
        register(JacksonFeature.class);
    }
}
