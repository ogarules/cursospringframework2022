package com.example.demo.ejercicio21.methodinjection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("stringProcessor")
@Scope("prototype")
public class StringProcessor implements IProcessor {
    @Override
    public String processData(String data, Integer iterations) {
        log.info("StringProcessor id [{}]: processing data ...", super.hashCode());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < iterations; i++) {
            sb.append(reverseString(data));
            if (i < iterations - 1)
                sb.append("\n");
        }

        return sb.toString();
    }
    
    public static String reverseString(String input) {
		StringBuilder backwards = new StringBuilder();
		for (int i = 0; i < input.length(); i++)
			backwards.append(input.charAt(input.length() - 1 - i));
		return backwards.toString();
	}
}
