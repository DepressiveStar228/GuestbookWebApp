package sumdu.edu.ua.web.mail;

import freemarker.template.TemplateExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailFreemarkerConfig {
    @Bean(name = "emailFreemarkerConfiguration")
    public freemarker.template.Configuration emailFreemarkerConfiguration() {
        freemarker.template.Configuration cfg =
                new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_32);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setClassLoaderForTemplateLoading(
                getClass().getClassLoader(),
                "templates/email"
        );
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        return cfg;
    }
}
