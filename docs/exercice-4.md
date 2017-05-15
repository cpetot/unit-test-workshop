# Exercice 4 : Mockito & AssertJ level 2

Félicitations pour être arrivé jusqu'ici !
Le but de l'exercice est d'approfondir l'utilisation de AssertJ et Mockito en testant MovieService.

### 1. getByTitle
Ecrivez tous les tests nécessaires.

### 2. Optimisation

Lorsqu'une chaine blanche est passée en paramètre de getByTitle, je ne veux pas effectuer une requête en base de donnée et renvoyer une erreur.
- Réfléchissez aux tests nécessaires.
- Etudiez ce que propose assertThat(aString) pour avoir le test le plus lisible puis écrivez les tests.
- Refactorez la méthode en conséquence (pensez à StringUtils)

### 3. Ajout de findMoviesAvailableForAge

Le but est de retourner uniquement les films qu'on peut voir pour un âge donné en paramètre.
Allez lire la méthode correspondante dans le service : son implémentation est incomplète.
- Réfléchissez aux cas à tester et écrivez un test tirant pleinement partie de AssertJ.
- Etudiez ce que propose assertThat(aList) pour avoir le test le plus lisible puis écrivez les tests.
- Modifiez la méthode pour qu'elle ait le comportement désiré en vous appuyant sur les tests écrits.

