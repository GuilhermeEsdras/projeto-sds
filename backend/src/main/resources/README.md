# Propertis explanation

## Macete do JPA
```properties
spring.jpa.open-in-view=false
```

Com essa propriedade, toda a parte de transação e conexão com o banco de dados é resolvida na camada de serviço. \
Não deve-se ter conexão com o banco aberta ou transação pendente quando for para a camada de controlador.


## Perfil
```properties
spring.profiles.active=test
```

Com essa propriedade, o projeto será executado em modo teste. \
O spring detecta o nome "test" e busca pelo arquivo "application-test.properties",
executando as propriedades configuradas nesse arquivo, e eodando, dessa forma, 
o banco de dados H2.


## Configurações do Banco de Dados H2 no perfil Test

### Path de conexão
```properties
spring.datasource.url=jdbc:h2:mem:testdb
```

- URL/Caminho para acessar o Banco em memória.

### Login
```properties
spring.datasource.username=sa
```

- Usuário `sa`

```properties
spring.datasource.password=
```

- Senha vazia


### Configurações do cliente de administração do banco H2

Aplicação web acessada via navegador para gerenciar o banco de dados.

#### Habilita o cliente gerenciador
```properties
spring.h2.console.enabled=true
```

#### Endereço para acesso
```properties
spring.h2.console.path=/h2-console
```


### Exibição de SQL no terminal

#### Exibir SQL no terminal
```properties
spring.jpa.show-sql=true
```

- Exibe no terminal as consultas feitas no banco.

```properties
spring.jpa.properties.hibernate.format_sql=true
```
