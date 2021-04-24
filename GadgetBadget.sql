CREATE DATABASE gadgetbadgetdb;

CREATE TABLE `fundingbody` (
`Id` int(11) NOT NULL,
`Name` varchar(40) DEFAULT NULL,
`Telno` int(11) DEFAULT NULL,
`Companyname` varchar(45) DEFAULT NULL,
`Companyaddress` varchar(45) DEFAULT NULL,
`Email` varchar(30) DEFAULT NULL,
PRIMARY KEY (`Id`)
);

CREATE TABLE `gadgetbadgetdb`.`buyer` (
`id` INT NOT NULL,
`name` VARCHAR(45) NULL,
`telno` INT NULL,
`address` VARCHAR(150) NULL,
`companyname` VARCHAR(45) NULL,
`email` VARCHAR(45) NULL,
PRIMARY KEY (`id`));

CREATE TABLE `courier` (
`id` int NOT NULL,
`name` varchar(45) DEFAULT NULL,
`telno` int DEFAULT NULL,
`company` varchar(45) DEFAULT NULL,
`vehical` varchar(45) DEFAULT NULL,
`email` varchar(150) DEFAULT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE `researcher` (
`id` int(11) NOT NULL,
`name` varchar(45) DEFAULT NULL,
`telno` int(11) DEFAULT NULL,
`specialization` varchar(45) DEFAULT NULL,
`university` varchar(45) DEFAULT NULL,
`email` varchar(45) DEFAULT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE `proposedresearches` (
`rid` int(11) NOT NULL,
`rchrid` int(11) DEFAULT NULL,
`researchName` varchar(45) DEFAULT NULL,
`criteria` varchar(45) DEFAULT NULL,
`university` varchar(45) DEFAULT NULL,
`doclink` varchar(150) DEFAULT NULL,
PRIMARY KEY (`rid`)
);