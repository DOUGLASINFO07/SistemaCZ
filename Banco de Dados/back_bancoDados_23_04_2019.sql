-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 10.129.76.12
-- Tempo de geração: 23/04/2019 às 21:57
-- Versão do servidor: 5.6.26-log
-- Versão do PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de dados: `sistemacz`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `atividades`
--

CREATE TABLE IF NOT EXISTS `atividades` (
`codigo` int(5) NOT NULL,
  `atividades` varchar(30) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataTermino` date NOT NULL,
  `ciclo` varchar(15) NOT NULL,
  `observacao` varchar(200) NOT NULL,
  `nomeAtividade` varchar(20) DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Fazendo dump de dados para tabela `atividades`
--

INSERT INTO `atividades` (`codigo`, `atividades`, `dataInicio`, `dataTermino`, `ciclo`, `observacao`, `nomeAtividade`) VALUES
(5, 'Reconhecimento Geográfico', '2019-01-02', '2019-01-16', '01', '', 'RG 01-2019'),
(6, 'LIRAa', '2019-01-24', '2019-01-23', '02', '', 'LIRAa 02-2019'),
(16, 'Tratamento Focal', '2019-02-24', '2019-04-27', '02', '', 'T.Focal 02-2019'),
(18, 'Tratamento Focal', '2018-12-30', '2019-02-23', '01', '', 'T.Focal 01-2019'),
(19, 'Tratamento Focal', '2019-02-24', '2019-04-27', '03', '', 'T.Focal 03-2019');

-- --------------------------------------------------------

--
-- Estrutura para tabela `denuncia`
--

CREATE TABLE IF NOT EXISTS `denuncia` (
`codigo` int(6) NOT NULL,
  `numeroDenuncia` int(6) DEFAULT NULL,
  `dataDenuncia` date DEFAULT NULL,
  `recebidaPor` varchar(40) DEFAULT NULL,
  `denunciante` varchar(40) DEFAULT NULL,
  `denunciado` varchar(40) DEFAULT NULL,
  `logradouro` varchar(40) DEFAULT NULL,
  `numeroEndereco` varchar(6) DEFAULT NULL,
  `bairro` varchar(40) DEFAULT NULL,
  `tipoImovel` varchar(20) DEFAULT NULL,
  `tipoDenuncia` varchar(20) DEFAULT NULL,
  `detalhesDenuncia` varchar(200) DEFAULT NULL,
  `ace1` varchar(40) DEFAULT NULL,
  `ace2` varchar(40) DEFAULT NULL,
  `situacaoVisita` varchar(20) DEFAULT NULL,
  `dataVisita` date DEFAULT NULL,
  `detalhesVisita` varchar(200) DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Fazendo dump de dados para tabela `denuncia`
--

INSERT INTO `denuncia` (`codigo`, `numeroDenuncia`, `dataDenuncia`, `recebidaPor`, `denunciante`, `denunciado`, `logradouro`, `numeroEndereco`, `bairro`, `tipoImovel`, `tipoDenuncia`, `detalhesDenuncia`, `ace1`, `ace2`, `situacaoVisita`, `dataVisita`, `detalhesVisita`) VALUES
(2, 1, '2019-02-21', 'Márcia Regina da Silveira Egidio', 'teste', 'joão', 'rua xyz', '123A', 'Residencial Tropical', 'Residência', 'Aedes Aegypti', 'asdfsdafsdafsdafDSHGFDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD', 'Eduardo Borges Egidio', 'Eduardo Borges Egidio', 'Concluída', '2019-02-28', 'TESTE 123'),
(3, 2, '2019-02-27', 'Márcia Regina da Silveira Egidio', 'tets novo', 'Douglas', 'Rua Sebastião Teófilo', '81', 'Vila São José', 'Comércio', 'Caixa d''agua', 'Caixa d''agua sem tampa.', 'Eduardo Borges Egidio', 'Eduardo Borges Egidio', 'Concluída', '2019-02-14', 'teste'),
(4, 3, '2019-02-27', 'Márcia Regina da Silveira Egidio', 'asdfsdaf', 'sadfsdf', 'Rua Sebastião Teófilo', '81', 'Residencial Tropical', 'Comércio', 'Caramujo', 'asdfsadfsdfsd', 'Selecione', 'Selecione', 'Aberta', NULL, ''),
(12, 9, '2019-02-15', 'Márcia Regina da Silveira Egidio', 'retyty', 'retytreyrety', 'retyerty', '321', 'Residencial Tropical', 'Comércio', 'Caramujo', 'retyretyerty', 'Selecione', 'Selecione', 'Aberta', '2019-02-14', ''),
(11, 8, '2019-02-15', 'Márcia Regina da Silveira Egidio', 'sdfgfdsgs', 'gsdgd', 'dsfgdfg', '654', 'Residencial Tropical', 'Outros', 'Cães e Gatos', 'fdgfdgf', 'Selecione', 'Selecione', 'Aberta', '2019-02-07', ''),
(7, 6, '2019-02-22', 'Márcia Regina da Silveira Egidio', 'bxcvbbvcx', 'cvbcxvbxcvbcxvb', 'cxvbxcvbcxvb', 'cxvb', 'Residencial Tropical', 'Residência', 'Aedes Aegypti', 'xcvbxcvbxcvbcxvb', '', '', 'Aberta', '2019-03-02', ''),
(8, 7, '2019-01-31', 'Márcia Regina da Silveira Egidio', 'gdsgffg', 'sdfgsdfg', 'dsfgdsfgdsfg', '987', 'Vila São José', 'Residência', 'Escorpião', 'dsfgsdfgfgdsfg', '', '', 'Aberta', '2019-02-13', ''),
(9, 8, '2019-02-21', 'Márcia Regina da Silveira Egidio', 'ASDFSDF', 'ASDFDF', 'SADFSDF', '654AS', 'Residencial Tropical', 'Comércio', 'Casa Abandonada', 'SADFSADFDSAF', '', '', 'Aberta', '2019-02-13', ''),
(13, 10, '2019-02-19', 'Márcia Regina da Silveira Egidio', 'utryutyutr', 'tryurtyu', 'rtyurtyutryu', '987', 'Vila São José', 'Residência', 'Escorpião', 'tryurtyurtutryu', 'Selecione', 'Selecione', 'Aberta', NULL, ''),
(14, 11, '2019-02-13', 'Márcia Regina da Silveira Egidio', 'eyretyty', 'rteyrety', 'retyrety', '654', 'Residencial Tropical', 'Terreno Baldio', 'Aedes Aegypti', 'rtyretyretyrteyrty', '', '', 'Aberta', NULL, ''),
(15, 12, '2019-02-28', 'Márcia Regina da Silveira Egidio', 'dfhfgh', 'fdghdfg', 'dfghfgdh', '654', 'Residencial Tropical', 'Terreno Baldio', 'Construção', 'fdghdfghdfgh', '', '', 'Aberta', NULL, ''),
(16, 13, '2019-02-22', 'Márcia Regina da Silveira Egidio', 'fhdghfgh', 'fgdhfdgh', 'fdghdfghgfh', '987', 'Vila São José', 'Terreno Baldio', 'Caixa d''agua', 'fdghdfgh', 'Eduardo Borges Egidio', 'Eduardo Borges Egidio', 'Concluída', '2019-02-14', 'fhgdgfhghhfghghghhgh'),
(17, 14, '2019-02-13', 'Márcia Regina da Silveira Egidio', 'qewrew', 'qwerwer', 'qwerqwer', '3214', 'Vila São José', 'Residência', 'Construção', 'qwerqwerwqer', 'Eduardo Borges Egidio', 'Eduardo Borges Egidio', 'Concluída', '2019-02-21', 'lkjlkjlk,mn,mn,mn,mn,m');

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
`codigoFuncionario` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` varchar(20) NOT NULL,
  `orgaoEmissorRG` varchar(10) NOT NULL,
  `estadoOrgaoEmissorRG` varchar(5) NOT NULL,
  `dataEmissaoRG` date DEFAULT NULL,
  `habilitacao` varchar(20) DEFAULT NULL,
  `categoriaHabilitacao` varchar(15) DEFAULT NULL,
  `data1habilitacao` date DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `municipioNascimento` varchar(30) NOT NULL,
  `estadoNascimento` varchar(5) NOT NULL,
  `nomeMae` varchar(50) NOT NULL,
  `nomePai` varchar(50) DEFAULT NULL,
  `logradouroEndereco` varchar(50) NOT NULL,
  `numeroEndereco` varchar(10) NOT NULL,
  `bairroEndereco` varchar(50) NOT NULL,
  `cepEndereco` varchar(30) NOT NULL,
  `cidadeEndereco` varchar(50) NOT NULL,
  `estadoEndereco` varchar(5) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `telefoneContato` varchar(20) DEFAULT NULL,
  `whatsApp` varchar(20) DEFAULT NULL,
  `cargo` varchar(30) NOT NULL,
  `vinculoEmpregaticio` varchar(20) NOT NULL,
  `matricula` varchar(10) NOT NULL,
  `equipe` varchar(30) NOT NULL,
  `areaTrabalho` varchar(30) NOT NULL,
  `situacaoFuncionario` varchar(20) NOT NULL,
  `dataAdmissao` date DEFAULT NULL,
  `dataDemissao` date DEFAULT NULL,
  `formaIngresso` varchar(30) NOT NULL,
  `formaEgresso` varchar(30) DEFAULT NULL,
  `observacao` varchar(200) DEFAULT NULL,
  `fotoFuncionario` varchar(50) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

--
-- Fazendo dump de dados para tabela `funcionario`
--

INSERT INTO `funcionario` (`codigoFuncionario`, `nome`, `cpf`, `rg`, `orgaoEmissorRG`, `estadoOrgaoEmissorRG`, `dataEmissaoRG`, `habilitacao`, `categoriaHabilitacao`, `data1habilitacao`, `dataNascimento`, `municipioNascimento`, `estadoNascimento`, `nomeMae`, `nomePai`, `logradouroEndereco`, `numeroEndereco`, `bairroEndereco`, `cepEndereco`, `cidadeEndereco`, `estadoEndereco`, `email`, `telefone`, `telefoneContato`, `whatsApp`, `cargo`, `vinculoEmpregaticio`, `matricula`, `equipe`, `areaTrabalho`, `situacaoFuncionario`, `dataAdmissao`, `dataDemissao`, `formaIngresso`, `formaEgresso`, `observacao`, `fotoFuncionario`) VALUES
(9, 'Italo Silveira Egidio', '987.987.987-65', '654.879.654', 'SSP', 'MG', '2008-05-05', '44444444', 'D', '2008-05-05', '2008-05-05', 'Passos', 'MG', 'Marcia Regina', 'Douglas Borges egidio', 'Rua Sebastião Teófilo', '81', 'nova Califórnia', '21.548-798', 'Passos', 'MG', 'italo@gmail.com', '(35) 66666-6666', '(77) 77777-7777', '(11) 11111-1111', 'Supervisor Geral', 'Efetivo', '6598', 'PA', 'Ponto Estratégico', 'Regular', '2008-05-05', NULL, 'Processo Seletivo', 'Saiu Estagio', '', 'fotosFuncionarios/cemig.png'),
(28, 'Camila Borges Egidio', '200.597.587-12', '8.263.547', 'SSP', 'MG', '2012-06-06', '159753852', 'A-B', '2008-05-06', '2018-09-05', 'Belo Horizonte', 'MG', 'Filomena Vilela Borges Egidio', 'João Batista egidio', 'Rua Antonio de Pádua', '84', 'Monsenhor Horta', '24.200-000', 'Ibirité', 'MG', 'camila.egidio@gmail.com', '(31) 95978-4578', '', '(31) 95782-5366', 'Agente de Endemias', 'Efetivo', '3214', 'Equipe 01-A', 'Controle de Escorpião', 'Desviado de Função', '2018-02-05', NULL, 'Concurso Público', 'Saiu da Terceirizada', '', 'fotosFuncionarios/download (1).jpg'),
(29, 'Eduardo Borges Egidio', '599.874.526-21', '3.215.498', 'SSP', 'MG', '2007-09-09', '', 'D', '2015-01-01', '1983-04-22', 'Guarulhos', 'SP', 'Filomena Vilela Borges Egidio', 'João Batista Egidio', 'Rua Chile', '60', 'Jardim Polivalente', '37.905-214', 'passos', 'MG', 'eduardoborgesegidio@gmail.com', '(35) 99485-2154', '', '(35) 94875-6251', 'Agente de Endemias', 'Contratado', '1425', 'Equipe 01-H', 'UBV', 'Desviado de Função', '2016-12-05', NULL, 'Estágio', 'Exonerou-se', '', 'fotosFuncionarios/imagem1.jpg'),
(30, 'Márcia Regina da Silveira Egidio', '476.350.089-68', '3.008.537', 'SSP', 'PR', '2014-02-02', '', 'Selecione', NULL, '1963-07-06', 'São Paulo', 'SP', 'Terezinha Aparecida da Silveira', 'José Marcelino da Silveira', 'Rua Sebastião Teófilo', '81', 'Nova Califórnia', '37.904-567', 'Londrina', 'MG', 'mrsegidio@gmail.com', '(35) 98454-3297', '', '(98) 54329-7', 'Agente de Endemias', 'Contratado', '2512', 'Equipe 01-D', 'Escritório', 'Regular', '2018-08-12', NULL, 'Contrato', 'Selecione', '', 'fotosFuncionarios/IMG-20180708-WA0001.jpg'),
(33, 'Antonio da silva', '216.549.875-45', '3.216.542', 'SSP', 'MA', '2019-02-11', '321654987', 'D', '2019-02-21', '2019-02-23', 'Belo Horizonte', 'GO', 'Tetrezinha de Jesus', 'Antonio de Jesus', 'Rua Tres de maio', '587-B', 'Santo Angelo', '37.905-678', 'Santo Antonio da Alegria', 'CE', 'santoantonio@gmail.com', '(35) 98989-8989', '', '', 'Supervisor de Área', 'Estagiário', '321654', 'Equipe 01-H', 'Ponto Estratégico', 'Desviado de Função', '2019-02-15', '2019-02-22', 'Cedido de outro Setor', 'Dispensado da Terceirizada', '', 'fotosFuncionarios/oleConsignado.png');

-- --------------------------------------------------------

--
-- Estrutura para tabela `localidade`
--

CREATE TABLE IF NOT EXISTS `localidade` (
`codLocalidade` int(10) NOT NULL,
  `codigo` varchar(5) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `sigla` varchar(5) DEFAULT NULL,
  `categoria` varchar(20) DEFAULT NULL,
  `zona` varchar(15) DEFAULT NULL,
  `tipo` varchar(15) DEFAULT NULL,
  `observacao` varchar(200) DEFAULT NULL,
  `mapa` varchar(50) DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Fazendo dump de dados para tabela `localidade`
--

INSERT INTO `localidade` (`codLocalidade`, `codigo`, `nome`, `sigla`, `categoria`, `zona`, `tipo`, `observacao`, `mapa`) VALUES
(3, '332', 'Residencial Tropical', 'RT', 'Condominio', 'Urbana', 'Sede', 'Teste', 'mapasLocalidades/Residencial tropical.jpg'),
(2, '258', 'Vila São José', 'VSJ', 'Bairro', 'Rural', 'Outros', '', 'mapasLocalidades/Penha II.png'),
(4, '300', 'Penha 2', 'PII', 'Bairro', 'Urbana', 'Sede', '', 'mapasLocalidades/Penha II.jpg'),
(5, '300', 'Vila Antônio Silva', 'VAS', 'Bairro', 'Urbana', 'Sede', 'teste te ', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `login`
--

CREATE TABLE IF NOT EXISTS `login` (
`codigoLogin` int(10) NOT NULL,
  `nomeLogin` varchar(50) NOT NULL,
  `senha` varchar(30) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Fazendo dump de dados para tabela `login`
--

INSERT INTO `login` (`codigoLogin`, `nomeLogin`, `senha`) VALUES
(1, 'douglas', '123'),
(2, 'douglas', '123');

-- --------------------------------------------------------

--
-- Estrutura para tabela `quarteirao`
--

CREATE TABLE IF NOT EXISTS `quarteirao` (
`codigo` int(5) NOT NULL,
  `localidade` varchar(50) DEFAULT NULL,
  `rg` varchar(15) DEFAULT NULL,
  `macroArea` varchar(15) DEFAULT NULL,
  `microArea` varchar(15) DEFAULT NULL,
  `supervisor` varchar(50) DEFAULT NULL,
  `ace` varchar(50) DEFAULT NULL,
  `observacao` varchar(200) DEFAULT NULL,
  `quarteirao` int(3) DEFAULT NULL,
  `lados` int(3) DEFAULT NULL,
  `residencias` int(5) DEFAULT NULL,
  `comercios` int(5) DEFAULT NULL,
  `terrenoBaldio` int(5) DEFAULT NULL,
  `pontoEstrategico` int(5) NOT NULL,
  `outros` int(5) DEFAULT NULL,
  `caes` int(5) DEFAULT NULL,
  `gatos` int(5) DEFAULT NULL,
  `ratos` varchar(3) DEFAULT NULL,
  `habitantes` int(7) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Fazendo dump de dados para tabela `quarteirao`
--

INSERT INTO `quarteirao` (`codigo`, `localidade`, `rg`, `macroArea`, `microArea`, `supervisor`, `ace`, `observacao`, `quarteirao`, `lados`, `residencias`, `comercios`, `terrenoBaldio`, `pontoEstrategico`, `outros`, `caes`, `gatos`, `ratos`, `habitantes`) VALUES
(30, 'Penha 2', 'RG 01-2019', '01 - C', 'Micro 03', 'Douglas Borges Egidio', 'Eduardo Borges Egidio', '', 1, 1, 120, 0, 0, 0, 0, 0, 0, 'Não', 0),
(29, 'Penha 2', 'RG 01-2019', '01 - A', 'Micro 05', 'Douglas Borges Egidio', 'Camila Borges Egidio', '', 19, 4, 10, 0, 0, 0, 0, 0, 0, 'Sim', 0),
(28, 'Penha 2', 'RG 01-2019', '01 - B', 'Micro 03', 'Douglas Borges Egidio', 'Camila Borges Egidio', '', 2, 1, 1, 100, 0, 0, 0, 0, 0, 'Sim', 0),
(5, 'Penha 2', 'RG 01-2019', '01 - D', 'Micro 03', 'Douglas Borges Egidio', 'Camila Borges Egidio', '		', 3, 3, 3, 100, 3, 3, 3, 3, 3, 'Sim', 0),
(6, 'Penha 2', 'RG 01-2019', '01 - B', 'Micro 02', 'Douglas Borges Egidio', 'Márcia Regina da Silveira Egidio', '	', 4, 4, 4, 4, 4, 76, 4, 4, 4, 'Sim', 0),
(7, 'Penha 2', 'RG 01-2019', '01 - C', 'Micro 03', 'Douglas Borges Egidio', 'Eduardo Borges Egidio', '	', 5, 5, 5, 5, 5, 5, 5, 5, 5, 'Sim', 0),
(9, 'Penha 2', 'RG 01-2019', '01 - C', 'Micro 03', 'Douglas Borges Egidio', 'Márcia Regina da Silveira Egidio', '', 7, 7, 7, 7, 7, 7, 7, 7, 7, 'Sim', 0),
(10, 'Penha 2', 'RG 01-2019', '01 - C', 'Micro 03', 'Douglas Borges Egidio', 'Márcia Regina da Silveira Egidio', '', 8, 8, 8, 8, 8, 8, 8, 8, 8, 'Sim', 10),
(12, 'Penha 2', 'RG 01-2019', '01 - C', 'Micro 03', 'Douglas Borges Egidio', 'Márcia Regina da Silveira Egidio', '', 10, 10, 101, 1, 10, 10, 10, 10, 10, 'Sim', 0),
(13, 'Penha 2', 'RG 01-2019', '01 - C', 'Micro 03', 'Douglas Borges Egidio', 'Márcia Regina da Silveira Egidio', '', 11, 11, 1, 11, 11, 11, 111, 11, 11, 'Sim', 0),
(14, 'Penha 2', 'RG 01-2019', '01 - C', 'Micro 03', 'Douglas Borges Egidio', 'Márcia Regina da Silveira Egidio', '', 12, 12, 12, 12, 12, 1, 2, 12, 12, 'Sim', 0),
(15, 'Penha 2', 'RG 01-2019', '01 - C', 'Micro 03', 'Douglas Borges Egidio', 'Márcia Regina da Silveira Egidio', '', 13, 13, 13, 13, 13, 13, 13, 13, 13, 'Sim', 0),
(16, 'Penha 2', 'RG 01-2019', '01 - C', 'Micro 03', 'Douglas Borges Egidio', 'Márcia Regina da Silveira Egidio', '', 14, 14, 14, 14, 14, 14, 14, 14, 14, 'Sim', 0),
(17, 'Penha 2', 'RG 01-2019', '01 - B', 'Micro 03', 'Douglas Borges Egidio', 'Eduardo Borges Egidio', '', 15, 15, 15, 15, 15, 15, 15, 15, 515, 'Sim', 0),
(18, 'Penha 2', 'RG 01-2019', '01 - C', 'Micro 01', 'Douglas Borges Egidio', 'Eduardo Borges Egidio', '	', 16, 16, 16, 16, 16, 16, 16, 16, 16, 'Sim', 0),
(20, 'Penha 2', 'RG 01-2019', '01 - A', 'Micro 02', 'Douglas Borges Egidio', 'Eduardo Borges Egidio', '', 17, 17, 17, 17, 17, 17, 17, 17, 17, 'Sim', 0),
(21, 'Penha 2', 'RG 01-2019', '01 - A', 'Micro 02', 'Douglas Borges Egidio', 'Eduardo Borges Egidio', '', 18, 2, 10, 5, 10, 50, 5, 0, 0, 'Sim', 0),
(31, 'Penha 2', 'RG 01-2019', '01 - C', 'Micro 03', 'Douglas Borges Egidio', 'Eduardo Borges Egidio', '		', 20, 5, 1, 1, 1, 1, 1, 1, 1, 'Sim', 1),
(32, 'Vila Antônio Silva', '2019-03-07', '01 - D', 'Micro 01', 'Antonio da silva', 'Márcia Regina da Silveira Egidio', '', 1, 5, 3, 0, 0, 0, 0, 0, 0, 'Sim', 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `servicotratamentofocal`
--

CREATE TABLE IF NOT EXISTS `servicotratamentofocal` (
`codigo` int(9) NOT NULL,
  `rg` varchar(5) DEFAULT NULL,
  `localidade` varchar(50) DEFAULT NULL,
  `categoria` varchar(20) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `zona` varchar(20) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `semana` varchar(5) DEFAULT NULL,
  `ciclo` varchar(20) DEFAULT NULL,
  `ace` varchar(50) DEFAULT NULL,
  `supervisor` varchar(50) DEFAULT NULL,
  `comoTrabalhou` varchar(20) DEFAULT NULL,
  `observacao` varchar(200) DEFAULT NULL,
  `quarteirao` int(5) DEFAULT NULL,
  `lado` varchar(15) DEFAULT NULL,
  `residencia` int(5) DEFAULT NULL,
  `comercio` int(5) DEFAULT NULL,
  `terrenoBaldio` int(5) DEFAULT NULL,
  `outros` int(5) DEFAULT NULL,
  `visitaResgate` int(5) DEFAULT NULL,
  `eliminado` int(5) DEFAULT NULL,
  `imovelTratado` int(5) DEFAULT NULL,
  `larvicida` varchar(30) DEFAULT NULL,
  `quantLarvicida` double DEFAULT NULL,
  `quantTratado` int(5) DEFAULT NULL,
  `situacaoQuarteirao` varchar(20) DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Fazendo dump de dados para tabela `servicotratamentofocal`
--

INSERT INTO `servicotratamentofocal` (`codigo`, `rg`, `localidade`, `categoria`, `tipo`, `zona`, `data`, `semana`, `ciclo`, `ace`, `supervisor`, `comoTrabalhou`, `observacao`, `quarteirao`, `lado`, `residencia`, `comercio`, `terrenoBaldio`, `outros`, `visitaResgate`, `eliminado`, `imovelTratado`, `larvicida`, `quantLarvicida`, `quantTratado`, `situacaoQuarteirao`) VALUES
(1, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-15', '3', '02', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 2, '1', 5, 0, 0, 0, 0, 0, 0, 'Pyriproxyfen', 0, 0, 'Concluído'),
(2, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-25', '1', '02', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 5, '2', 10, 0, 0, 0, 0, 0, 0, 'Pyriproxyfen', 0, 0, 'Em Tratamento'),
(3, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-15', '6', 'T.Focal 02-2019', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 3, '3,4,', 50, 0, 0, 0, 0, 0, 0, 'Pyriproxyfen', 2, 0, 'Concluído'),
(4, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-18', '3', 'T.Focal 02-2019', 'Camila Borges Egidio', 'Douglas Borges Egidio', 'Individualmente', '	', 8, '1,2', 25, 0, 0, 0, 0, 0, 0, 'Pyriproxyfen', 2.6, 0, 'Em Tratamento'),
(5, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-25', '4', 'T.Focal 02-2019', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '	', 10, '1-2-3', 20, 10, 5, 5, 40, 20000, 40, 'Pyriproxyfen', 0.8, 5, 'Em Tratamento'),
(6, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-25', '4', 'T.Focal 02-2019', 'Eduardo Borges Egidio', 'Douglas Borges Egidio', 'Em Conjunto', '', 4, '1-2-3', 5, 5, 5, 5, 10, 6, 0, 'Pyriproxyfen', 0, 0, 'Concluído'),
(7, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-25', '4', 'T.Focal 02-2019', 'Eduardo Borges Egidio', 'Douglas Borges Egidio', 'Em Conjunto', '', 4, '1', 15, 15, 15, 0, 0, 0, 0, 'Pyriproxyfen', 0, 0, 'Concluído'),
(8, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-25', '4', 'T.Focal 02-2019', 'Eduardo Borges Egidio', 'Douglas Borges Egidio', 'Em Conjunto', '', 4, '1', 10, 3, 2, 0, 0, 0, 0, 'Pyriproxyfen', 2.5, 25, 'Concluído'),
(9, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-22', '2', 'T.Focal 01-2019', 'Camila Borges Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 1, '1', 25, 0, 0, 0, 0, 0, 0, 'Selecione', 0, 0, 'Em Tratamento'),
(10, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-22', '2', 'T.Focal 01-2019', 'Camila Borges Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 2, '0', 20, 0, 0, 0, 0, 0, 0, 'Selecione', 0, 0, 'Concluído'),
(11, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-05', '3', 'T.Focal 01-2019', 'Camila Borges Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 4, '1', 10, 0, 0, 0, 0, 0, 1, 'Pyriproxyfen', 1, 1, 'Em Tratamento'),
(12, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-06', '3', 'T.Focal 01-2019', 'Camila Borges Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 5, '2', 25, 0, 0, 0, 0, 0, 1, 'Pyriproxyfen', 1, 1, 'Em Tratamento'),
(13, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-07', '3', 'T.Focal 01-2019', 'Camila Borges Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 5, '0', 10, 0, 0, 0, 0, 0, 1, 'Selecione', 1, 1, 'Concluído'),
(14, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-25', '4', 'T.Focal 02-2019', 'Camila Borges Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 6, '1-2-3-4', 5, 0, 0, 0, 0, 0, 5, 'Pyriproxyfen', 5, 5, 'Em Tratamento'),
(15, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-25', '4', 'T.Focal 02-2019', 'Camila Borges Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 7, '0', 7, 0, 0, 0, 0, 0, 6, 'Selecione', 5.6, 3, 'Em Tratamento'),
(16, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-25', '4', 'T.Focal 02-2019', 'Camila Borges Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 8, '0', 7, 0, 0, 0, 0, 0, 6, 'Selecione', 6, 5, 'Em Tratamento'),
(17, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-15', '4', 'T.Focal 01-2019', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 7, '1-2-3', 5, 5, 5, 5, 2, 0, 5, 'Pyriproxyfen', 10, 1, 'Em Tratamento'),
(18, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-16', '4', 'T.Focal 01-2019', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 7, '1-2-3', 1, 0, 0, 0, 0, 0, 1, 'Pyriproxyfen', 1, 1, 'Em Tratamento'),
(19, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-17', '6', 'T.Focal 01-2019', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 7, '1', 5, 0, 0, 0, 0, 0, 0, 'Pyriproxyfen', 0, 0, 'Em Tratamento'),
(20, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-18', '6', 'T.Focal 01-2019', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 7, '32', 5, 0, 0, 0, 0, 0, 0, 'Selecione', 0, 0, 'Em Tratamento'),
(21, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-19', '5', 'T.Focal 01-2019', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 7, '1-2', 5, 0, 0, 0, 5, 0, 0, 'Pyriproxyfen', 0, 0, 'Em Tratamento'),
(24, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-22', '5', 'T.Focal 01-2019', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 7, '1-2', 3, 0, 0, 0, 0, 0, 0, 'Pyriproxyfen', 0, 0, 'Concluído'),
(25, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-23', '5', 'T.Focal 01-2019', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 7, '01', 3, 0, 0, 0, 0, 0, 0, 'Pyriproxyfen', 0, 0, 'Em Tratamento'),
(26, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-06', '5', 'T.Focal 01-2019', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 7, '1-2', 5, 0, 0, 0, 5, 0, 0, 'Pyriproxyfen', 0, 0, 'Em Tratamento'),
(27, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-02-10', '5', 'T.Focal 01-2019', 'Márcia Regina da Silveira Egidio', 'Douglas Borges Egidio', 'Individualmente', '', 7, '1', 5, 0, 0, 0, 5, 0, 0, 'Pyriproxyfen', 0, 0, 'Em Tratamento'),
(28, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-01-25', '4', 'T.Focal 01-2019', 'Camila Borges Egidio', 'Antonio da silva', 'Individualmente', '	', 8, '2-3-4', 15, 32, 0, 0, 0, 0, 0, 'Pyriproxyfen', 0, 0, 'Em Tratamento'),
(29, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-01-25', '5', 'T.Focal 01-2019', 'Eduardo Borges Egidio', 'Antonio da silva', 'Individualmente', '', 8, '1-4', 10, 0, 0, 0, 0, 0, 0, 'Pyriproxyfen', 0, 0, 'Concluído'),
(30, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-01-25', '10', 'T.Focal 01-2019', 'Márcia Regina da Silveira Egidio', 'Antonio da silva', 'Individualmente', '', 8, '1', 25, 0, 0, 0, 25, 0, 0, 'Pyriproxyfen', 0, 0, 'Em Tratamento'),
(31, '258', 'Vila São José', 'Bairro', 'Outros', 'Rural', '2019-01-05', '6', 'T.Focal 01-2019', 'Camila Borges Egidio', 'Antonio da silva', 'Individualmente', '', 8, '1', 5, 2, 0, 0, 7, 0, 0, 'Pyriproxyfen', 0, 0, 'Em Tratamento');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `atividades`
--
ALTER TABLE `atividades`
 ADD PRIMARY KEY (`codigo`);

--
-- Índices de tabela `denuncia`
--
ALTER TABLE `denuncia`
 ADD PRIMARY KEY (`codigo`);

--
-- Índices de tabela `funcionario`
--
ALTER TABLE `funcionario`
 ADD PRIMARY KEY (`codigoFuncionario`);

--
-- Índices de tabela `localidade`
--
ALTER TABLE `localidade`
 ADD PRIMARY KEY (`codLocalidade`);

--
-- Índices de tabela `login`
--
ALTER TABLE `login`
 ADD PRIMARY KEY (`codigoLogin`);

--
-- Índices de tabela `quarteirao`
--
ALTER TABLE `quarteirao`
 ADD PRIMARY KEY (`codigo`);

--
-- Índices de tabela `servicotratamentofocal`
--
ALTER TABLE `servicotratamentofocal`
 ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `atividades`
--
ALTER TABLE `atividades`
MODIFY `codigo` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT de tabela `denuncia`
--
ALTER TABLE `denuncia`
MODIFY `codigo` int(6) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
MODIFY `codigoFuncionario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT de tabela `localidade`
--
ALTER TABLE `localidade`
MODIFY `codLocalidade` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de tabela `login`
--
ALTER TABLE `login`
MODIFY `codigoLogin` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de tabela `quarteirao`
--
ALTER TABLE `quarteirao`
MODIFY `codigo` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT de tabela `servicotratamentofocal`
--
ALTER TABLE `servicotratamentofocal`
MODIFY `codigo` int(9) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=32;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
