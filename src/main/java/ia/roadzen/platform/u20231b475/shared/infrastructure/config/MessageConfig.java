package ia.roadzen.platform.u20231b475.shared.infrastructure.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Configuration class for setting up the application's message source.
 * <p>
 * Defines a {@link MessageSource} bean using
 * {@link ResourceBundleMessageSource}
 * with the base name "messages" and UTF-8 encoding. This enables
 * internationalization
 * and externalization of messages for the application.
 * </p>
 */
@Configuration
public class MessageConfig {
  @Bean
  public MessageSource messageSource() {
    var source = new ResourceBundleMessageSource();
    source.setBasename("messages");
    source.setDefaultEncoding("UTF-8");
    return source;
  }
}
