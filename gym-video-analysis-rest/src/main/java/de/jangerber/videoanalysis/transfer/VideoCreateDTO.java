package de.jangerber.videoanalysis.transfer;

import java.util.UUID;

public class VideoCreateDTO {
    UUID groupId;

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }
}
