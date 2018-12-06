package com.example.autoconfig1;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Conditional(UTF8Condition.class)
@Component
public class UTF8Converter implements Converter{
}
