package in.rahulbagchi.spring;

import in.rahulbagchi.spring.game.GameRunner;
import in.rahulbagchi.spring.game.Mario;
import in.rahulbagchi.spring.game.PackMan;
import in.rahulbagchi.spring.game.SuperContra;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class LearningSpringBootApplication {

	public static void main(String[] args) {
//		SpringApplication.run(LearningSpringBootApplication.class, args);
//        var game = new Mario();
//        var game = new SuperContra();
//        var game = new PackMan();
//        var runner = new GameRunner(game);
//        runner.run();


        // context creates configuration and manages its lifecycle
        var context = new AnnotationConfigApplicationContext(ConfigurationBasic.class);

        // list all beans
        System.out.println("====== beans ======");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println); // get names of all beans in the context
        System.out.println("===================");

        // two ways of getting bean value is
        // by name: getBean("bean-name")
        // by type: getBean(BeanType.class)

        System.out.println("name="+context.getBean("name"));

        System.out.println("age="+context.getBean("age"));

        System.out.println("person="+context.getBean("person"));

        System.out.println("primary person="+context.getBean(Person.class));

        System.out.println("office address="+context.getBean("officeAddress"));

        System.out.println("home address="+context.getBean("homeAddress"));
	}

}
