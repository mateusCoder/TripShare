# TripShare 🚙🌅

<div align="center">
  <a href="https://www.java.com/pt-BR/" target="_blank" rel="noreferrer" rel="noopener">
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java"/>
  </a>
  <a href="https://spring.io/" target="_blank" rel="noreferrer" rel="noopener">
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring"/>
  </a>
  <a href="https://git-scm.com/" target="_blank" rel="noreferrer" rel="noopener">
    <img src="https://img.shields.io/badge/Git-E34F26?style=for-the-badge&logo=git&logoColor=white" alt="Git"/>
  </a>
  <a href="https://www.microsoft.com/pt-br/windows/?r=1" target="_blank" rel="noreferrer" rel="noopener">
  <img src="https://img.shields.io/badge/Windows-017AD7?style=for-the-badge&logo=windows&logoColor=white" alt="Windows"/>
</div></br>

<div align="center">
  <img src="TripShareLogo.jpg" alt="TripShare" height="350px">
</div></br>

> O TripShare é uma plataforma que controla gastos de combustivel de acordo com os dados cadastrados de distância, consumo do veiculo, preço do combustível e tripulantes do carro, a partir disso é possível pelo nome do tripulante e um intervalo de datas, consultar quais datas aquela pessoa viajou e qual o valor total das mesmas.

## ⚙️ Funcionalidades

- [x] Passageiros e Motoristas podem se cadastrar enviando:
  - Nome
  - Email
  - Senha
  - Informando se são motoristas ou não. 
  - [x] Visualizar, alterar e deletar seus dados;
  - [x] Consultar quais datas viajou e a despesa total de um determinado intervalo de tempo enviando:
  - Nome da pessoa 
  - Data Inicial
  - Data Final
- [x] Os dados da viagem podem ser cadastradas inserindo:
  - Nome
  - Distância
  - Consumo de combustível do veículo 
  - Preço do combustível
- [x] A corrida será calculada ao inserir:
  - Nome dos tripulantes do veiculo naquela viagem
  - Número de identificação dos dados de Viagem cadastrados
  - Data da corrida
  

## 📈 Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:

- [x] Documentação com Swagger
- [ ] Segurança com JWT
- [ ] Deploy no Heroku
- [ ] Interface Gráfica

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

* Ter instalado a  linguagem `Java JDK 17 LTS`.
* Ter instalado a IDE `IntelliJIDEA` ou `Eclipse Spring`. 
* Ter uma máquina `Windows 10` ou `11`.

## 🚀 Instalação

Passo-a-passo que informa o que você deve executar para ter um ambiente de desenvolvimento em execução.

```
# Clone este repositório
$ git clone git@github.com:mateusCoder/TripShare.git

# Acesse a pasta do projeto no seu terminal
$ code .

# Selecione a IDE desejada

# Execute a aplicação em modo de desenvolvimento

# A aplicação será aberta na porta:8080 - acesse http://localhost:8080
```

## 🧑‍🚀 Postman

