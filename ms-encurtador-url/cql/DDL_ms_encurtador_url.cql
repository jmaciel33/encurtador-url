CREATE KEYSPACE ms_encurtador_url WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = true;

CREATE TABLE ms_encurtador_url.es_encurtador (
  short_url text,
  original_url text,
  event_action text,
  event_status text,
  event_date timestamp,
  PRIMARY KEY (short_url, event_date)
) WITH CLUSTERING ORDER BY (event_date DESC)