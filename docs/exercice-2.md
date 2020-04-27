# Exercice 2 : On combine avec Mockito

Le but de l'exercice est d'apprendre à utiliser Mockito et d'écrire en TDD.

**NB** : Pensez aux méthodes `Mockito.mock`, `Mockito.verify`, etc.

### 1. Ajout du dernier visionnage d'un film.

Lorsqu'un film est ajouté à la liste des films vus par un utilisateur,
je veux que la date de dernier visionnage du film soit mise à jour.
Cette colonne existe déjà mais n'est actuellement jamais renseignée.

Quelles modifications dans le code proposez-vous ?
Ecrivez les cas de test correspondants.


### 2. Refactoring

Allez lire la méthode `UserService#addToWatchList`.

Le code vous semble-t-il correctement placé ?

Quelle(s) suggestion d'amélioration avez-vous ?

- Commencez cette fois par écrire les cas de test correspondants.
- Les tests doivent être non passants car l'implémentation n'a pas encore été faite.
- Modifiez l'implémentation jusqu'à ce que les tests passent et arrêtez-vous dès que c'est le cas.
