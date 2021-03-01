--
-- Déchargement des données de la table `cryptomoney`
--

INSERT INTO `cryptomoney` (`id`, `nom`, `label`, `prix`) VALUES
(1, 'Bitcoin', 'BTC', 39392),
(2, 'Ethereum', 'ETH', 1251.82),
(3, 'Cardano', 'ADA', 1.06),
(4, 'Binance Coin', 'BNB', 198.63),
(5, 'Tether', 'USDT', 0.83),
(6, 'Polkadot', 'DOT', 29.03),
(7, 'XRP', 'XRP', 0.36),
(8, 'Litecoin', 'LTC', 140.86),
(9, 'Chainlink', 'LINK', 22.04),
(10, 'Stellar', 'XLM', 0.35);


-- --------------------------------------------------------

--
-- Déchargement des données de la table `mycryptomoney`
--

INSERT INTO `mycryptomoney` (`id`, `date`, `nombreUnite`, `prixAchat`, `cryptoId`) VALUES
(1, '2021-03-01', 5, 39352, 1),
(2, '2021-03-01', 3, 1201.82, 2),
(3, '2021-03-01', 6, 199.63, 4),
(4, '2021-03-01', 2, 1.08, 3),
(5, '2021-03-01', 20, 31.03, 6),
(6, '2021-03-01', 26, 139.86, 8),
(7, '2021-03-01', 62, 23.04, 9);
