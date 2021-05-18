insert into subject (subject_id,subject_code, title, credit) values (1,'INT101', 'Computer Programming I', 1);
insert into subject (subject_id,subject_code, title, credit) values (2,'INT102', 'Computer Programming 2', 2);
insert into subject (subject_id,subject_code, title, credit) values (3,'INT103', 'Computer Programming 3', 3);
insert into subject (subject_id,subject_code, title, credit) values (4,'INT104', 'Computer Programming 4', 4);
insert into subject (subject_id,subject_code, title, credit) values (5,'INT105', 'Computer Programming 5', 5);

insert into student values (10001, 'Somchai');
insert into student values (10002, 'Somsak');
insert into student values (10003, 'Somsri');
insert into student values (10004, 'Somjit');
insert into student values (10005, 'Somkid');
insert into student values (10006, 'Somporn');

insert into student_grade (grade_id,student_id, subject_id, grade) values(1,10001, 1, 3.5);
insert into student_grade (grade_id,student_id, subject_id, grade) values(2,10001, 3, 2.5);
insert into student_grade (grade_id,student_id, subject_id, grade) values(3,10001, 4, 4);

insert into student_grade (grade_id,student_id, subject_id, grade) values(4,10002, 1, 2.5);
insert into student_grade (grade_id,student_id, subject_id, grade) values(5,10002, 5, 2.0);

insert into student_grade (grade_id,student_id, subject_id, grade) values(6,10003, 1, 2.5);

insert into student_grade (grade_id,student_id, subject_id, grade) values(7,10004, 1, 3.5);

insert into student_grade (grade_id,student_id, subject_id, grade) values(8,10005, 1, 3.0);
insert into student_grade (grade_id,student_id, subject_id, grade) values(9,10005, 2, 4.0);
