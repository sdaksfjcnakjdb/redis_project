package springIoc.Bean;

import org.springframework.stereotype.Component;

@Component
public class Cat extends Animal{
    public void shout(){
        System.out.println("miao~");
    }
}

