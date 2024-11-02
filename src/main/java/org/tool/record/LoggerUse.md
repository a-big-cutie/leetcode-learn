# 使用 Logger 记录日志  
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyService {
    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    public void performAction() {
        logger.info("Starting action...");
        try {
            // 执行某些操作
            logger.debug("Action is being performed.");
            // 模拟一个异常
            throw new RuntimeException("An error occurred!");
        } catch (Exception e) {
            logger.error("An error occurred while performing action", e);
        }
        logger.info("Action completed.");
    }
}
```  
1. 日志来源：
   * Logger：日志会自动显示来源类的信息，例如：MyService - Starting action...
   * System.out.println：没有来源信息，只会显示文本，例如：Starting action...

2. 日志级别：
   * Logger：可以使用不同的日志级别（如 info、debug、error），可以通过配置文件轻松调整输出的日志级别。
   * System.out.println：所有信息都是输出到标准输出，没有日志级别的概念，无法控制输出。

3. 异常处理：
   * Logger：通过 logger.error("message", e) 可以方便地记录异常信息，包含堆栈跟踪。
   * System.out.println：需要手动调用 e.printStackTrace()，并且没有上下文信息。

4. 配置管理：
   * Logger：可以通过配置文件（如 logback.xml 或 log4j.properties）轻松调整日志格式、输出位置和级别。
   * System.out.println：无法配置，输出到控制台，且格式固定。

5. 性能优化：
   * Logger：在较高的日志级别下，低级别日志（如 debug、trace）不会被处理，从而提高性能。
   * System.out.println：每次调用都会执行，没有性能优化。