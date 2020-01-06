package com.encurtador.mseventstore.repository;


import com.encurtador.mseventstore.domain.Command;
import com.encurtador.mseventstore.domain.CommandKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CassandraRepository<Command, CommandKey> {
}
