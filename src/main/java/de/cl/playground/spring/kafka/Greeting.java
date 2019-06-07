package de.cl.playground.spring.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Greeting {

    private String msg;
    private String name;

    @Override
    public String toString() {
        return msg + ", " + name + "!";
    }

}
