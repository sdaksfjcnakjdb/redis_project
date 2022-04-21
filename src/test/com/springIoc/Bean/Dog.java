package springIoc.Bean;

import org.springframework.stereotype.Component;

@Component
public class Dog  extends Animal{

    public void shout(){
        System.out.println("wang~");
    }
}
