drop database if exists test;

create database test;

use test;

CREATE TABLE `tb_person` (
  `id` varchar(36) NOT NULL,
  `name` varchar(125) NOT NULL,
  `sex` int(4) NOT NULL,
  `birth_day` date NOT NULL,
  `created_at` timestamp NOT NULL,
  `updated_at` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
