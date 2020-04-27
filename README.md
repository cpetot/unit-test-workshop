# Workshop de tests unitaires

Il s'agit d'un projet Spring Boot 2.2 en Java 11, avec une base de données H2 en mémoire.

Il n'y a pas d'IHM mais Swagger permet d'appeler facilement l'API.

**NB** : l'architecture du projet est simpliste et ne doit pas servir de modèle.

## But
Le but est d'apprendre à utiliser **Junit 5**, **Mockito** et **AssertJ**.

Le dernier exercice donne un aperçu sur **ArchUnit**.

## Prérequis

* [Java 11](https://adoptopenjdk.net/)
* [Maven 3.8+](http://maven.apache.org/)
* Git

## How to

1. Cloner le projet

    ```
    $ git clone https://github.com/cpetot/unit-test-workshop.git
    ```

2. Exécuter le projet
    - En ligne de commande :
    ``
    $ mvn spring-boot:run
    ``
    - Ou via  la classe [WorkshopUnitTestsApplication](src/main/java/com/cpetot/workshop/tu/WorkshopUnitTestsApplication) : lancez la méthode `main()`

3. Accéder à [http://localhost:8080](http://localhost:8080)

4. Effectuez les exercices du répertoire [docs](docs/exercice-1.md).
