package de.jangerber.videoanalysis.transfer;

import com.google.api.client.util.DateTime;

import java.util.UUID;

public class VideoCreateDTO {
    UUID groupId;
    int duration;
    DateTime startTime;
    String videoFormat;
    UUID idRaspi;

    public UUID getIdRaspi() {
        return idRaspi;
    }

    public void setIdRaspi(UUID idRaspi) {
        this.idRaspi = idRaspi;
    }

    public String getVideoFormat() {
        return videoFormat;
    }

    public void setVideoFormat(String videoFormat) {
        this.videoFormat = videoFormat;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "VideoCreateDTO{" +
                "groupId=" + groupId +
                ", duration=" + duration +
                ", startTime=" + startTime +
                '}';
    }
}
