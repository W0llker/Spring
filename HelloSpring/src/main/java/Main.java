import annotation.App;
import annotation.FirstApp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        FirstApp firstApp = applicationContext.getBean(FirstApp.class);
        firstApp.hello();
    }
}
