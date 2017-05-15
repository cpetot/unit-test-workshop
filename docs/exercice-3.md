# Exercice 3 : Intégration avec Spring avec UserService

Le but de l'exercice est d'apprendre comment tester des services Spring avec Mockito.

### 1. Tests de getUser
- Lorsque le nom n'est pas renseigné, on doit avoir une erreur et le repository ne doit pas être appelé.
- Lorsque le nom est renseigné et qu'un film est trouvé, il doit être renvoyé et le repository doit avoir été appelé.
- Lorsque le nom est renseigné mais qu'aucun film n'est trouvé, on doit avoir une erreur et le repository doit avoir été appelé.

NB : Contrairement aux exercices précédent, vous ne pourrez pas utiliser ExpectedException pour pouvoir tester correctemet les appels de repository en cas d'erreur.
Il faudra écrire :
 ```java
try {
    userService.getUser(username);
    Assertions.fail("Explain why we should not reach this");
} catch (MyExpectedException e) {
    Assertions.assertThat(e)
        .hasMessage("my expected message");
}
 ```

### 2. Autres tests
- Quelles autres méthodes sont pertinentes pour des tests ?
- Ecrivez les