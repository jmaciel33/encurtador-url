package com.encurtador.msanalytics.repository;


import com.encurtador.msanalytics.domain.Read;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Event repository.
 */
@Repository
public interface EventRepository extends CassandraRepository<Read, String> {
}
