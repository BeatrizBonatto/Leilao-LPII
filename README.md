#  Projeto Leilão - LP2

Este projeto utiliza **Quarkus**, o framework Java Supersônico Subatômico.  
Saiba mais em: https://quarkus.io/

## Rodando a aplicação no modo de desenvolvimento

Para executar a aplicação no modo de desenvolvimento, que habilita live coding, use o comando:

```shell script
./mvnw compile quarkus:dev
```

> **_Nota:_** O Quarkus fornece uma interface Dev UI acessível apenas no modo de desenvolvimento:  <http://localhost:8080/q/dev/>



## Empacotando e executando a aplicação

Você pode empacotar a aplicação com:

```shell script
./mvnw package
```

Ele produz o arquivo `quarkus-run.jar` no diretório `target/quarkus-app/`. Esteja ciente de que não é um über-jar, pois as dependências são copiadas para o diretório `target/quarkus-app/lib/`.

O aplicativo agora pode ser executado usando `java -jar target/quarkus-app/quarkus-run.jar`.

Se você quiser criar um über-jar, execute o seguinte comando:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

O aplicativo, empacotado como um über-jar, agora pode ser executado usando `java -jar target/*-runner.jar`.

## Criando um executável nativo

Para criar um executável nativo:

```shell script
./mvnw package -Dnative
```

Caso não tenha o GraalVM instalado, você pode usar um contêiner para construir o executável nativo:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

Você pode então executar seu executável nativo com: `./target/leilao-lp2-1.0.0-SNAPSHOT-runner`

Saiba mais sobre a criação de executáveis nativos em  <https://quarkus.io/guides/maven-tooling>

## Guias relacionados

- REST ([guia](https://quarkus.io/guides/rest)): Uma implementação REST Jakarta que utiliza processamento de tempo de construção e Vert.x. Esta extensão não é compatível com a extensão quarkus-resteasy, ou qualquer uma das extensões que dependem dela.
- Hibernate ORM ([guia](https://quarkus.io/guides/hibernate-orm)): Defina seu modelo persistente com Hibernate ORM e Jakarta Persistence
- Driver JDBC - H2 ([guia](https://quarkus.io/guides/datasource)): Conecte-se ao banco de dados H2 via JDBC
- SmallRye OpenAPI ([guia](https://quarkus.io/guides/openapi-swaggerui)): Documente suas APIs REST com OpenAPI - vem com Swagger UI
- REST Jackson ([guia](https://quarkus.io/guides/rest#json-serialisation)): Suporte à serialização Jackson para Quarkus REST. Esta extensão não é compatível com a extensão quarkus-resteasy, ou qualquer uma das extensões que dependem dela

## Código fornecido

### Hibernate ORM

Crie sua primeira entidade JPA

[Seção de guia relacionada...](https://quarkus.io/guides/hibernate-orm)

### REST

Inicie facilmente seus serviços REST Web

[Seção de guia relacionada...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

---

## Instalação do Java 11

Devido ao uso do banco de dados H2, o projeto precisa do **Java 11** para funcionar corretamente.  
Siga o guia de instalação abaixo para configurar o Java 11 no seu sistema.

### Pré-requisitos:
- Sistema Operacional: Windows, Linux ou macOS.
- Permissões: Acesso como administrador na máquina.

### Baixar o JDK 11
1. Acesse o site oficial da Oracle:  
 [Download do JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
2. Escolha o instalador para o seu sistema operacional:
   - Windows: `.exe`
   - Linux: `.tar.gz`
   - macOS: `.dmg`
3. Baixe o arquivo.

---

### Instalação no Windows
1. Localize o instalador baixado (`jdk-11_windows-x64_bin.exe`) e execute-o.
2. Siga as instruções:
   - Clique em Next para aceitar as configurações padrão.
   - Aguarde até que a instalação termine.
3. Configure as variáveis de ambiente:
   - Abra o Painel de Controle > Sistema > Configurações Avançadas do Sistema.
   - Clique em Variáveis de Ambiente.
   - Em Variáveis do Sistema, encontre `Path` e clique em Editar.
   - Adicione o caminho do diretório `bin` do Java (exemplo: `C:\Program Files\Java\jdk-11\bin`).

4. Verifique a instalação:
   - Abra o Prompt de Comando e execute:
     
     java -version
     
   - Deve aparecer a versão do Java 11.

---

### Instalação no Linux
1. Abra o terminal e atualize os pacotes:
   
   sudo apt update

2. Instale o JDK 11:
   
   sudo apt install openjdk-11-jdk

3. Verifique a instalação:
   
   java -version

   O terminal deve exibir a versão do Java 11.

4. Verifique a instalação:
   
   java -version

   O terminal deve exibir a versão do Java 11.

---

🎉 Pronto! Agora você pode executar o projeto Leilão com o Java 11 configurado.
