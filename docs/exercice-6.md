# Exercice 6 : Petit aperçu de ArchUnit

Le but est de te donner un minuscule aperçu de **ArchUnit**.

Il s'agit d'une librairie permettant de véfifier les règles d'architecture via des tests unitaires.

### 1. Lisez les bases de ArchUnit
- Allez sur https://www.archunit.org/

### 2. Créez un test vérifiant que les couches sont respectées sur ce projet
Voici les règles à respecter : 
```mermaid
graph TD
	P(Persistence) --> M[Model]
	S(Services) --> M
	S --> P
	C[Controllers] --> S
	C --> P
	C --> M
```
[![](https://mermaid.ink/img/eyJjb2RlIjoiZ3JhcGggVERcblx0UChQZXJzaXN0ZW5jZSkgLS0-IE1bTW9kZWxdXG5cdFMoU2VydmljZXMpIC0tPiBNXG5cdFMgLS0-IFBcblx0Q1tDb250cm9sbGVyc10gLS0-IFNcblx0QyAtLT4gUFxuXHRDIC0tPiBNXG5cdFx0XHRcdFx0IiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZX0)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiZ3JhcGggVERcblx0UChQZXJzaXN0ZW5jZSkgLS0-IE1bTW9kZWxdXG5cdFMoU2VydmljZXMpIC0tPiBNXG5cdFMgLS0-IFBcblx0Q1tDb250cm9sbGVyc10gLS0-IFNcblx0QyAtLT4gUFxuXHRDIC0tPiBNXG5cdFx0XHRcdFx0IiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZX0)

**Rappel** : l'architecture de ce workshop est simpliste et n'est pas un modèle à recommander sur un projet.

- Inspirez vous de : https://github.com/TNG/ArchUnit-Examples/blob/master/example-junit5/src/test/java/com/tngtech/archunit/exampletest/junit5/LayeredArchitectureTest.java#L25
