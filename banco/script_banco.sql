CREATE DATABASE Farmacia;

CREATE TABLE `dispensas` (
  `idDispensa` int(11) NOT NULL AUTO_INCREMENT,
  `dataDispensa` date NOT NULL,
  `idRetirante` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idDispensa`),
  KEY `FK_Retirante` (`idRetirante`),
  KEY `FK_Paciente` (`idPaciente`),
  KEY `FK_Usuario` (`idUsuario`),
  CONSTRAINT `dispensas_ibfk_1` FOREIGN KEY (`idRetirante`) REFERENCES `retirantes` (`idRetirante`),
  CONSTRAINT `dispensas_ibfk_2` FOREIGN KEY (`idPaciente`) REFERENCES `pacientes` (`idPaciente`),
  CONSTRAINT `dispensas_ibfk_3` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `dispensas_medicamentos` (
  `idDispensa` int(11) NOT NULL,
  `idMedicamento` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  KEY `FK_Dispensa` (`idDispensa`),
  KEY `FK_Medicamento_dis` (`idMedicamento`),
  CONSTRAINT `FK_Dispensa` FOREIGN KEY (`idDispensa`) REFERENCES `dispensas` (`idDispensa`),
  CONSTRAINT `FK_Medicamento_dis` FOREIGN KEY (`idMedicamento`) REFERENCES `medicamentos` (`idMedicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `lote` (
  `lote` varchar(45) NOT NULL,
  `idMedicamento` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `dataVencimento` date NOT NULL,
  PRIMARY KEY (`lote`),
  KEY `idMedicamento` (`idMedicamento`),
  CONSTRAINT `lote_ibfk_1` FOREIGN KEY (`idMedicamento`) REFERENCES `medicamentos` (`idMedicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `medicamentos` (
  `idMedicamento` int(11) NOT NULL AUTO_INCREMENT,
  `nomeMedicamento` varchar(255) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `nomeFabricante` varchar(255) NOT NULL,
  `composicao` varchar(45) NOT NULL,
  `dosagem` double NOT NULL,
  `medida` varchar(45) NOT NULL,
  PRIMARY KEY (`idMedicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `medicamentos_receitas` (
  `idMedicamento` int(11) NOT NULL,
  `idReceita` int(11) NOT NULL,
  KEY `FK_Medicamento` (`idMedicamento`),
  KEY `FK_Receita` (`idReceita`),
  CONSTRAINT `FK_Medicamento` FOREIGN KEY (`idMedicamento`) REFERENCES `medicamentos` (`idMedicamento`),
  CONSTRAINT `FK_Receita` FOREIGN KEY (`idReceita`) REFERENCES `receitas` (`idReceita`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `pacientes` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `cpfPaciente` varchar(11) NOT NULL,
  `nomePaciente` varchar(255) NOT NULL,
  `dnPaciente` date NOT NULL,
  `telefone` varchar(12) DEFAULT NULL,
  `cep` varchar(8) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `numEndereco` int(11) NOT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `receitas` (
  `idReceita` int(11) NOT NULL AUTO_INCREMENT,
  `nomeMedico` varchar(255) NOT NULL,
  `CRM` varchar(45) NOT NULL,
  `validadeReceita` date NOT NULL,
  PRIMARY KEY (`idReceita`)
  CONSTRAINT `FK_Paciente` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `retirantes` (
  `idRetirante` int(11) NOT NULL AUTO_INCREMENT,
  `cpfRetirante` varchar(11) NOT NULL,
  `nomeRetirante` varchar(255) NOT NULL,
  `dnRetirante` date NOT NULL,
  `telefone` varchar(12) DEFAULT NULL,
  `cep` varchar(8) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `numEndereco` int(11) NOT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `vincolo` varchar(45) NOT NULL,
  PRIMARY KEY (`idRetirante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `retirantes_pacientes` (
  `idPaciente` int(11) NOT NULL,
  `idRetirante` int(11) NOT NULL,
  KEY `FK_Paciente` (`idPaciente`),
  KEY `FK_Retirante` (`idRetirante`),
  CONSTRAINT `FK_Paciente` FOREIGN KEY (`idPaciente`) REFERENCES `pacientes` (`idPaciente`),
  CONSTRAINT `FK_Retirante` FOREIGN KEY (`idRetirante`) REFERENCES `retirantes` (`idRetirante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nomeUsuario` varchar(255) NOT NULL,
  `emailUsuario` varchar(255) NOT NULL,
  `dataNascimento` Date NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `perfil` varchar(100) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `log` (
  `idLog` int(11) NOT NULL  AUTO_INCREMENT,
  `idUsuario` int(11) NULL,
  `mensagem` varchar(45)NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`idLog`),
  KEY `FK_Usuario` (`idUsuario`),
  CONSTRAINT `log_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
