package de.jangerber.videoanalysis.repositories;

import de.jangerber.videoanalysis.entities.IntrinsicParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IntrinsicParameterRepository extends JpaRepository<IntrinsicParameter, UUID> {

}
