package de.jangerber.videoanalysis.transfer;

import com.google.api.client.util.DateTime;

import java.util.UUID;

public class ImageCreateDTO {
    UUID groupId;
    DateTime time;
    String imageFormat;
    int number;
    UUID idRaspi;

    public UUID getIdRaspi() {
        return idRaspi;
    }

    public void setIdRaspi(UUID idRaspi) {
        this.idRaspi = idRaspi;
    }

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }


}
