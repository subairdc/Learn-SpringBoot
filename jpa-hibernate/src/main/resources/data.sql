insert into course(id, name, creation_date, last_updated_date) values(10001,'Java',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id, name, creation_date, last_updated_date) values(10002,'Spring',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id, name, creation_date, last_updated_date) values(10003,'Hibernate',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id, name, creation_date, last_updated_date) values(10004,'Jpa',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id, name, creation_date, last_updated_date) values(10005,'MySQL',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into passport(id,number) values(30001,'E2401');
insert into passport(id,number) values(30002,'T9875');
insert into passport(id,number) values(30003,'N3342');
insert into passport(id,number) values(30004,'E8798');
insert into passport(id,number) values(30005,'J2344');

insert into student(id,name,passport_id) values(20001,'Subair',30001);
insert into student(id,name,passport_id) values(20002,'Mahir',30002);
insert into student(id,name,passport_id) values(20003,'Aasim',30003);
insert into student(id,name,passport_id) values(20004,'Mohamed',30004);
insert into student(id,name,passport_id) values(20005,'Deen',30005);


insert into review(id,rating,description,course_id) values(40001,'5','Super',10001);
insert into review(id,rating,description,course_id) values(40002,'4','Nice',10003);
insert into review(id,rating,description,course_id) values(40003,'3','Good',10004);
insert into review(id,rating,description,course_id) values(40004,'5','Super',10002);
insert into review(id,rating,description,course_id) values(40005,'4','Nice',10001);

insert into student_course(student_id,course_id) values(20001,10001);
insert into student_course(student_id,course_id) values(20001,10002);
insert into student_course(student_id,course_id) values(20003,10003);
insert into student_course(student_id,course_id) values(20001,10003);