package jp.whisper.distributedlock.service;

import net.javacrumbs.shedlock.core.LockConfiguration;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.core.SimpleLock;
import org.springframework.lang.Nullable;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName ShedLockExecutor
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/16 16:39
 * @Version 1.0
 */
public class ShedLockExecutor {
    private final LockProvider lockProvider;

    public ShedLockExecutor(LockProvider lockProvider) {
        this.lockProvider = lockProvider;
    }

    public <T, R> R executeWithLock(Function<T, R> func, @Nullable T t, LockConfiguration configuration) throws Exception {
        Optional<SimpleLock> lock = lockProvider.lock(configuration);
        if (!lock.isPresent()) {
            throw new Exception(String.format("LockAlreadyOccupiedException->%s", configuration.getName()));
        }

        try {
            return func.apply(t);
        } finally {
            lock.get().unlock();
        }
    }

    public <T> T executeWithLock2(Supplier<T> supplier, LockConfiguration configuration) throws Exception {
        Optional<SimpleLock> lock = lockProvider.lock(configuration);
        if (!lock.isPresent()) {
            throw new Exception(String.format("LockAlreadyOccupiedException->%s", configuration.getName()));
        }

        try {
            return supplier.get();
        } finally {
            lock.get().unlock();
        }
    }
}
