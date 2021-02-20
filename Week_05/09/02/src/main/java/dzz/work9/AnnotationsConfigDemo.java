package dzz.work9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dzz
 */

public class AnnotationsConfigDemo {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("dzz.work9");
        Student dzz = (Student) context.getBean("student");
        System.out.println(dzz);
    }
}
