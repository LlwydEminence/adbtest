package ru.nemchinov.main;

import java.util.List;

public class Device {
    public static final int DEFAULT_ACCOUNTS_NUMBER = 5;

    private final int id;
    private final String udid;
    private final String platformVersion;
    private final long serverPort;
    private final long bootstrapPort;
    private final int groupNumber;
    private String[] accounts = new String[DEFAULT_ACCOUNTS_NUMBER];

    public Device(
            int id,
            String udid,
            String platformVersion,
            long serverPort,
            long bootstrapPort,
            int groupNumber,
            String[] accounts
    ) {
        this.id = id;
        this.udid = udid;
        this.platformVersion = platformVersion;
        this.serverPort = serverPort;
        this.bootstrapPort = bootstrapPort;
        this.groupNumber = groupNumber;
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public String getUdid() {
        return udid;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public String[] getAccounts() {
        return accounts;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public long getServerPort() {
        return serverPort;
    }

    public long getBootstrapPort() {
        return bootstrapPort;
    }
}
