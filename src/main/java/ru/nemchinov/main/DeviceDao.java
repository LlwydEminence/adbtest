package ru.nemchinov.main;

import java.util.List;

public interface DeviceDao {
    List<Device> getAllDevices();

    List<Device> getCertainNumberOfDevices(int number);
}
