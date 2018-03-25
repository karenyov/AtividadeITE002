CREATE database pizzaria; -- nome opcional


CREATE TABLE `pizzaria`.`usuario` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `pizzaria`.`cliente` (
  `cliente_id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL,
  `endereco` VARCHAR(255) NULL,
  `telefone` VARCHAR(45) NULL,
  PRIMARY KEY (`cliente_id`));
  
CREATE TABLE `pizzaria`.`produto` (
  `produto_id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL,
  PRIMARY KEY (`produto_id`));

CREATE TABLE `pizzaria`.`pedido` (
  `pedido_id` INT NOT NULL AUTO_INCREMENT,
  `situacao` VARCHAR(45) NULL,
  PRIMARY KEY (`pedido_id`));

ALTER TABLE `pizzaria`.`pedido` 
ADD COLUMN `cliente_id` INT NOT NULL AFTER `situacao`,
ADD INDEX `fk_cliente_id_pedido_idx` (`cliente_id` ASC);
ALTER TABLE `pizzaria`.`pedido` 
ADD CONSTRAINT `fk_cliente_id_pedido`
  FOREIGN KEY (`cliente_id`)
  REFERENCES `pizzaria`.`cliente` (`cliente_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
ALTER TABLE `pizzaria`.`pedido` 
ADD COLUMN `total` FLOAT NULL AFTER `cliente_id`;

CREATE TABLE `pizzaria`.`item_pedido` (
  `item_pedido_id` INT NOT NULL AUTO_INCREMENT,
  `pedido_id` INT NULL,
  `produto_id` INT NULL,
  `quantidade` FLOAT NULL,
  `preco_unitario` FLOAT NULL,
  `preco_total` FLOAT NULL,
  PRIMARY KEY (`item_pedido_id`),
  INDEX `fk_pedido_id_item_pedido_idx` (`pedido_id` ASC),
  INDEX `fk_produto_id_item_pedido_idx` (`produto_id` ASC),
  CONSTRAINT `fk_pedido_id_item_pedido`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `pizzaria`.`pedido` (`pedido_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_id_item_pedido`
    FOREIGN KEY (`produto_id`)
    REFERENCES `pizzaria`.`produto` (`produto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `pizzaria`.`item_pedido` 
CHANGE COLUMN `quantidade` `quantidade` DOUBLE NULL DEFAULT NULL ,
CHANGE COLUMN `preco_unitario` `preco_unitario` DOUBLE NULL DEFAULT NULL ,
CHANGE COLUMN `preco_total` `preco_total` DOUBLE NULL DEFAULT NULL ;

ALTER TABLE `pizzaria`.`pedido` 
CHANGE COLUMN `total` `total` DOUBLE NULL DEFAULT NULL ;

ALTER TABLE `pizzaria`.`item_pedido` 
CHANGE COLUMN `quantidade` `quantidade` INT NULL DEFAULT NULL ;

ALTER TABLE `pizzaria`.`produto` 
ADD COLUMN `codigo` VARCHAR(45) NULL AFTER `descricao`,
ADD UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC);

