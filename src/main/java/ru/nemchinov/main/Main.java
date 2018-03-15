package ru.nemchinov.main;

        import java.net.MalformedURLException;

public class Main {
    private static final String TARGET_ACCOUNT = "jamesvega6446";
    private static final int GROUP_NUMBER = 1;
    private static final DeviceDao deviceDao = new DeviceDaoImpl();
    private static final AppiumTaskPerformer<SubscribeTask> sTaskPerformer = new AppiumSubscribeTaskPerformer(deviceDao);
    private static final AppiumTaskPerformer<PutLikeTask> taskPerformer = new AppiumPutLikeTaskPerformer(deviceDao);
    private static final SubscribeTask sTask;
    private static final PutLikeTask task;

    static {
        String[] targetAccounts = new String[] {
                "otmetka_0000",
                "otmetka_0001",
                "otmetka_0010",
                "otmetka_0011",
                "otmetka_0100",
                "otmetka_0101",
                "otmetka_0110",
                "otmetka_0111",
                "otmetka_1000",
                "otmetka_1001"
        };

        PutLikeAction[] actions = new PutLikeAction[targetAccounts.length];
        /*for (int i = 0; i < targetAccounts.length; ++i) {
            actions[i] = new PutLikeAction(targetAccounts[i], 5);
        }*/

        sTask = new SubscribeTask(targetAccounts);
        task = new PutLikeTask(actions);
    }

    public static void main(String[] args) throws MalformedURLException {
        sTaskPerformer.perform(sTask);
    }
}
