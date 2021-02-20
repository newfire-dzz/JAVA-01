package dzz.work9;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author dzz
 */

@Component
public class AnnotationsConfig {

    @Bean
    public Student student() {
        return new Student(1, "dzz", "5班");
    }
}
