> CREATE TABLE `messages` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `text` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
> CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user (id,name) values (1,'鈴木');
insert into user (id,name) values (2,'佐藤');
insert into messages (id,userid,name) values (1,1,'こんにちは');
insert into messages (id,userid,name) values (2,2,'掲示板へようこそ');
insert into messages (id,userid,name) values (3,1,'よろしくお願いします');
insert into messages (id,userid,name) values (4,2,'こちらこそ');