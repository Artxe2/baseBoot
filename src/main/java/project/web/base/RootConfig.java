package project.web.base;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "project.web.backend", "project.web.config", "project.web.socket" })
public class RootConfig {

}
