# authentication-example

Autenticação simples utilizando Quarkus e uma imagem Docker do Keycloack, utilizando três perfis de usuário (Admin, Aluno, Professor).

Também se utiliza uma simples interface para simulação desta autenticação.

# Keycloack 16.1.1

Para facilitar o uso deste exemplo instale a seguinte imagem docker:
```shell script
docker run --name myKeyCloak -p 8089:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -d jboss/keycloak:16.1.1
```
