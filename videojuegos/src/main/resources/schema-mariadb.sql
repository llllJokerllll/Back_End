drop table if exists videojuego;
drop table if exists distribuidor;

create table videojuego (
	id int primary key auto_increment,
	nombre varchar(200) not null,
	descripcion varchar(3000),
	imagen_url varchar(500)
);

insert into videojuego
(id,	nombre,					descripcion,																																																																											imagen_url) values 
(1,		'Bioshoc Infinite',		'La última gran entrega de la saga de Bioshock, ahora en una imperdible ciudad de ensueño entre las nubes',																																																				'https://images.g2a.com/newlayout/323x433/1x1x0/8c5bc0939a03/5f9c03df46177c7f412d8fe2'),
(2,		'Control',				'Control es un videojuego de acción-aventura y disparos en tercera persona desarrollado por Remedy Entertainment y distribuido por 505 Games. Fue lanzado el 27 de agosto de 2019 en las plataformas Microsoft Windows, PlayStation 4, Xbox One y Nintendo Switch.',													'https://image.api.playstation.com/vulcan/img/cfn/11307xMxsC9RA7A8rQH4GiePP0BxYP_K8tJU1cWXe4eA189Q0ImmN8eZvJBx91eecK_vHIT2WZrrkqwKfiYvNGIu8NA2zvSV.png'),
(3,		'Escape From Tarkov',	'Escape from Tarkov es un simulador de combate que mezcla acción en primera persona con elementos RPG dentro de un MMO con desarrollo narrativo. También hay quien lo considera un videojuego de suspense debido a la tensión característica de ese juego, semejante a la que provocan juegos de terror o suspense.',	'https://s3.gaming-cdn.com/images/products/2360/orig/escape-from-tarkov-beta-cover.jpg'),
(4,		'League of Legends',	'League of Legends es un videojuego del género multijugador de arena de batalla en línea y deporte electrónico el cual fue desarrollado por Riot Games para Microsoft Windows y OS X y para consolas digitales.',																										'https://www.blizzboygames.net/wp-content/uploads/2018/11/LOL.jpg'),
(5,		'Insurgency: Sandstorm','Un FPS táctico por equipos basado en combates letales en espacios reducidos y multijugador centrado en objetivos',                                                             'https://areajugones.sport.es/wp-content/uploads/2018/06/insurgency-e1528802800327.jpg'),
(6,		'The Witness',          'Te despiertas, a solas, en una extraña isla llena de puzles que te retarán y sorprenderán.',                                                                                   'https://cdn.wccftech.com/wp-content/uploads/2016/11/the-witness-ps4-pro-patch-4k-2060x1288.jpg'),
(7,		'Braid',                'Un juego de rompecabezas con toques plataformeros, donde puedes manipular el flujo del tiempo de unas maneras inusuales y extrañas.',                                          'https://m.media-amazon.com/images/I/51g5LDbFg4L._SY445_.jpg'),
(8,		'Borderlands 3',        '¡Vuelve el padre de los shooter-looter, con tropecientas mil armas y una aventura caótica!',                                                                                   'https://store-images.s-microsoft.com/image/apps.29198.66416288418246547.8db04ed4-6710-424c-b2c7-fc1b8f89e9a2.125b501a-844a-4ec6-86ef-3c46ebf4c698');

create table distribuidor (
	id int primary key auto_increment,
	nombre varchar(200) not null,
	sitio_web varchar(500)
);

insert into distribuidor 
(id,	nombre,								sitio_web) values
(1,		'2k',								'https://2k.com'),
(2,		'Battlestate Games',				'https://www.escapefromtarkov.com/'),
(3,		'Focus Home Interactive',			'https://www.focus-home.com'),
(4,		'Thekla',							null),
(5,		'Number One',						null),
(6,		'505 Games',						'https://505games.com'),
(7,		'Riot',								'https://www.leagueoflegends.com');

alter table videojuego
add column distribuidor_id int, 
add foreign key (distribuidor_id) references distribuidor(id);

update videojuego set distribuidor_id = 1 where id in (1, 8);
update videojuego set distribuidor_id = 2 where id in (3);
update videojuego set distribuidor_id = 3 where id in (5);
update videojuego set distribuidor_id = 4 where id in (6);
update videojuego set distribuidor_id = 5 where id in (7);
update videojuego set distribuidor_id = 6 where id in (2);
update videojuego set distribuidor_id = 7 where id in (4);

alter table videojuego
modify distribuidor_id int not null;
