package ru.nemchinov.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeviceDaoImpl implements DeviceDao {
    private final List<Device> deviceList;

    DeviceDaoImpl() {
        this.deviceList = new ArrayList<>();
        /*Device device1 = new Device(
                1,
                "A3P9K17907901051",
                "6.0",
                100,
                101,
                1,
                new ArrayList<>(
                        Arrays.asList("otmetka_9078", "otmetka_9834", "otmetka_9801", "otmetka_4596", "promoitnnow")
                )
        );*/
        Device device2 = new Device(
                2,
                "A3P9K17A10900610",
                "6.0",
                102,
                103,
                1,
                new String[] {"techacc_0000", "techacc_0001", "techacc_0010", "techacc_0011", "techacc_0100"}
        );
        //deviceList.add(device2);

        Device device3 = new Device(
                3,
                "HT67RBP00559",
                "7.0",
                104,
                105,
                1,
                new String[] {"techacc_0101", "techacc_0110", "techacc_0111", "techacc_1000", "techacc_1001"}
        );
        deviceList.add(device3);
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceList;
    }

    @Override
    public List<Device> getCertainNumberOfDevices(int number) {
        return deviceList.subList(0, number - 1);
    }
}
