CREATE KEYSPACE encurtador WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = true;

CREATE TABLE encurtador.short_url (
  short_url text,
  original_url text,
  PRIMARY KEY (short_url))