package com.david.tutoriales;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.david.tutoriales.config.DbConfig;
import com.david.tutoriales.config.DbConfigHistoricos;

@Configuration
@ComponentScan({ "com.david.tutoriales.services","com.david.tutoriales.persistencia" })
@Import({ DbConfig.class, DbConfigHistoricos.class })
public class AppTestConfig {

}
