package springIoc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springIoc.Bean.User;

public class Mytest {
    @Test
    public void testMethodAutowire() {
        ApplicationContext context = new ClassPathXmlApplicationContext("springIoc.xml");
        User user =  context.getBean(User.class);
        user.getCat().shout();
        user.getDog().shout();

    }
}
