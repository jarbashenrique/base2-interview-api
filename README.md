# Petstore API Test Project

Este projeto consiste em testar a API pública [Swagger Petstore](https://petstore.swagger.io/) utilizando a biblioteca **RestAssured** para realizar as chamadas HTTP e **JUnit 5** para estruturar os testes. Os testes cobrem cenários de sucesso e falha, assegurando que as respostas estejam de acordo com as expectativas de negócio.

## Estrutura do Projeto

O projeto foi estruturado seguindo boas práticas de organização de código e está dividido em:

- **`/src/main`**: Normalmente reservado para código-fonte, mas neste projeto não contém arquivos, pois o foco é apenas nos testes.
- **`/src/test`**: Contém os arquivos de teste utilizando **RestAssured** e **JUnit 5**.
  - **Page Object**: A classe `PetStoreApi` contém os métodos reutilizáveis para as chamadas à API (POST, GET, PUT).
  - **Testes**: Os testes estão na classe `PetStoreTest` e cobrem os cenários solicitados.

## Requisitos

- **Linguagem de Programação**: Java 11+
- **Biblioteca de Teste de API**: RestAssured (versão 4.4.0)
- **Framework de Teste**: JUnit 5 (versão 5.7.0)
- **Gerenciamento de dependências**: Maven

## Casos de Teste Implementados

1. **Cadastrar novo pedido de pet com sucesso (POST /store/order)**  
   Cadastra um novo pedido de pet e valida se o status do pedido é "placed".

2. **Pesquisar por um pet inexistente (GET /pet/{petId})**  
   Valida que o sistema retorna um erro 404 ao tentar buscar um pet inexistente.

3. **Atualizar dados de um pet existente (PUT /pet)**  
   Atualiza os dados de um pet existente e valida se as informações foram alteradas corretamente.

4. **Pesquisar por pets com status "pending" (GET /pet/findByStatus)**  
   Valida que a API retorna uma lista de pets com o status "pending".

5. **Cenários Negativos**  
   Além dos casos de sucesso, também foram implementados testes para cobrir cenários de erro, como cadastrar pedido sem dados e buscar pets com status inválido.

## Como Executar os Testes

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu ambiente:

- **Java JDK 11 ou superior**.
- **Maven** para gerenciamento de dependências e execução dos testes.

### Instalação

1. Clone o repositório do projeto:
   ```bash
   git clone https://github.com/jarbashenrique/base2-interview-api.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd petstore-api-tests
   ```

3. Para garantir que todas as dependências estão atualizadas, execute:
   ```bash
   mvn clean install
   ```

### Executando os Testes

Para executar todos os testes, basta rodar o seguinte comando no diretório raiz do projeto:

```bash
mvn -Dtest=PetStoreTest test    
```

O **Maven Surefire Plugin** irá rodar os testes localizados na pasta `src/test/java`.

### Relatório de Resultados

Os resultados dos testes serão exibidos diretamente no console após a execução do Maven. Logs detalhados e relatórios de execução são gerados no diretório:

```
/target/surefire-reports
```

## Licença

Este projeto é licenciado sob a [MIT License](https://opensource.org/licenses/MIT).

## Contato

Se tiver dúvidas ou sugestões, entre em contato [jarbas_96@hotmail.com](mailto:jarbas_96@hotmail.com).

---

**Desenvolvido por [Jarbas Batista]**
