package com.encurtador.msurlread.repository;


import com.encurtador.msurlread.domain.ShortURL;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortURLRepository extends CassandraRepository<ShortURL, String> {
}
