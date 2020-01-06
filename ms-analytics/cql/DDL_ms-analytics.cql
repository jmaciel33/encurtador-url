CREATE KEYSPACE analytics WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = true;

CREATE TABLE analytics.encurtador (
  short_url text,
  event_date timestamp,
  original_url text,
  PRIMARY KEY (short_url, event_date))

