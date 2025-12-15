package ia.roadzen.platform.u20231b475.shared.application.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * A component that resolves internationalized messages using a
 * {@link MessageSource}.
 * <p>
 * This class provides a convenient way to retrieve localized messages based on
 * the current locale
 * context, typically for use in user-facing messages or logs.
 * </p>
 *
 * <p>
 * Example usage:
 * 
 * <pre>
 * {@code
 * String message = messageResolver.resolve("greeting.key", "John");
 * }
 * </pre>
 * </p>
 *
 * @author Valentino Solis
 */
@Component
public class MessageResolver {
  private final MessageSource messageSource;

  public MessageResolver(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  public String resolve(String key, Object... args) {
    return messageSource.getMessage(
        key,
        args,
        LocaleContextHolder.getLocale());
  }
}
