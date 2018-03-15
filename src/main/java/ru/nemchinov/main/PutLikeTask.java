package ru.nemchinov.main;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class PutLikeTask implements Performable {
    private final PutLikeAction[] actions;

    public PutLikeTask(@Nonnull PutLikeAction[] actions) {
        this.actions = Arrays.copyOf(actions, actions.length);
    }

    public PutLikeAction[] getActions() {
        return actions;
    }
}
