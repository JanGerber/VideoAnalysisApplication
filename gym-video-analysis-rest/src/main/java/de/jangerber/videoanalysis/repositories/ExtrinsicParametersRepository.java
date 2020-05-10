package de.jangerber.videoanalysis.repositories;

import de.jangerber.videoanalysis.entities.ExtrinsicParameters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExtrinsicParametersRepository extends JpaRepository<ExtrinsicParameters, UUID> {

}
