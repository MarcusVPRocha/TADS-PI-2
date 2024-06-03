-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 20/05/2024 às 12:31
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `techeasy`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `empresa`
--

CREATE TABLE `empresa` (
  `Id` smallint(6) NOT NULL,
  `CNPJ` varchar(14) NOT NULL,
  `NomeFantasia` varchar(100) DEFAULT NULL,
  `CEP` varchar(50) DEFAULT NULL,
  `Rua` varchar(150) DEFAULT NULL,
  `Numero` varchar(100) DEFAULT NULL,
  `Bairro` varchar(150) DEFAULT NULL,
  `Estado` varchar(100) DEFAULT NULL,
  `Email` varchar(150) DEFAULT NULL,
  `Ramo` varchar(100) DEFAULT NULL,
  `Tel` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `empresa`
--

INSERT INTO `empresa` (`Id`, `CNPJ`, `NomeFantasia`, `CEP`, `Rua`, `Numero`, `Bairro`, `Estado`, `Email`, `Ramo`, `Tel`) VALUES
(1, '00000000000000', 'TechEasy', '00000000', 'João da Silva Santos', 'ZeroUm', 'Barroso', 'DiEspirito: Baixo', 'algumacoisa@gmail.com', '\'Tech\'nicamente Nenhum', '0119999999'),
(3, '1000000000000', 'Hamburgueria do José', '', '', '', '', '', '', 'Alimentos Saudavéis', '');

-- --------------------------------------------------------

--
-- Estrutura para tabela `maquinario`
--

CREATE TABLE `maquinario` (
  `Id` smallint(6) NOT NULL,
  `nome` varchar(70) DEFAULT NULL,
  `quantidade` smallint(6) DEFAULT NULL,
  `tempoManutencao` smallint(6) DEFAULT NULL,
  `prazoManutencao` smallint(6) DEFAULT NULL,
  `taxaDepreciacao` smallint(6) DEFAULT NULL,
  `descricao` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `maqui_pro`
--

CREATE TABLE `maqui_pro` (
  `fk_Maquinario_Id` smallint(6) DEFAULT NULL,
  `fk_Processos_id` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `material`
--

CREATE TABLE `material` (
  `id` smallint(6) NOT NULL,
  `nome` varchar(70) DEFAULT NULL,
  `unidadeMedida` varchar(30) DEFAULT NULL,
  `quantidadeEstoque` smallint(6) DEFAULT NULL,
  `prazoValidade` smallint(6) DEFAULT NULL,
  `classificacao` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `mat_pro`
--

CREATE TABLE `mat_pro` (
  `fk_Processos_id` smallint(6) DEFAULT NULL,
  `fk_Material_id` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `montagem`
--

CREATE TABLE `montagem` (
  `id` smallint(6) NOT NULL,
  `nome` varchar(70) DEFAULT NULL,
  `especificacao` varchar(150) DEFAULT NULL,
  `tempoExecucao` smallint(6) DEFAULT NULL,
  `finalidade` varchar(150) DEFAULT NULL,
  `descricao` varchar(500) DEFAULT NULL,
  `fk_Maquinario_Id` smallint(6) DEFAULT NULL,
  `fk_Material_id` smallint(6) DEFAULT NULL,
  `fk_Subproduto_id` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `processos`
--

CREATE TABLE `processos` (
  `id` smallint(6) NOT NULL,
  `nome` varchar(70) DEFAULT NULL,
  `tempoExecucao` smallint(6) DEFAULT NULL,
  `indicativoQualidade` smallint(6) DEFAULT NULL,
  `qtdProducao` smallint(6) DEFAULT NULL,
  `descricao` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos`
--

CREATE TABLE `produtos` (
  `id` smallint(6) NOT NULL,
  `nome` varchar(70) DEFAULT NULL,
  `descricao` varchar(500) DEFAULT NULL,
  `quantidade` smallint(6) DEFAULT NULL,
  `marca` varchar(70) DEFAULT NULL,
  `tipificacao` varchar(70) DEFAULT NULL,
  `fk_Empresa_id` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `produtos`
--

INSERT INTO `produtos` (`id`, `nome`, `descricao`, `quantidade`, `marca`, `tipificacao`, `fk_Empresa_id`) VALUES
(1, 'X-Tudo', '', 1, 'Propria', 'Hamburguer', 3),
(2, 'X-Salada', '', 1, 'Propria', 'Hamburguer', 3);

-- --------------------------------------------------------

--
-- Estrutura para tabela `subproduto`
--

CREATE TABLE `subproduto` (
  `id` smallint(6) NOT NULL,
  `nome` varchar(70) DEFAULT NULL,
  `descricao` varchar(500) DEFAULT NULL,
  `finalidade` varchar(150) DEFAULT NULL,
  `quantidade` smallint(6) DEFAULT NULL,
  `fk_Processos_id` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `Id` smallint(6) NOT NULL,
  `Usuario` varchar(100) DEFAULT NULL,
  `Senha` varchar(100) DEFAULT NULL,
  `Apelido` varchar(150) DEFAULT NULL,
  `Email` varchar(150) DEFAULT NULL,
  `Tel` varchar(12) DEFAULT NULL,
  `Atribuicao` varchar(50) DEFAULT NULL,
  `fk_Empresa_Id` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuarios`
--

INSERT INTO `usuarios` (`Id`, `Usuario`, `Senha`, `Apelido`, `Email`, `Tel`, `Atribuicao`, `fk_Empresa_Id`) VALUES
(1, 'Administrador', '1234', 'Admin', 'algumacoisa@gmail.com', '0119999999', 'Administrador', 1),
(2, 'Gerente', '1234', 'Gere', '', '', 'Gerente', 1),
(3, 'Estagiario', '1', 'Fulano', '', '', 'Estagiario', 1),
(4, 'Seu Jose', '1', 'Zé', '', '', 'Gerente', 3);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `CNPJ` (`CNPJ`);

--
-- Índices de tabela `maquinario`
--
ALTER TABLE `maquinario`
  ADD PRIMARY KEY (`Id`);

--
-- Índices de tabela `maqui_pro`
--
ALTER TABLE `maqui_pro`
  ADD KEY `FK_Realiza___Maqui_Pro_1` (`fk_Maquinario_Id`),
  ADD KEY `FK_Realiza___Maqui_Pro_2` (`fk_Processos_id`);

--
-- Índices de tabela `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `mat_pro`
--
ALTER TABLE `mat_pro`
  ADD KEY `FK_Utiliza___Mat_Pro_1` (`fk_Processos_id`),
  ADD KEY `FK_Utiliza___Mat_Pro_2` (`fk_Material_id`);

--
-- Índices de tabela `montagem`
--
ALTER TABLE `montagem`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Montagem_2` (`fk_Maquinario_Id`),
  ADD KEY `FK_Montagem_3` (`fk_Material_id`),
  ADD KEY `FK_Montagem_4` (`fk_Subproduto_id`);

--
-- Índices de tabela `processos`
--
ALTER TABLE `processos`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Produtos_2` (`fk_Empresa_id`);

--
-- Índices de tabela `subproduto`
--
ALTER TABLE `subproduto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Subproduto_2` (`fk_Processos_id`);

--
-- Índices de tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Usuarios_2` (`fk_Empresa_Id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `empresa`
--
ALTER TABLE `empresa`
  MODIFY `Id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `maquinario`
--
ALTER TABLE `maquinario`
  MODIFY `Id` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `material`
--
ALTER TABLE `material`
  MODIFY `id` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `montagem`
--
ALTER TABLE `montagem`
  MODIFY `id` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `processos`
--
ALTER TABLE `processos`
  MODIFY `id` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `subproduto`
--
ALTER TABLE `subproduto`
  MODIFY `id` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `maqui_pro`
--
ALTER TABLE `maqui_pro`
  ADD CONSTRAINT `FK_Realiza___Maqui_Pro_1` FOREIGN KEY (`fk_Maquinario_Id`) REFERENCES `maquinario` (`Id`),
  ADD CONSTRAINT `FK_Realiza___Maqui_Pro_2` FOREIGN KEY (`fk_Processos_id`) REFERENCES `processos` (`id`);

--
-- Restrições para tabelas `mat_pro`
--
ALTER TABLE `mat_pro`
  ADD CONSTRAINT `FK_Utiliza___Mat_Pro_1` FOREIGN KEY (`fk_Processos_id`) REFERENCES `processos` (`id`),
  ADD CONSTRAINT `FK_Utiliza___Mat_Pro_2` FOREIGN KEY (`fk_Material_id`) REFERENCES `material` (`id`);

--
-- Restrições para tabelas `montagem`
--
ALTER TABLE `montagem`
  ADD CONSTRAINT `FK_Montagem_2` FOREIGN KEY (`fk_Maquinario_Id`) REFERENCES `maquinario` (`Id`),
  ADD CONSTRAINT `FK_Montagem_3` FOREIGN KEY (`fk_Material_id`) REFERENCES `material` (`id`),
  ADD CONSTRAINT `FK_Montagem_4` FOREIGN KEY (`fk_Subproduto_id`) REFERENCES `subproduto` (`id`);

--
-- Restrições para tabelas `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `FK_Produtos_2` FOREIGN KEY (`fk_Empresa_id`) REFERENCES `empresa` (`Id`);

--
-- Restrições para tabelas `subproduto`
--
ALTER TABLE `subproduto`
  ADD CONSTRAINT `FK_Subproduto_2` FOREIGN KEY (`fk_Processos_id`) REFERENCES `processos` (`id`);

--
-- Restrições para tabelas `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FK_Usuarios_2` FOREIGN KEY (`fk_Empresa_Id`) REFERENCES `empresa` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
