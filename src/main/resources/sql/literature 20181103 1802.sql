﻿--
-- Скрипт сгенерирован Devart dbForge Studio for MySQL, Версия 8.0.80.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 03.11.2018 18:02:54
-- Версия сервера: 5.7.23-log
-- Версия клиента: 4.1
--

-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

DROP DATABASE IF EXISTS literature_first;

CREATE DATABASE IF NOT EXISTS literature_first
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Установка базы данных по умолчанию
--
USE literature_first;

--
-- Создать таблицу `book`
--
CREATE TABLE IF NOT EXISTS book (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  genre varchar(50) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci,
COMMENT = 'данные книг';

--
-- Создать таблицу `author_book`
--
DROP TABLE IF EXISTS `author_book`;
CREATE TABLE `author_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author_id` bigint(20) NOT NULL,
  `book_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE=INNODB
  DEFAULT CHARSET=utf8
  COMMENT ='соединение 2-х таблиц авторов и книг для их связи';

--
-- Создать таблицу `author`
--
CREATE TABLE IF NOT EXISTS author (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  last_name varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci,
COMMENT = 'данные автора';

-- 
-- Вывод данных для таблицы book
--
INSERT INTO book VALUES
(1, 'Последнее желание', 'фэнтези', 'Сорник рассказов, объединённых общим персонажем — ведьмаком Геральтом из Ривии'),
(2, 'Меч Предназначения', 'фэнтези', 'Сорник рассказов, объединённых общим персонажем — ведьмаком Геральтом из Ривии, второе произведение из цикла «Ведьмак»'),
(3, 'Гиперион', 'фантастика, космическая опера', 'Первая книга тетралогии «Песни Гипериона»'),
(4, 'Падение Гипериона', 'фантастика', 'Вторая книга тетралогии «Песни Гипериона», продолжение романа «Гиперион»'),
(5, 'Бойцовский клуб', 'Роман, контркультура', 'В центре сюжета находится герой, страдающий бессонницей, которая вызвана неприятием общества потребления.'),
(6, 'Невидимки', 'Роман, контркультура', 'Книга, в которой нет содержания'),
(7, 'Танатонавты', 'фантастика, роман', 'В центре сюжета — два человека, с раннего детства заинтересовавшихся смертью, а вернее, тем местом, куда человек после смерти попадает.'),
(8, 'Империя ангелов', 'фантастика, роман', 'Вторая книга в серии «Танатонавты»'),
(9, 'Хирургические болезни том 1', 'медицина, хирургия', 'Содержит историю развития хирургии, методологию постановки диагноза в хирургической клинике, важные синдромы и принципы их лечения'),
(10, 'Хирургические болезни том 2', 'медицина, хирургия', 'В учебнике изложены вопросы этиологии, патогенеза, диагностики и лечения распространенных хирургических заболеваний'),
(11, 'Острый тромбофлебит', 'медицина, флебология', 'Книга посвящена наиболее распространенной острой сосудистой патологии'),
(12, 'Флебология. Руководство для врачей', 'медицина, флебология', 'Руководство содержит данные о патогенезе, диагностике и лечении отдельных заболеваний венозной системы и их осложнений'),
(13, 'Мы — это наш мозг. От матки до Альцгеймера', 'научно-популярная литература', 'Автор, рассматривая жизнь от зарождения до смерти, приводит к выводу, что не человек обладает своим мозгом, а мозг и есть человек.'),
(14, 'Спектр', 'космическая фантастика', 'Роман, рассказывающий о реальном мире, в котором у человечества появилась возможность путешествовать между мирами при помощи порталов. '),
(15, 'Черновик', 'фантастика', 'Книга 1, из дилогии «Работа над ошибками», повествует о мире, насквозь прошитом порталами в иные реальности'),
(16, 'Чистовик', 'фантастика', 'Книга 2 из дилогии «Работа над ошибками», повествует о мире, насквозь прошитом порталами в иные реальности'),
(17, 'Чайка по имени Джонатан Ливингстон', 'повесть-притча', 'Рассказывает о чайке, учившейся жизни и искусству полёта.');

-- 
-- Вывод данных для таблицы author_book
--
INSERT INTO author_book VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 2, 4),
(5, 3, 5),
(6, 3, 6),
(7, 4, 7),
(8, 4, 8),
(9, 5, 9),
(10, 5, 10),
(11, 5, 12),
(12, 6, 9),
(13, 6, 10),
(14, 6, 11),
(15, 6, 12),
(16, 7, 12),
(17, 8, 13),
(18, 9, 14),
(19, 9, 15),
(20, 9, 16),
(21, 10, 17);

-- 
-- Вывод данных для таблицы author
--
INSERT INTO author VALUES
(1, 'Анджей', 'Сапковский'),
(2, 'Дэн', 'Симмонс'),
(3, 'Чак', 'Паланик'),
(4, 'Бернар', 'Вербер'),
(5, 'Виктор', 'Савельев'),
(6, 'Александр', 'Кириенко'),
(7, 'Виктор', 'Гологорский'),
(8, 'Дик Франс', 'Свааб'),
(9, 'Сергей', 'Лукьяненко'),
(10, 'Ричард Дэвид', 'Бах');

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;