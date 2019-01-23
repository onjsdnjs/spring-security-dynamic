insert  into resources(ID,NAME) values (1,'/user');
insert  into resources(ID,NAME) values (2,'/admin');
insert  into resources(ID,NAME) values (3,'/home');

insert  into role(ROLE_ID,ROLE_NAME) values (1,'ROLE_ADMIN');
insert  into role(ROLE_ID,ROLE_NAME) values (2,'ROLE_DIRECTOR');
insert  into role(ROLE_ID,ROLE_NAME) values (3,'ROLE_MANAGER');
insert  into role(ROLE_ID,ROLE_NAME) values (4,'ROLE_LEADER');
insert  into role(ROLE_ID,ROLE_NAME) values (5,'ROLE_ASSISTANT');
insert  into role(ROLE_ID,ROLE_NAME) values (6,'ROLE_USER');

insert  into role_resource(ID,ROLE_ID,RESOURCE_ID) values (1,1,2);
insert  into role_resource(ID,ROLE_ID,RESOURCE_ID) values (2,2,1);
insert  into role_resource(ID,ROLE_ID,RESOURCE_ID) values (3,1,3);
insert  into role_resource(ID,ROLE_ID,RESOURCE_ID) values (7,2,3);
insert  into role_resource(ID,ROLE_ID,RESOURCE_ID) values (8,6,3);
--insert  into role_resource(ID,ROLE_ID,RESOURCE_ID) values (8,1,1);

--password : wonwoo
insert  into users(ID,USERNAME,PASSWORD) values (1,'wonwoo','$2a$10$qU0G1mvP3m0dKeFXhIVmnOwnshJw99tIPOI78sCyB8b1gHUeqN7YO');
--password : kevin
insert  into users(ID,USERNAME,PASSWORD) values (2,'kevin','$2a$10$02QvKDF8I9cz8aaYayGJ/ufssT8EhCrk5oQ9lggva4rw28/sBSph6');
--password : denied
insert  into users(ID,USERNAME,PASSWORD) values (3,'denied','$2a$10$LNRVEvhgrqmf.xZQsXqAtOwPUuEeryns.J3q8PUSa7H7fclkN2/xO');

insert  into authorities(ID,USER_ID,USER_ROLE) values (1,1,1);
insert  into authorities(ID,USER_ID,USER_ROLE) values (2,2,2);

INSERT INTO ROLE_HIERARCHY(PARENT_ROLE_ID, ROLE_ID, ROLE_NAME) VALUES(NULL, 'ROLE_ADMIN', '시스템 관리자');
INSERT INTO ROLE_HIERARCHY(PARENT_ROLE_ID, ROLE_ID, ROLE_NAME) VALUES('ROLE_ADMIN', 'ROLE_DIRECTOR', '운영자');
INSERT INTO ROLE_HIERARCHY(PARENT_ROLE_ID, ROLE_ID, ROLE_NAME) VALUES('ROLE_DIRECTOR', 'ROLE_MANAGER', '매니저');
INSERT INTO ROLE_HIERARCHY(PARENT_ROLE_ID, ROLE_ID, ROLE_NAME) VALUES('ROLE_MANAGER', 'ROLE_LEADER', '리더');
INSERT INTO ROLE_HIERARCHY(PARENT_ROLE_ID, ROLE_ID, ROLE_NAME) VALUES('ROLE_LEADER', 'ROLE_ASSISTANT', '보조자1');
INSERT INTO ROLE_HIERARCHY(PARENT_ROLE_ID, ROLE_ID, ROLE_NAME) VALUES('ROLE_ASSISTANT', 'ROLE_USER', '일반사용자');