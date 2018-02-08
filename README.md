# Workshop de tests unitaires

Il s'agit d'un projet Spring Boot 2 en Java 8.
Le but est d'apprendre à utiliser Junit, Mockito et AssertJ.
La base de données est H2 en mémoire.
Il n'y a pas d'IHM mais Swagger permet d'appeler facilement l'API.

## Prérequis

* Java 8
* [Apache Maven 3.x](http://maven.apache.org/)
* Git

## How to

1. Cloner le projet

    ```
    $ git clone https://github.com/cpetot/unit-test-workshop.git
    ```

2. Exécuter le projet
    En ligne de commande :
    ```
    $ mvn spring-boot:run
    ```


    Via la classe Application : lancez la méthode main()

3. Accéder a:

    ```
    http://localhost:8080
    ```

4. Effectuez les exercices du répertoire doc.