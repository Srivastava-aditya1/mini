create database studentss1;
use studentss1;
CREATE TABLE `student1` (
   `Serial_no` int(20) NOT NULL AUTO_INCREMENT,
   `uniroll` int(200) DEFAULT NULL,
   `first_name` varchar(20) DEFAULT NULL,
   `last_name` varchar(20) DEFAULT NULL,
   `username` varchar(250) DEFAULT NULL,
   `password` varchar(20) DEFAULT NULL,
  primary key(`Serial_no`)
);
drop table student1;
SELECT * FROM student1; 




CREATE TABLE `question_table` (
	`question_no` INT(255) NOT NULL AUTO_INCREMENT,
	`question` VARCHAR(500) DEFAULT NULL ,
	PRIMARY KEY (`question_no`)
);
select * from question_table;
drop table question_table;



CREATE TABLE `uploadfile` (
	`uniroll` int(200) DEFAULT NULL,
    `solution` mediumblob,
	PRIMARY KEY (`uniroll`)
);
select * from `uploadfile`;
drop table uploadfile;

select `question` from (
select `uniroll`, `question` 
from student1 natural join question_table
where Serial_no=question_no) as abc
where abc.uniroll=171500021;


