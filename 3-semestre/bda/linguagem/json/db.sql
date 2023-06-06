drop database if exists e_comerce;
create database e_comerce;
use e_comerce;

drop table if exists eventos;
CREATE TABLE eventos
(
    id           int auto_increment primary key,
    nome_evento  varchar(255),
    visitante    varchar(255),
    propriedades json,
    navegador    json
);

INSERT INTO eventos(nome_evento, visitante, propriedades, navegador)
VALUES ('pageview', '1', '{
  "page": "/"
}', '{
  "name": "Safari",
  "os": "Mac",
  "resolution": {
    "x": 1920,
    "y": 1080
  }
}'),
       ('pageview', '2', '{
         "page": "/contact"
       }', '{
         "name": "Firefox",
         "os": "Windows",
         "resolution": {
           "x": 2560,
           "y": 1600
         }
       }'),
       ('pageview', '1', '{
         "page": "/products"
       }', '{
         "name": "Safari",
         "os": "Mac",
         "resolution": {
           "x": 1920,
           "y": 1080
         }
       }'),
       ('purchase', '3', '{
         "amount": 200
       }', '{
         "name": "Firefox",
         "os": "Windows",
         "resolution": {
           "x": 1600,
           "y": 900
         }
       }'),
       ('purchase', '4', '{
         "amount": 150
       }',
        '{
          "name": "Firefox",
          "os": "Windows",
          "resolution": {
            "x": 1280,
            "y": 800
          }
        }'),
       ('purchase', '4',
        '{
          "amount": 500
        }',
        '{
          "name": "Chrome",
          "os": "Windows",
          "resolution": {
            "x": 1680,
            "y": 1050
          }
        }'),
       ('purchase', '1', '{
         "amount": 200
       }',
        '{
          "name": "Safari",
          "os": "Mac",
          "resolution": {
            "x": 1920,
            "y": 1080
          }
        }'),
       ('purchase', '1', '{
         "amount": 300
       }',
        '{
          "name": "Safari",
          "os": "Mac",
          "resolution": {
            "x": 1920,
            "y": 1080
          }
        }');
