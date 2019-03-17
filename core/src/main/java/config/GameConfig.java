package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"study.basecamp"})
@PropertySource("classpath:game.properties")
public class GameConfig {

    @Value("${maxNumber}")
    int maxNumber;

    @Value("${minNumber}")
    int minNumber;

    @Value("${guessCount}")
    int guessCount;

    @Bean
    public int maxNumber(){ return maxNumber; }

    @Bean
    public int minNumber(){ return minNumber; }

    @Bean
    public int guessCount(){
        return guessCount;
    }

}
