CREATE KEYSPACE encurtador WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = true;

CREATE TABLE encurtador.short_url (
  short_url text,
  original_url text,
  PRIMARY KEY (short_url)
)

INSERT INTO ms_encurtador_url.es_encurtador(url, origal_url, event_status, event_date)
VALUES('teste', 'http://xablau', 'SENT','2017-05-02 17:33:03');

SELECT * FROM ms_encurtador_url.es_envent_test WHERE url='teste';