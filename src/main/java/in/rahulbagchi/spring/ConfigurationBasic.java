package in.rahulbagchi.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Java record (Java 16+) = Kotlin data class

record Person(String name, int age) {}

record Address(String street, String city) {}

/**
 * Java Beans / Enterprise Java Beans (EJB)
 * = POJO + no arg constructor + Serializable interface + getter and setter
 *
 * Spring Beans = POJOs, created and lifecycle managed by Spring Container
 *
 * Container = creates, injects, manages lifecycle of beans.
 *  types:
 *  Bean Factory
 *  ApplicationContext
 */

@Configuration
public class ConfigurationBasic {

    // Bean are method in @Configuration

    @Bean
    public String name() {
        return "Rahul";
    }

    @Bean
    public int age() {
        return 28;
    }

    @Bean
    public Person person() {
        return new Person("Ratul",29);
    }

    // here Bean use other Bean from the same @Configuration as parameter
    // NOTE: the parameter name must be same as Bean name
    @Bean
    // when we try to getBean by type (ex: getBean(Person.class) ) and there are multiple beans with same type,
    // Spring will confuse which to use and throw exception. Therefore, @Primary annotation ensures that use that
    // bean when such conflict arise
    @Primary
    public Person personViaParameter(String name, int age) {
        return new Person(name,age);
    }

    @Bean
    // when passing bean as parameter i can also pass a particular bean by specifying the Qualifier
    // see address street parameters
    @Qualifier("streetOffice")
    public String street1() {
        return "Nandalal Basu Sarani";
    }

    @Bean
    @Qualifier("streetHome")
    public String street2() {
        return "Chowringhee Road";
    }

    // NOTE: when Bean name given, then use this name in context.getBean instead of method name

    @Bean("officeAddress")
    public Address addressOfOffice(@Qualifier("streetOffice") String street) {
        return new Address(street, "Sector V");
    }

    @Bean("homeAddress")
    public Address addressOfHome(@Qualifier("streetHome")String street) {
        return new Address(street, "Sealdah");
    }
}
