-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema agronitor_testdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema agronitor_testdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agronitor_testdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `agronitor_testdb` ;

-- -----------------------------------------------------
-- Table `agronitor_testdb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agronitor_testdb`.`users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_6dotkott2kjsp8vw4d0m25fb7` (`email` ASC) VISIBLE,
  UNIQUE INDEX `UK_r43af9ap4edm43mmtq01oddj6` (`username` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `agronitor_testdb`.`greenhouses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agronitor_testdb`.`greenhouses` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `greenhouse_name` VARCHAR(50) NOT NULL,
  `id_user` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKjhdkmcwvh1u9cohkmy9pr0koj` (`id_user` ASC) VISIBLE,
  CONSTRAINT `FKjhdkmcwvh1u9cohkmy9pr0koj`
    FOREIGN KEY (`id_user`)
    REFERENCES `agronitor_testdb`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `agronitor_testdb`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agronitor_testdb`.`hibernate_sequence` (
  `next_val` BIGINT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `agronitor_testdb`.`humidities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agronitor_testdb`.`humidities` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `timestamp` DATETIME(6) NULL DEFAULT NULL,
  `value` VARCHAR(255) NULL DEFAULT NULL,
  `id_greenhouse` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK4q4ythbrcjrrup57cp037stth` (`id_greenhouse` ASC) VISIBLE,
  CONSTRAINT `FK4q4ythbrcjrrup57cp037stth`
    FOREIGN KEY (`id_greenhouse`)
    REFERENCES `agronitor_testdb`.`greenhouses` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `agronitor_testdb`.`soil_hydrations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agronitor_testdb`.`soil_hydrations` (
  `id` BIGINT NOT NULL,
  `timestamp` DATETIME(6) NULL DEFAULT NULL,
  `value` VARCHAR(255) NULL DEFAULT NULL,
  `id_greenhouse` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKc6aqtk6q2rgxs6fcc02f7evgt` (`id_greenhouse` ASC) VISIBLE,
  CONSTRAINT `FKc6aqtk6q2rgxs6fcc02f7evgt`
    FOREIGN KEY (`id_greenhouse`)
    REFERENCES `agronitor_testdb`.`greenhouses` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `agronitor_testdb`.`temperatures`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agronitor_testdb`.`temperatures` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `timestamp` DATETIME(6) NULL DEFAULT NULL,
  `value` VARCHAR(255) NULL DEFAULT NULL,
  `id_greenhouse` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKjvh1n1yqggwubtbavtfptnst6` (`id_greenhouse` ASC) VISIBLE,
  CONSTRAINT `FKjvh1n1yqggwubtbavtfptnst6`
    FOREIGN KEY (`id_greenhouse`)
    REFERENCES `agronitor_testdb`.`greenhouses` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `agronitor_testdb`.`uvradiations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agronitor_testdb`.`uvradiations` (
  `id` BIGINT NOT NULL,
  `timestamp` DATETIME(6) NULL DEFAULT NULL,
  `value` VARCHAR(255) NULL DEFAULT NULL,
  `id_greenhouse` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKbswra801n315w4ytgykotol1w` (`id_greenhouse` ASC) VISIBLE,
  CONSTRAINT `FKbswra801n315w4ytgykotol1w`
    FOREIGN KEY (`id_greenhouse`)
    REFERENCES `agronitor_testdb`.`greenhouses` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE USER 'agronitor_test_user' IDENTIFIED BY 'agronitor_test_user';

GRANT ALL ON `agronitor_testdb`.* TO 'agronitor_test_user';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
