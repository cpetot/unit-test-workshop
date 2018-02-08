# Exercice 5 : Mockito plus avancé

Bravo, tu es vraiment allé vite !
Le but de l'exercice est d'apprendre comment capturer des arguments avec Mockito.

### 1. Permettez à l'application de créer un film
- Modifiez le controleur et le service pour permettre de créer un film à partir d'un titre et d'un rating.
- Faites en sorte que ces données soient obligatoires.
- On doit avoir une erreur lorsqu'on cherche à créer un film qui existe déjà avec le même titre.

NB : il doit s'agit d'une requête POST avec 2 @RequestParam

### 2. Tests de la méthode de création
- Utilisez un ArgumentCaptor pour vérifier le Movie enregistré par le repository.
- Utilisez l'annotation @Captor pour faciliter l'écriture.
- Utilisez la méthode "extracting" de AssertJ pour vérifier que les propriété du film ont été correctement renseignées.
  Vous êtes encouragés à utiliser les références de fonction pour extraire les valeurs.
