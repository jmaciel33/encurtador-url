package com.encurtador.msanalytics.repository;


import com.encurtador.msanalytics.domain.Read;
import com.encurtador.msanalytics.domain.ReadKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.awt.print.Pageable;
import java.util.List;

/**
 * The interface Event repository.
 */
@Repository
public interface EventRepository extends CassandraRepository<Read, ReadKey> {

    List<Read> findByReadKeyShortUrl(final String shortUrl);
}
