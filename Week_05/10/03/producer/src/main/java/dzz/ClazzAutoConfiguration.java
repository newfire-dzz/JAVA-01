package dzz;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author dzz
 */

@Configuration
@Import(ClazzBean.class)
public class ClazzAutoConfiguration {
}
