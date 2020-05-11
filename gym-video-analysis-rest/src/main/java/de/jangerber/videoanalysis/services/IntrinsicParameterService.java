package de.jangerber.videoanalysis.services;

import de.jangerber.videoanalysis.entities.IntrinsicParameter;

import java.util.List;
import java.util.UUID;

public interface IntrinsicParameterService {
    List<IntrinsicParameter> getAllIntrinsicParameterList();

    IntrinsicParameter updateIntrinsicParameter(IntrinsicParameter device);

    IntrinsicParameter getIntrinsicParameter(UUID id);

    void deleteIntrinsicParameter(UUID id);

    IntrinsicParameter createIntrinsicParameter(IntrinsicParameter device);

}
