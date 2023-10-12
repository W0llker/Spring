import annotation.App;
import annotation.FirstApp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import xml.TwoApp;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        FirstApp firstApp = applicationContext.getBean(FirstApp.class);
        firstApp.hello();


        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("spring-conf.xml");
        TwoApp twoApp = applicationContext1.getBean("twoApp", TwoApp.class);
        twoApp.hello();
    }
}
