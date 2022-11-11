<img src="https://img.shields.io/badge/Status-Concluido-brightgreen"> <img src="https://img.shields.io/badge/README-Em Construção-yellow">
<div align="center">
<h1 align="center">Projeto To-Do</h1>
<h5 align="center"> Tecnologias usadas no projeto </h5>
<img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white"/>
<img src="https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=Docker&logoColor=white"/>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/>
<img src="https://img.shields.io/badge/Intellij-000000?style=flat-square&logo=Intellij IDEA&logoColor=white"/>
<img src="https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=Apache Maven&logoColor=white"/>
<img src="https://img.shields.io/badge/Postman-FF6C37?style=flat-square&logo=Postman&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=Spring Security&logoColor=white"/>
<img src="https://img.shields.io/badge/Swagger-85EA2D?style=flat-square&logo=Swagger&logoColor=white"/>
</div>

<h2>O que é o Projeto To-Do</h2>
<p>Uma aplicação web com back-end desenvolvido em Java + Spring Boot e front-end em Angular, que tem como intuito gerenciar tarefas inseridas por um usuário. Cada tarefa consiste de uma data para finalizar especificada pelo usuário, um título e uma descrição opcional.</p>


<h2>O que podemos fazer com a aplicação?</h2>
<p>No atual momento podemos adicionar novas tarefas, editar e excluir tarefas já existentes.</p>

<h2>Instalação</h2>

<h3>Rodando o backend do projeto</h3>
<p>Clone o projeto com: </p>

```
 git clone https://github.com/mmacedoaraujo/to-do-list-application.git
```

<p>Após clonar o repositório na sua máquina, navegue para a pasta do backend:</h3>

```
 cd todo-list-backend
```

<p>Em seguida abra-o como projeto Maven em uma IDE</p>

<p>Assim que o backend tiver rodando, você poderá acessar os endpoints através do endereço:</p>

```
 http://localhost:8080/todos
```


<h3>Rodando o frontend do projeto</h3>

<h4>Instalando o Node</h4>
<p>Antes de seguir em frente, instale o <a href="https://nodejs.org/en/">Node.js</a>. Mas atenção, na data de hoje (10/11/2022) a última versão LTS do Node (18.12.1) está gerando incompatibilidade com o projeto, recomendo baixar a versão 16 LTS do Node.</p>

<p>Você pode verificar se o Node foi instalado na sua máquina executando o comando abaixo no terminal: </p>

```
 node --version
```
<hr>

<h4>Executando o frontend</h4>

<p>Após clonar o repositório na sua máquina, navegue para a pasta do frontend</p>

```
 cd todo-list-frontend
```

<p>Agora vamos instalar o Command Line Interface ou CLI do Angular com o comando:</p>

```
 npm install -g @angular/cli
```

<p>Execute o comando abaixo para instalar as dependências do projeto:</p>

```
 npm install
```
<p>Agora subiremos o servidor local com:</p>

```
 npm serve
```

<p>E para acessar a aplicação é só inserir no navegador: </p>

```
 http://localhost:4200
```
