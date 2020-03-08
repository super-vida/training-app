package cz.prague.vida.training;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Main {
    public static void main(String[] args) throws Exception {
    	
    	
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        try (SeContainer container = initializer.disableDiscovery()
                .addBeanClasses(TrainingApp.class, TrainingParser.class, org.slf4j.Logger.class).initialize()) {

        	TrainingApp trainingApp = container.select(TrainingApp.class).get();
            trainingApp.run();
        }
    }
}
