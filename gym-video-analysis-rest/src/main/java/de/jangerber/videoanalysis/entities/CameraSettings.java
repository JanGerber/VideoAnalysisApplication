package de.jangerber.videoanalysis.entities;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class CameraSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
    private String description;

    private int framerate;
    private int resolutionWidth;
    private int resolutionHeight;
    private boolean cameraLed;

    private String urlVideoStart;
    private String urlVideoStop;
    private String urlImageStart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFramerate() {
        return framerate;
    }

    public void setFramerate(int framerate) {
        this.framerate = framerate;
    }

    public int getResolutionWidth() {
        return resolutionWidth;
    }

    public void setResolutionWidth(int resolutionWidth) {
        this.resolutionWidth = resolutionWidth;
    }

    public int getResolutionHeight() {
        return resolutionHeight;
    }

    public void setResolutionHeight(int resolutionHeight) {
        this.resolutionHeight = resolutionHeight;
    }

    public boolean isCameraLed() {
        return cameraLed;
    }

    public void setCameraLed(boolean cameraLed) {
        this.cameraLed = cameraLed;
    }

    public String getUrlVideoStart() {
        return urlVideoStart;
    }

    public void setUrlVideoStart(String urlVideoStart) {
        this.urlVideoStart = urlVideoStart;
    }

    public String getUrlVideoStop() {
        return urlVideoStop;
    }

    public void setUrlVideoStop(String urlVideoStop) {
        this.urlVideoStop = urlVideoStop;
    }

    public String getUrlImageStart() {
        return urlImageStart;
    }

    public void setUrlImageStart(String urlImageStart) {
        this.urlImageStart = urlImageStart;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