Para acessar a collection TripShare, baixe o arquivo e siga as etapas:
1. [TripShareCollection](https://github.com/mateusCoder/TripShare/tripShareCollection.json)
2. Abra a plataforma [Postman](https://www.postman.com/product/what-is-postman/)
3. Em seguida importe, clique em Import e selecione o arquivo TripShareCollection.
4. Por fim, execute o aplicação TripShareApplication, após isso a plataforma estará pronta para uso. 

## 📌 EndPoints
Para acessar os endpoints da Entidade Pessoa:
```
  GET - /tripShare/people         (Lista todos as pessoas cadastradas) 
  GET - /tripShare/people/{id}    (Detalha o cadastro de uma pessoa existente pelo ID)
  POST - /tripShare/people        (Cadastra uma nova pessoa) 
  PUT - /tripShare/people/{id}    (Atualiza o cadastro de uma pessoa existente pelo ID) 
  DELETE - /tripShare/people/{id} (Remove o cadastro de uma pessoa existente pelo ID) 
```
Para acessar os endpoints da Entidade Trip:
```
  GET - /tripShare/trips         (Lista todos as viagens cadastrados) 
  GET - /tripShare/trips         (Detalha o cadastro de uma viagem existente pelo ID)
  POST - /tripShare/trips        (Cadastra uma nova viagem) 
  PUT - /tripShare/trips/{id}    (Atualiza o cadastro de uma viagem existente pelo ID) 
  DELETE - /tripShare/trips/{id} (Remove o cadastro de uma viagem existente pelo ID) 
```
Para acessar os endpoints da Entidade Ride:
```
  GET - /tripShare/rides           (Lista as corridas cadastradas) 
  POST - /tripShare/rides          (Cadastra uma nova corrida para uma tripulação) 
  PUT - /tripShare/rides/{id}      (Atualiza uma corrida existente pelo ID) 
  DELETE - /tripShare/rides/{id}   (Remove uma corrida existente pelo ID) 
```
Para acessar os endpoints da Entidade Record:
```
  GET - /tripShare/records         (Lista as datas e o preço total das corridas de acordo com o intervalo de tempo e pessoa informada) 
```

## 🕷️ Testes
Foram usadas as seguintes tecnologias e ferramentas para Testes da API: 
* [JUnit 5](https://junit.org/junit5/docs/current/user-guide/) - Framework de Testes
* [Mockito](https://site.mockito.org/) - Estrutura de Testes

## 🚧🛠️ Tecnologias e Ferramentas
  
Foram usadas as seguintes tecnologias e ferramentas para a construção da API: 
* [Java](https://www.java.com/pt-BR/) - Linguagem de Programação
* [SpringBoot](https://spring.io/) - FrameWork Java
* [Git](https://git-scm.com/) - Ferramenta de Versionamento de Código
* [H2](https://www.h2database.com/html/main.html) - Sistema de gerenciamento de banco de dados relacional
* [IntelliJIDEA](https://www.jetbrains.com/pt-br/idea/) - IDE (Ambiente de desenvolvimento integrado)
* [Postman](https://www.postman.com/) - Plataforma da API
* [Swagger](https://swagger.io/tools/swagger-editor/) - Editar de design da API
* [Windows](https://www.microsoft.com/pt-br/windows/?r=1) - Sistema Operacional

## ☎️ Suporte TripShare
  
Caso tenha dúvidas, reclamações ou sugestões, contate os desenvolvedores. 

## 👩‍💻👨‍💻 Desenvolvedores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/76978080?v=4" width="100px;" alt="Foto do Mateus Cardoso"/><br>
        <sub>
          <div align="center">
            <b>Mateus Cardoso</b></br></br>
            <a href="https://www.linkedin.com/in/mateus-cardoso-de-moraes/" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin"/>
            </a></br>
            <a href="mailto:mateus.moraes0507@gmail.com" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" alt="Gmail"/></br>
            </a>
          </div>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/82002133?v=4" width="100px;" alt="Foto do Otávio Mello"/><br>
        <sub>
          <div align="center">
            <b>Otávio Mello</b></br></br>
            <a href="https://www.linkedin.com/in/ot%C3%A1viomelloalmeida/" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin"/>
            </a></br>
            <a href="mailto:otaviomellocv@gmail.com" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" alt="Gmail"/></br>
            </a>
          </div>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/51124985?v=4" width="100px;" alt="Foto do Yhonathan Pavan"/><br>
        <sub>
          <div align="center">
            <b>Yhonatan Pavan</b></br></br>
            <a href="https://www.linkedin.com/in/yhonathan-pavan/" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin"/>
            </a></br>
            <a href="mailto:yhonathannpavan@gmail.com" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" alt="Gmail"/></br>
            </a>
          </div>
        </sub>
      </a>
    </td>
  </tr>
</table>

[⬆ Voltar ao topo](#BicoOn)<br>


