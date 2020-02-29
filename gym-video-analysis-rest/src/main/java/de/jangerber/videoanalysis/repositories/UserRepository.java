package de.jangerber.videoanalysis.repositories;

import de.jangerber.videoanalysis.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Customer, UUID> {
    Customer findByUsername(String userName);
}
