# App-Flow-React-Native: Branch `apiFlow`

[![Branch: apiFlow](https://img.shields.io/badge/Branch-apiFlow-blue.svg)](https://github.com/LeoSousaJesus/App-Flow-React-Native/tree/apiFlow)

Este repositório contém o código-fonte de um aplicativo móvel simples de **temporizador Pomodoro** desenvolvido com **React Native**.

A branch `apiFlow` é dedicada à **implementação e integração de um fluxo de API** no aplicativo. O objetivo principal é mover a aplicação de um estado puramente local para uma arquitetura que possa interagir com serviços de backend, seja para persistência de dados (como histórico de sessões Pomodoro), autenticação de usuário, ou obtenção de configurações dinâmicas.

## Status da Branch

Esta branch está em **desenvolvimento ativo**.

| Status | Detalhes |
| :--- | :--- |
| **Base** | Forked de `main` |
| **Progresso** | 1 commit à frente de `main` (indicando o início da implementação do fluxo de API) |
| **Sincronização** | 8 commits atrás de `main` (pode ser necessário um rebase ou merge para atualizar com o desenvolvimento mais recente da `main`) |

## Tecnologias Utilizadas

O projeto é construído com as seguintes tecnologias principais:

*   **React Native:** Framework para desenvolvimento de aplicativos móveis multiplataforma.
*   **JavaScript:** Linguagem de programação principal.
*   **API Integration:** Foco na utilização de bibliotecas como `axios` ou `fetch` para comunicação HTTP.

## Funcionalidades da Branch `apiFlow`

O foco desta branch é a introdução de funcionalidades relacionadas à comunicação com um backend:

*   **Estrutura de Serviço:** Criação de uma camada de serviço ou *client* para gerenciar chamadas de API.
*   **Fluxo de Dados:** Implementação de *hooks* ou lógica para buscar, enviar e manipular dados através da API.
*   **Tratamento de Estado:** Gerenciamento do estado da aplicação (e.g., *loading*, *error*, *success*) durante as operações de API.

## Instalação e Execução

Para clonar e executar esta branch do projeto, siga os passos abaixo:

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/LeoSousaJesus/App-Flow-React-Native.git
    ```

2.  **Navegue para o diretório do projeto:**
    ```bash
    cd App-Flow-React-Native
    ```

3.  **Mude para a branch `apiFlow`:**
    ```bash
    git checkout apiFlow
    ```

4.  **Instale as dependências:**
    ```bash
    npm install # ou yarn install
    ```

5.  **Execute o aplicativo:**
    *   Para Android: `npm run android`
    *   Para iOS: `npm run ios` (Requer ambiente macOS)

## Contribuição

Contribuições são bem-vindas! Se você tiver sugestões ou quiser melhorar o fluxo de API, sinta-se à vontade para abrir uma *Issue* ou um *Pull Request* na branch `apiFlow`.
