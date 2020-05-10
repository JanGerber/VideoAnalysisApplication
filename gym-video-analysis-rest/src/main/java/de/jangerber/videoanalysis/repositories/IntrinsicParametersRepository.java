package de.jangerber.videoanalysis.repositories;

import de.jangerber.videoanalysis.entities.IntrinsicParameters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IntrinsicParametersRepository extends JpaRepository<IntrinsicParameters, UUID> {

}
