CREATE SCHEMA IF NOT EXISTS utmn;

CREATE TABLE utmn.user_event (
  id          BIGSERIAL PRIMARY KEY,
  event_type  TEXT NOT NULL,
  event_time  TIMESTAMPTZ NOT NULL
);

CREATE INDEX idx_userevent_time ON utmn.user_event(event_time);
CREATE INDEX idx_userevent_type ON utmn.user_event(event_type);

COMMENT ON TABLE utmn.user_event IS 'Таблица для хранения информации событиях пользователей';

COMMENT ON COLUMN utmn.user_event.event_type IS 'Тип события';
COMMENT ON COLUMN utmn.user_event.event_time IS 'Время наступления события';
