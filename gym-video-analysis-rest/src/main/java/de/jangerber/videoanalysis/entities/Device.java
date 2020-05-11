package de.jangerber.videoanalysis.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    private String ipAddress;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camera_settings_id")
    private CameraSettings cameraSettings;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intrinsic_parameter_id")
    private IntrinsicParameter intrinsicParameters;


    public CameraSettings getCameraSettings() {
        return cameraSettings;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.cameraSettings = cameraSettings;
    }

    public IntrinsicParameter getIntrinsicParameters() {
        return intrinsicParameters;
    }

    public void setIntrinsicParameters(IntrinsicParameter intrinsicParameters) {
        this.intrinsicParameters = intrinsicParameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
