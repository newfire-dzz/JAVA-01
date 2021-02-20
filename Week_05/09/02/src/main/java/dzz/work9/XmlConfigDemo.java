package dzz.work9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dzz
 */

public class XmlConfigDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springApplication.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
        Student dzz = (Student) context.getBean("dzz");
        System.out.println(dzz);
    }
}
