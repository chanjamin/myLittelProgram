package com.example.autoconfig1;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Conditional(GBKCondition.class)
@Component
public class GBKConverter implements Converter {
}
