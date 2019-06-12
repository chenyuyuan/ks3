package com.yuan;

import com.yuan.configuration.MyConfiguration;
//import com.yuan.configuration.SecurityConfig;
import com.yuan.configuration.WebMvcConfiguration;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Import;

@Configurable
/*@Import({MyConfiguration.class,SecurityConfig.class})*/
@Import({MyConfiguration.class, WebMvcConfiguration.class})
public class YuanConfiguration {
}
