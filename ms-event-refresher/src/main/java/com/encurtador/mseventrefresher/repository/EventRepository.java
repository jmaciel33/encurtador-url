package com.encurtador.mseventrefresher.repository;


import com.encurtador.mseventrefresher.domain.Command;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Event repository.
 */
@Repository
public interface EventRepository extends CassandraRepository<Command, String> {
}
