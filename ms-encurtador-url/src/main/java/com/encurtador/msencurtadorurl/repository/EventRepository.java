package com.encurtador.msencurtadorurl.repository;

import com.encurtador.msencurtadorurl.domain.Command;
import com.encurtador.msencurtadorurl.domain.CommandKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface EventRepository extends CassandraRepository<Command, CommandKey> {
}
