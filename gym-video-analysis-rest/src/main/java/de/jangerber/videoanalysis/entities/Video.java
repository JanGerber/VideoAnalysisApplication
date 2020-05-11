package de.jangerber.videoanalysis.entities;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    @Type(type = "uuid-char")
    private UUID groupId;
    @Type(type = "uuid-char")
    private UUID idRaspi;

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public UUID getIdRaspi() {
        return idRaspi;
    }

    public void setIdRaspi(UUID raspiId) {
        this.idRaspi = raspiId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
