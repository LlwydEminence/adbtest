package ru.nemchinov.main;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AppiumPutLikeTaskPerformer implements AppiumTaskPerformer<PutLikeTask> {
    private final DeviceDao deviceDao;

    public AppiumPutLikeTaskPerformer(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public void perform(PutLikeTask task) {
        PutLikeAction[] actions = task.getActions();
        int totalNumberOfLikes = 0;

        for (PutLikeAction action : actions) {
            totalNumberOfLikes += action.getNumberOfLikes();
        }

        int requiredNumberOfDevices = (int) Math.ceil(
                (float) totalNumberOfLikes / Device.DEFAULT_ACCOUNTS_NUMBER
        );

        List<Device> deviceList = deviceDao.getCertainNumberOfDevices(requiredNumberOfDevices);
        for (Device device : deviceList) {
            Runnable r = () -> {
                try {
                    InstagramRouter router = createInstagramRouter(device);
                    LinkedList<String> waitedAccounts = new LinkedList<>();
                    waitedAccounts.addAll(Arrays.asList(device.getAccounts()));




                } catch (Exception ex) {
                    System.out.println("Устройство " + device.getUdid() + " не выполнило задачу. " +
                            "Причина: " + ex.getMessage());
                }
            };
        }
    }
}
