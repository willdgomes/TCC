CREATE DATABASE Farmacia;

CREATE TABLE `usuarios` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `pacientes` (
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
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`cpfPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

