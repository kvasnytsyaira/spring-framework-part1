package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import study.basecamp.GameImpl;
import study.basecamp.NumberGeneratorImpl;

@Configuration
@ComponentScan(basePackages = {"study.basecamp"})
public class JavaConfig {

    @Bean(name = "numberGenerator")
    public NumberGeneratorImpl numberGenerator() {
        NumberGeneratorImpl numberGenerator = new NumberGeneratorImpl();
        return numberGenerator;
    }

    @Bean (name = "game")
    public GameImpl gameImpl(){
        GameImpl gameImpl = new GameImpl();
        return gameImpl;
    }



}
