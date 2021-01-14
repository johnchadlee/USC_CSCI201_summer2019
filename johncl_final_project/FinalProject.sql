CREATE DATABASE FinalProject;
USE FinalProject;

CREATE TABLE Users (
	userID INT (11) PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR (100) NOT NULL,
    userPW VARCHAR (100) NOT NULL,
    userEmail VARCHAR (100) NOT NULL,
    userTel VARCHAR (100) NOT NULL
);
CREATE TABLE Class(
   classID int not null auto_increment primary key,
   classTime varchar(20) not null,
   currentNum int(11) not null
) ;
 
CREATE TABLE Record(
   recordID int(11) not null auto_increment primary key,
   userID int(11) not null,
   classID int(11) not null,
   FOREIGN KEY fk_class(classID)
   REFERENCES Class(classID)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
);

CREATE TABLE ContactUs(
	contactID int(11) not null auto_increment primary key,
	guestEmail VARCHAR (100) NOT NULL,
	guestName VARCHAR (100) NOT NULL,
	guestTel VARCHAR (100) NOT NULL,
	guestMsg VARCHAR (1000) NOT NULL
);