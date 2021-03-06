package es.usal.tfm.lucius.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/stats/total").setViewName("stats_totales");
        registry.addViewController("/stats/costepieza").setViewName("stats_costepieza");
        registry.addViewController("/stats/clientes").setViewName("stats_clientes");
        registry.addViewController("/estimador").setViewName("estimador_web");
    }

}
