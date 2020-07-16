package jp.whisper.distributedlock.config;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

import java.util.Map;

/**
 * @ClassName MdcTaskDecorator
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/16 17:02
 * @Version 1.0
 */
public class MdcTaskDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {
        // (Grab the current thread MDC data)
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        return () -> {
            try {
                // (Restore the Web thread context's MDC data)
                MDC.setContextMap(contextMap);
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
}
