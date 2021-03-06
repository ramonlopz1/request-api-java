
<h1>Conversor de Moedas em tempo real</h1> 



<p align="center">
    <img src="http://img.shields.io/static/v1?label=License&message=MIT&color=green&style=for-the-badge"/>
    <img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge"/>
</p>

> Status do Projeto: :heavy_check_mark: (concluído)

### Tópicos 

:small_blue_diamond: [Descrição do projeto](#descrição-do-projeto)

:small_blue_diamond: [Funcionalidades](#funcionalidades)

:small_blue_diamond: [Como rodar a aplicação](#como-rodar-a-aplicação-arrow_forward)
 

## Descrição do projeto 

<p align="justify">
  Conversor de moedas em tempo real utilizando os pacotes: java.io, java.net, java.util, java.lang.
  Nele faço uma conexão REST com uma api JSON onde as moedas são atualizadas em tempo real.
  Como é um desafio backend, foquei em tentar trazer um melhor recurso para o app, que foi o de atualização em tempo real, 
  até então nunca tinha feito uma requisição HTTP em Java. Tentei aplicar os conceitos de Clean Code, deixando
  o código mais legível e dividindo as responsabilidades em classes específicas.
    
    Classes:
    - Main: starta a aplicação.
    - OrdemDeExecucao: executa a lógica de passos e renderiza os componentes do aplicativo;
    - Conversao: faz a conversão da moeda original para a moeda conversora;
    - MoneyAPI: faz requisição em api de cotações atualizado em tempo real.

    - ListaDeMoedas: cria um Object que contém as moedas disponíveis para conversão.
    - FormatarMoedas: formata o texto das moedas para obter a sigla de projeção do valor, ex: BRL, USD, MXN;
    - InserirMoedaConversora: renderiza input para inserir a moeda conversora, em seguida retorna a moeda conversora escolhida.
    - InserirMoedaOriginal: renderiza input para inserir a moeda original, em seguida retorna a moeda original escolhida.
    - InserirQuantiaOriginal: renderiza input para inserir a quantia original, em seguida retorna a quantia original informada.
</p>

## Funcionalidades

:heavy_check_mark: Converter moedas 
:heavy_check_mark: HTTP Request

## Layout :dash:

![image](https://user-images.githubusercontent.com/73000131/172507831-c9cb516b-06c6-4cf6-aa0a-af8b02e38ea3.png)

![image](https://user-images.githubusercontent.com/73000131/172507851-6d74bd1f-a707-4938-8d00-687cb68e4ee6.png)

![image](https://user-images.githubusercontent.com/73000131/172507862-031424aa-0a25-4b31-9b1a-8e2a7bf55124.png)

![image](https://user-images.githubusercontent.com/73000131/172507875-e985f7df-8c46-44d6-a016-d6d22fab23ba.png)


## Como rodar a aplicação :arrow_forward:

Navegue até a pasta: \demo\target
Em seguida abra o aplicativo chamado Conversor

No terminal, clone o projeto: 

git clone https://github.com/ramonlopz1/request-api-java.git

## Linguagens, dependencias e pacotes utilizados :books:

- Java;
- Maven;
- SpringBoot;
- java.net; 
- json.JSONObject;
- javax.swing.JOptionPane;
- 

## Desenvolvedores/Contribuintes :octocat:


[<img src="https://avatars.githubusercontent.com/u/73000131?s=400&u=8e56b5ebae13e70129e5b740440beef8a08a0b36&v=4" width=115><br><sub>Ramon Lopes</sub>](https://github.com/settings/profile)

## Licença 

The [MIT License]() (MIT)

Copyright :copyright: 2022 - Ramon Lopes
