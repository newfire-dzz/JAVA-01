package dzz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dzz
 */

@Configuration
public class ClazzBean {

    @Bean
    public Clazz clazz() {
        return new Clazz("未分配", 40);
    }

}
