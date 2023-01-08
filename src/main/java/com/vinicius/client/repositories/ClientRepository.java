package com.vinicius.client.repositories;

import ch.qos.logback.core.net.server.Client;
import com.vinicius.client.model.ClientV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientV1, Long> {
}
