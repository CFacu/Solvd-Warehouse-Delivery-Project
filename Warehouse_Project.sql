-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Warehouse_Project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Warehouse_Project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Warehouse_Project` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema warehouse_project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema warehouse_project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `warehouse_project` DEFAULT CHARACTER SET utf8 ;
USE `Warehouse_Project` ;

-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Countries` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Cities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `countries_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cities_Countries1_idx` (`countries_id` ASC),
  CONSTRAINT `fk_Cities_Countries1`
    FOREIGN KEY (`countries_id`)
    REFERENCES `Warehouse_Project`.`Countries` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Locations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Locations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `cities_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Locations_Cities1_idx` (`cities_id` ASC),
  CONSTRAINT `fk_Locations_Cities1`
    FOREIGN KEY (`cities_id`)
    REFERENCES `Warehouse_Project`.`Cities` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Warehouses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Warehouses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `total_capacity` DOUBLE NOT NULL,
  `available_capacity` DOUBLE NOT NULL,
  `locations_id` INT NOT NULL,
  `next_warehouses_id` INT NOT NULL,
  `days_to_next_warehouse` INT NULL,
  `companies_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Warehouses_Locations1_idx` (`locations_id` ASC),
  INDEX `fk_Warehouses_Warehouses1_idx` (`next_warehouses_id` ASC),
  INDEX `fk_Warehouses_Companies1_idx` (`companies_id` ASC),
  CONSTRAINT `fk_Warehouses_Locations1`
    FOREIGN KEY (`locations_id`)
    REFERENCES `Warehouse_Project`.`Locations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Warehouses_Warehouses1`
    FOREIGN KEY (`next_warehouses_id`)
    REFERENCES `Warehouse_Project`.`Warehouses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Warehouses_Companies1`
    FOREIGN KEY (`companies_id`)
    REFERENCES `Warehouse_Project`.`Companies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Companies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Companies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `next_warehouses_id` INT NOT NULL,
  `days_to_closes_warerehouse` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Companies_Warehouses1_idx` (`next_warehouses_id` ASC),
  CONSTRAINT `fk_Companies_Warehouses1`
    FOREIGN KEY (`next_warehouses_id`)
    REFERENCES `Warehouse_Project`.`Warehouses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Trucks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Trucks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `capacity` DOUBLE NOT NULL,
  `companies_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Trucks_Companies1_idx` (`companies_id` ASC),
  CONSTRAINT `fk_Trucks_Companies1`
    FOREIGN KEY (`companies_id`)
    REFERENCES `Warehouse_Project`.`Companies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Drivers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Drivers` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `age` INT NULL,
  `birth` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '								';


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `total_volume` DOUBLE NOT NULL,
  `total_price` DOUBLE NOT NULL,
  `trucks_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idOrders_UNIQUE` (`id` ASC),
  INDEX `fk_Orders_Trucks1_idx` (`trucks_id` ASC),
  CONSTRAINT `fk_Orders_Trucks1`
    FOREIGN KEY (`trucks_id`)
    REFERENCES `Warehouse_Project`.`Trucks` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Product_Categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Product_Categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `volume` DOUBLE NOT NULL,
  `due_date` DATE NOT NULL,
  `price` DOUBLE NOT NULL,
  `product_categories_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Products_produc_categories1_idx` (`product_categories_id` ASC),
  CONSTRAINT `fk_Products_Product_Categories1`
    FOREIGN KEY (`product_categories_id`)
    REFERENCES `Warehouse_Project`.`Product_Categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Orders_Details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Orders_Details` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `subtotal_volume` DOUBLE NOT NULL,
  `subtotal_price` DOUBLE NOT NULL,
  `products_id` INT NOT NULL,
  `orders_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_Orders_Details_Products1_idx` (`products_id` ASC),
  INDEX `fk_Orders_Details_Orders1_idx` (`orders_id` ASC),
  CONSTRAINT `fk_Orders_Details_Products1`
    FOREIGN KEY (`products_id`)
    REFERENCES `Warehouse_Project`.`Products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orders_Details_Orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `Warehouse_Project`.`Orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Phone_Types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Phone_Types` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Phones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Phones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(20) NOT NULL,
  `type_id` INT UNSIGNED NOT NULL,
  `drivers_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_Phones_Drivers1_idx` (`drivers_id` ASC) ,
  INDEX `fk_Phones_Types_idx` (`type_id` ASC) ,
  CONSTRAINT `fk_Phones_Drivers1`
    FOREIGN KEY (`drivers_id`)
    REFERENCES `Warehouse_Project`.`Drivers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Phones_Types`
    FOREIGN KEY (`type_id`)
    REFERENCES `Warehouse_Project`.`Phone_Types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Warehouse_Project`.`Trucks_Drivers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse_Project`.`Trucks_Drivers` (
  `truck_id` INT UNSIGNED NOT NULL,
  `driver_id` INT UNSIGNED NOT NULL,
  INDEX `pk_TD_Trucks_idx` (`truck_id` ASC) ,
  INDEX `pk_TD_Drivers_idx` (`driver_id` ASC) ,
  PRIMARY KEY (`truck_id`, `driver_id`),
  CONSTRAINT `pk_TD_Trucks`
    FOREIGN KEY (`truck_id`)
    REFERENCES `Warehouse_Project`.`Trucks` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pk_TD_Drivers`
    FOREIGN KEY (`driver_id`)
    REFERENCES `Warehouse_Project`.`Drivers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `warehouse_project` ;

-- -----------------------------------------------------
-- Table `warehouse_project`.`countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`countries` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_project`.`cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`cities` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `countries_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cities_Countries1_idx` (`countries_id` ASC) ,
  CONSTRAINT `fk_Cities_Countries1`
    FOREIGN KEY (`countries_id`)
    REFERENCES `warehouse_project`.`countries` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_project`.`companies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`companies` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_project`.`drivers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`drivers` (
  `id` INT(11) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `birth` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '								';


-- -----------------------------------------------------
-- Table `warehouse_project`.`locations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`locations` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `cities_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Locations_Cities1_idx` (`cities_id` ASC) ,
  CONSTRAINT `fk_Locations_Cities1`
    FOREIGN KEY (`cities_id`)
    REFERENCES `warehouse_project`.`cities` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_project`.`trucks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`trucks` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `capacity` DOUBLE NOT NULL,
  `companies_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_Trucks_Companies1_idx` (`companies_id` ASC) ,
  CONSTRAINT `fk_Trucks_Companies1`
    FOREIGN KEY (`companies_id`)
    REFERENCES `warehouse_project`.`companies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_project`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`orders` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `total_volume` DOUBLE NOT NULL,
  `total_price` DOUBLE NOT NULL,
  `trucks_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idOrders_UNIQUE` (`id` ASC) ,
  INDEX `fk_Orders_Trucks1_idx` (`trucks_id` ASC) ,
  CONSTRAINT `fk_Orders_Trucks1`
    FOREIGN KEY (`trucks_id`)
    REFERENCES `warehouse_project`.`trucks` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_project`.`product_categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`product_categories` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_project`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`products` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `volume` DOUBLE NOT NULL,
  `due_date` DATE NOT NULL,
  `price` DOUBLE NOT NULL,
  `product_categories_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_Products_produc_categories1_idx` (`product_categories_id` ASC) ,
  CONSTRAINT `fk_Products_Product_Categories1`
    FOREIGN KEY (`product_categories_id`)
    REFERENCES `warehouse_project`.`product_categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_project`.`warehouses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`warehouses` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `distance_from_company` INT(11) NOT NULL,
  `total_capacity` DOUBLE NOT NULL,
  `current_capacity` DOUBLE NOT NULL,
  `locations_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Warehouses_Locations1_idx` (`locations_id` ASC) ,
  CONSTRAINT `fk_Warehouses_Locations1`
    FOREIGN KEY (`locations_id`)
    REFERENCES `warehouse_project`.`locations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_project`.`orders_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`orders_details` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `quantity` INT(11) NOT NULL,
  `subtotal_volume` DOUBLE NOT NULL,
  `subtotal_price` DOUBLE NOT NULL,
  `products_id` INT(11) NOT NULL,
  `orders_id` INT(11) NOT NULL,
  `warehouses_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Orders_Details_Products1_idx` (`products_id` ASC) ,
  INDEX `fk_Orders_Details_Orders1_idx` (`orders_id` ASC) ,
  INDEX `fk_Orders_Details_Warehouses1_idx` (`warehouses_id` ASC) ,
  CONSTRAINT `fk_Orders_Details_Products1`
    FOREIGN KEY (`products_id`)
    REFERENCES `warehouse_project`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orders_Details_Orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `warehouse_project`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orders_Details_Warehouses1`
    FOREIGN KEY (`warehouses_id`)
    REFERENCES `warehouse_project`.`warehouses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_project`.`phone_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`phone_types` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_project`.`phones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_project`.`phones` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(20) NOT NULL,
  `type_id` INT(10) UNSIGNED NOT NULL,
  `drivers_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_Phones_Drivers1_idx` (`drivers_id` ASC) ,
  INDEX `fk_Phones_Types_idx` (`type_id` ASC) ,
  CONSTRAINT `fk_Phones_Drivers1`
    FOREIGN KEY (`drivers_id`)
    REFERENCES `warehouse_project`.`drivers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Phones_Types`
    FOREIGN KEY (`type_id`)
    REFERENCES `warehouse_project`.`phone_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
