package springIoc.Bean;

import org.springframework.stereotype.Component;

@Component
public class Animal {
    public void shout(){
        System.out.println("叫");
    }
    public void eat(){
        System.out.println("eating...");
    }
}
