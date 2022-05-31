DROP DATABASE IF EXISTS genshinApp;
CREATE DATABASE genshinApp;

/* A character in this database is, as of time of writing,
 * assumed level 90. These base stats are for the character
 * taken from in game/the wiki. A character can have an equipped
 * set of gear which is stored as foreign keys to the entries in
 * the gear piece's respective table
 */
CREATE TABLE character(
	id INT PRIMARY KEY AUTO_INCREMENT,
	characterName VARCHAR(50) NOT NULL,
	weaponType VARCHAR(15) NOT NULL,
	baseAttack INT NOT NULL,
	baseAttackPercent DECIMAL NOT NULL,
	baseHP INT NOT NULL,
	baseHPPercent DECIMAL NOT NULL,
	baseDef INT NOT NULL,
	baseElemMastery INT NOT NULL,
	baseCrit DECIMAL(2,1) NOT NULL,
	baseCritDamage DECIMAL(2,1) NOT NULL,
	basePhysDamage DECIMAL(2,1) NOT NULL,
	baseElemDamage DECIMAL(2,1) NOT NULL,
	baseEnergyRecharge DECIMAL NOT NULL
);

CREATE TABLE flower(
	id INT PRIMARY KEY AUTO_INCREMENT,
	mainstatID INT NOT NULL,
);

CREATE TABLE plume(
	id INT PRIMARY KEY AUTO_INCREMENT,
	mainstatID INT NOT NULL,
);

CREATE TABLE sands(
	id INT PRIMARY KEY AUTO_INCREMENT,
	mainstatID INT NOT NULL,
);

CREATE TABLE goblet(
	id INT PRIMARY KEY AUTO_INCREMENT,
	mainstatID INT NOT NULL,
);	

CREATE TABLE circlet(
	id INT PRIMARY KEY AUTO_INCREMENT,
	mainstatID INT NOT NULL,
);

CREATE TABLE flowerSubstat(
	id INT PRIMARY KEY AUTO_INCREMENT,
	flowerID INT,
	substatID INT
);

CREATE TABLE plumeSubstat(
	id INT PRIMARY KEY AUTO_INCREMENT,
	plumeID INT,
	substatID INT
);

CREATE TABLE sandsSubstat(
	id INT PRIMARY KEY AUTO_INCREMENT,
	sandsID INT,
	substatID INT
);

CREATE TABLE gobletSubstat(
	id INT PRIMARY KEY AUTO_INCREMENT,
	gobletID INT,
	substatID INT
);

CREATE TABLE circletSubstat(
	id INT PRIMARY KEY AUTO_INCREMENT,
	circletID INT,
	substatID INT
);

CREATE TABLE mainstat(
	id INT PRIMARY KEY AUTO_INCREMENT,
	statName VARCHAR(10),
	statValue DECIMAL(2,1),
	CONSTRAINT mainstat_Uniqueness UNIQUE(statName, statValue)
);

CREATE TABLE substat(
	id INT PRIMARY KEY AUTO_INCREMENT,
	statName VARCHAR(10),
	statValue DECIMAL(2,1),
	CONSTRAINT substat_Uniqueness UNIQUE(statName, statValue)
);

CREATE TABLE weapon(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	weaponType VARCHAR(15) NOT NULL,
	baseAttack INT NOT NULL,
	secondaryStatID INT NOT NULL,
	buildID INT
);

CREATE TABLE weaponSecondaryStat (
	id INT PRIMARY KEY AUTO_INCREMENT,
	statName VARCHAR(30),
	statValue DECIMAL(2,1)
);

#A build consists of a character and what artifacts/weapons
#that character has equipped
CREATE TABLE build(
	id PRIMARY KEY AUTO_INCREMENT,
	characterID INT NOT NULL,
	weaponID INT NOT NULL,
	flowerID INT,
	plumeID INT,
	sandsID INT,
	gobletID INT,
	circletID INT
);

#For storing resistances for calculating damage estimates
CREATE TABLE enemy(
	id INT PRIMARY KEY AUTO_INCREMENT,
	resistance DECIMAL
);
/*
DATA SOURCE: genshin.honeyhunterworld.com

name, weaponTyoe, baseAttack, baseAttackPercent,
baseHP, baseHPPercent, baseDef, baseElemMastery, baseCrit, 
baseCritDamage, basePhysDamage, baseElemDamage, baseEnergyRecharge
*/
INSERT INTO character(name, weaponTyoe, baseAttack, baseAttackPercent,
baseHP, baseHPPercent, baseDef, baseElemMastery, baseCrit, 
baseCritDamage, basePhysDamage, baseElemDamage, baseEnergyRecharge)
VALUES ('Albedo', 'Sword', 251, 0, 13226, 0, 876, 0, 5. 50, 0, 28.8, 0),
('Aloy', 'Bow', 234, 0, 10899, 0, 676, 0, 5. 50, 0, 28.8, 0),
('Amber', 'Bow', 223, 24, 9461, 0, 601, 0, 5. 50, 0, 0, 0),
('Arataki Itto', 'Claymore', 227, 0, 9461, 0, 959, 0, 24.2, 50, 0, 0, 0),
('Barbara', 'Catalyst', 159, 0, 9787, 24, 669, 0, 5. 50, 0, 0, 0),
('Beidou', 'Claymore', 225, 0, 13050, 0, 648, 0, 5. 50, 0, 24, 0),
('Bennet', 'Sword', 191, 0, 12397, 0, 771, 0, 5. 50, 0, 0, 26.7),
('Bennet', 'Sword', 191, 0, 12397, 0, 771, 0, 5. 50, 0, 0, 26.7);