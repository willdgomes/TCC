CREATE DATABASE Farmacia;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1


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
  `parentesco` varchar(55) NOT NULL,
  PRIMARY KEY (`idRetirante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `retirantesPacientes` (
  `idPacienteFk` int(11) NOT NULL,
  `idRetiranteFk` int(11) NOT NULL,
  KEY `idPacienteFk` (`idPacienteFk`),
  KEY `idRetiranteFk` (`idRetiranteFk`),
  CONSTRAINT `retirantesPacientes_ibfk_1` FOREIGN KEY (`idPacienteFk`) REFERENCES `pacientes` (`idPaciente`),
  CONSTRAINT `retirantesPacientes_ibfk_2` FOREIGN KEY (`idRetiranteFk`) REFERENCES `retirantes` (`idRetirante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `usuarios` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1

CREATE TABLE `medicamentos` (
  `idMedicamento` int(11) NOT NULL AUTO_INCREMENT,
  `nomeMedicamento` varchar(255) NOT NULL,
  `loteMedicamento` varchar(100) NOT NULL,
  `dataVencimento` date NOT NULL,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`idMedicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
