package ru.nemchinov.main;

import org.apache.commons.collections.CollectionUtils;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AppiumSubscribeTaskPerformer implements AppiumTaskPerformer<SubscribeTask> {
    private final DeviceDao deviceDao;

    public AppiumSubscribeTaskPerformer(@Nonnull DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public void perform(SubscribeTask task) {
        List<Device> deviceList = deviceDao.getAllDevices();
        String[] targetAccounts = task.getTargetAccounts();

        for (Device device : deviceList) {
            Runnable r = () -> {
                try {
                    InstagramRouter router = createInstagramRouter(device);
                    LinkedList<String> waitedAccounts = new LinkedList<>();
                    waitedAccounts.addAll(Arrays.asList(device.getAccounts()));

                    do {
                        for (String targetAccount : targetAccounts) {
                            router.goToTargetAccountPage(targetAccount);
                            router.subscribe();
                        }
                    } while (wasAccountChanged(router, waitedAccounts));

                    router.finishWork();
                } catch (Exception ex) {
                    System.out.println("Устройство " + device.getUdid() + " не выполнило задачу. " +
                            "Причина: " + ex.getMessage());
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
