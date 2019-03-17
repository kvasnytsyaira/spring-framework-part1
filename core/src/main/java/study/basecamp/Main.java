package study.basecamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static study.basecamp.Scan.inputAnswer;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        while (inputAnswer()) {
            log.info("GUESS NUMBER GAME");
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("config");
            Game game = context.getBean(Game.class);
            game.startGame();
            context.close();
        }
    }
}
