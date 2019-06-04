package com.yuan;

import com.yuan.configuration.MyConfiguration;
import com.yuan.configuration.SecurityConfig;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Import;

@Configurable
@Import({MyConfiguration.class,SecurityConfig.class})
public class DemoConfiguration {
}
