package dzz.geekTime.config;

import org.springframework.context.annotation.Bean;
import dzz.Clazz;

/**
 * @author dzz
 */

public class Config {
    @Bean
    public Clazz clazz() {
        return new Clazz("一班", 45);
    }
}
