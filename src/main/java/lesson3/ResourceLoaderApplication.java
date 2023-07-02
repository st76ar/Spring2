package lesson3;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

//@SpringBootApplication
public class ResourceLoaderApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        ResourceLoaderService resourceLoaderService = context.getBean("resourceLoaderService", ResourceLoaderService.class);
        resourceLoaderService.showResourceData();
        context.close();
    }
}
