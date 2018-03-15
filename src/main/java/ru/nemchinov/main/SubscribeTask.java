package ru.nemchinov.main;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class SubscribeTask implements Performable {
    private final String[] targetAccounts;

    public SubscribeTask(
            @Nonnull String[] targetAccounts
    ) {
        this.targetAccounts = Arrays.copyOf(targetAccounts, targetAccounts.length);
    }

    public String[] getTargetAccounts() {
        return targetAccounts;
    }
}
