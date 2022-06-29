create table category (
  id int not null,
  name varchar(20) not null,

  primary key (id)
);

create table book (
  id int not null,
  category_id int not null,
  name varchar(100) not null,
  author varchar(100) not null,
  price int not null,
  comment varchar(3000),

  primary key (id),

  foreign key (category_id) references category (id)
    on update no action
    on delete no action
);

insert into category values
(0, '小説');
insert into category values
(1, 'コミック');

insert into book values
(0, 0, 'すべてが始まる朝に', '上野蓮子', 550, '天然真面目マニュアル男 vs 美人上司! 新人必見のラブコメディ');
insert into book values
(1, 0, '日影-白金の鳳鳥', '祐太', 600, '白金の最強の剣と魔法。旅の先に訪れる恐怖と爽快アドベンチャー');
insert into book values
(2, 1, 'シルバーカグラ', '乃田サトシ', 420, '狩る!食べる!!戦う!!!南の大海原で繰り広げる爽快エンターテイメント');
INSERT into book values
(3, 1, '後退の小人', '磯山成', 420, '人類が持て余したのは幸福と希望。すべてを手に入れた人類の100年後を描く');
