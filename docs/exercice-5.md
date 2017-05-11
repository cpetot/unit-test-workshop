# Exercice 4 : Mockito plus avancé

Le but de l'exercice est d'apprendre comment capturer des arguments avec Mockito

### 1. Permettez à l'application de créer un film
- Modifiez le repository et le service pour permettre la création d'un film.
- On doit avoir une erreur lorsqu'on cherche à créer un film qui existe déjà.

### 2. Tests de la méthode de création
- Utilisez un ArgumentCaptor pour vérifier le Movie enregistré par le repository.
- Utilisez l'annotation @Captor pour faciliter l'écriture.
- Utilisez la méthode "extracting" de AssertJ pour vérifier que les propriété du film ont été correctement renseignées.
