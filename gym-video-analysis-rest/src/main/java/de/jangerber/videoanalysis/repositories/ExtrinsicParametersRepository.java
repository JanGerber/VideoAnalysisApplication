package de.jangerber.videoanalysis.repositories;

import de.jangerber.videoanalysis.entities.ExtrinsicParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExtrinsicParametersRepository extends JpaRepository<ExtrinsicParameter, UUID> {

}
