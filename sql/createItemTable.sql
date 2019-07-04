USE finalProject;

CREATE TABLE ITEM (ID int auto_increment,
ItemCode VARCHAR(10) NOT NULL UNIQUE,
ItemDescription VARCHAR(50),
Price DECIMAL(4,2) DEFAULT 0,
PRIMARY KEY (ID));