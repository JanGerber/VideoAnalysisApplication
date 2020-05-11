package de.jangerber.videoanalysis.transfer;

public class DeviceDTO {
    private String id;
    private String name;
    private String ipAddress;

    private String cameraSettings;
    private String intrinsicParameters;

    public String getCameraSettings() {
        return cameraSettings;
    }

    public void setCameraSettings(String cameraSettings) {
        this.cameraSettings = cameraSettings;
    }

    public String getIntrinsicParameters() {
        return intrinsicParameters;
    }

    public void setIntrinsicParameters(String intrinsicParameters) {
        this.intrinsicParameters = intrinsicParameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
