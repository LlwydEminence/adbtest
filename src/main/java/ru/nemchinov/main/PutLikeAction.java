package ru.nemchinov.main;

import javax.annotation.Nonnull;

public class PutLikeAction {
    private final String targetAccount;
    private final int numberOfLikes;

    public PutLikeAction(@Nonnull String targetAccount, int numberOfLikes) {
        this.targetAccount = targetAccount;
        this.numberOfLikes = numberOfLikes;
    }

    public String getTargetAccount() {
        return targetAccount;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }
}
