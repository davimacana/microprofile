# Jakarta EE + Microprofile

## Gerar executável + start
```bash
mvn clean package
java -jar target/microprofile-basic-wildfly.jar
```

Projeto desenvolvido para arquitetura de microserviços, utilizando Especificação Eclipse MicroProfile.

Microprofile é um projeto open-source que conta com 13 especificações em seu "umbrella MicroProfile specification".

### Dependências utilizadas

- jakarta.jakartaee-api
- microprofile
- resteasy-jaxb-provider
- vertx-auth-jwt
- log4j2

## Informações úteis 

#### Respostas padronizadas com ExceptionMapper
- Para cada exceção esperada no sistema deverá ser criado uma classe de exceção ex.: BusinessException e uma classe de mapeamento
ex.: BusinessExceptionsMapper, assim, sempre que a exceção é lançada a mesma será capturada e através do mapeamento e será instanciado um
dto para retornar os dados do response, de forma padronizada.

#### Api Restfull
- Os recursos da aplicação estão localizados no pacote com.microprofile.resource, criados utilizando a especificação jaxrs

#### Autenticação JWT


#### Configuração externa
- Como boa prática os recursos de configuração da aplicação ficam em local externo, e são carregados por injeção via CDI

#### Log
- Padrão POA (Programação orientada a aspectos) para registro de log. Todas as classes ou métodos que serão interceptados para registro de log devem ser anotadas com a anotação @Logger
- Log4j2 configurado para escrever o log em local centralizado, externa a aplicação
