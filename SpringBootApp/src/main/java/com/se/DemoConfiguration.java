package com.se;

import com.se.configuration.MyConfiguration;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Import;

@Configurable
@Import(MyConfiguration.class)
public class DemoConfiguration {
}
