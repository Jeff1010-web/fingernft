export default [
  {
    label: "Mainnet",
    options: [
      {
        network: "ETH",
        chainId: 1,
        name: "Ethereum",
        symbol: "ETH",
        explorer: "https://etherscan.io",
        blockTime: 12,
        opensea: "https://opensea.io/assets",
      },
      {
        network: "BSC",
        chainId: 56,
        name: "BSC Mainnet",
        symbol: "BNB",
        explorer: "https://bscscan.com",
        blockTime: 3,
        opensea: "",
      },
      {
        network: "HOUBI",
        chainId: 128,
        name: "heco-mainnet",
        symbol: "HT",
        explorer: "https://hecoinfo.com",
        blockTime: 3,
        opensea: "",
      },
      {
        network: "MATIC",
        chainId: 137,
        name: "Polygon Mumbai",
        symbol: "MATIC",
        explorer: "https://explorer.matic.network/",
        blockTime: 3,
        opensea: "https://opensea.io/assets",
      },
    ],
  },
  {
    label: "Testnet",
    options: [
      {
        network: "ETH Goerli",
        chainId: 5,
        name: "ETH Goerli",
        symbol: "ETH",
        explorer: "https://goerli.etherscan.io/",
        blockTime: 12,
        opensea: "https://testnets.opensea.io/assets/goerli",
      },
      {
        network: "BSC Testnet",
        chainId: 97,
        name: "BSC Testnet",
        symbol: "BNB",
        explorer: "https://testnet.bscscan.com",
        blockTime: 3,
        opensea: "https://testnets.opensea.io/assets",
      },
      {
        network: "HOUBI Testnet",
        chainId: 256,
        name: "heco-testnet",
        symbol: "HT",
        explorer: "https://testnet.hecoinfo.com",
        blockTime: 3,
        opensea: "",
      },
      {
        network: "MATIC Testnet",
        chainId: 80001,
        name: "Polygon Mumbai Testnet",
        symbol: "MATIC",
        explorer: "https://mumbai.polygonscan.com/",
        blockTime: 3,
        opensea: "https://testnets.opensea.io/assets",
      },
    ],
  },
  {
    label: "Other",
    options: [
      {
        network: "Other",
      },
    ],
  },
];
