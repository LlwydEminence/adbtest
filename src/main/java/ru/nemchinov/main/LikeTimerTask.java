package ru.nemchinov.main;

import javax.annotation.Nonnull;

public class LikeTimerTask {
    String targetAccount;
    int targetAccountGroupNumber;

    public LikeTimerTask(@Nonnull String targetAccount, int targetAccountGroupNumber) {
        this.targetAccount = targetAccount;
        this.targetAccountGroupNumber = targetAccountGroupNumber;
    }

    String getTargetAccount() {
        return targetAccount;
    }

    int getTargetAccountGroupNumber() {
        return targetAccountGroupNumber;
    }
}
