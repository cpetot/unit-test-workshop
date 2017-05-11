# Exercice 3 : Intégration avec Spring

Le but de l'exercice est d'apprendre comment intégrer Mockito et Spring et d'approfondir l'utilisation de AssertJ et Mockito

### 1. Ecrivez les tests de MovieService#getByTitle

- Lorsque le titre n'est pas renseigné, on doit avoir une erreur et le repository ne doit pas être appelé.
- Lorsque le titre est renseigné et qu'un film est trouvé, il doit être renvoyé et le repository doit avoir été appelé.
- Lorsque le titre est renseigné mais qu'aucun film n'est trouvé, on doit avoir une erreur et le repository doit avoir été appelé.

### 2. Ajout de findMoviesAvailableForAge

Le but est de retourner uniquement les films qu'on peut voir pour un âge donné en paramètre.
Allez lire la méthode correspondante dans le service : son implémentation est incomplète.
- Réfléchissez aux cas à tester et écrivez un test tirant pleinement partie de AssertJ.
- Modifiez la méthode pour qu'elle ait le comportement désiré en vous appuyant sur les tests écrits.