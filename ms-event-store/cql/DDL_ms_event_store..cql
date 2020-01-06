CREATE KEYSPACE ms_event_store WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = true;

CREATE TABLE ms_event_store.event_store (
  short_url text,
  original_url text,
  event_action text,
  event_date timestamp,
  PRIMARY KEY (short_url, event_date)
) WITH CLUSTERING ORDER BY (event_date DESC);

INSERT INTO ms_encurtador_url.es_encurtador(url, origal_url, event_status, event_date)
VALUES('teste', 'http://xablau', 'SENT','2017-05-02 17:33:03');

SELECT * FROM ms_encurtador_url.es_envent_test WHERE url='teste';