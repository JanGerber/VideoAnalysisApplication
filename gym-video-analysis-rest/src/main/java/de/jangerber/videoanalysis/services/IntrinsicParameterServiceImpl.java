package de.jangerber.videoanalysis.services;

import de.jangerber.videoanalysis.entities.IntrinsicParameter;
import de.jangerber.videoanalysis.exception.RecordNotFoundException;
import de.jangerber.videoanalysis.repositories.IntrinsicParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IntrinsicParameterServiceImpl implements IntrinsicParameterService {

    @Autowired
    private IntrinsicParameterRepository repo;


    @Override
    public List<IntrinsicParameter> getAllIntrinsicParameterList() {
        return repo.findAll();
    }

    @Override
    public IntrinsicParameter updateIntrinsicParameter(IntrinsicParameter device) {
        return repo.save(device);
    }

    @Override
    public IntrinsicParameter getIntrinsicParameter(UUID id) {
        Optional<IntrinsicParameter> optional = repo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RecordNotFoundException("The intrinsic parameter with the ID '" + id.toString() + "' could not be found.");
    }

    @Override
    public void deleteIntrinsicParameter(UUID id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RecordNotFoundException("The intrinsic parameter with the ID '" + id.toString() + "' could not be found.");
        }
    }

    @Override
    public IntrinsicParameter createIntrinsicParameter(IntrinsicParameter cleaningSchedule) {
        return repo.save(cleaningSchedule);
    }
}
