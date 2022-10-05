# Sujet du TP

Le TP bibliothèque fait le lien entre les différents cours qui ont eu lieu:
- Modélisation UML.
- TP de base de données.
- TP de développement orientée objet (Java, Kotlin).
- Développement d'interfaces graphiques en JavaFX.
- Utilisation du modèle MVC.
- Éventuellement identification et utilisation d'un (ou plusieurs) patron(s) de conception.

L'objectif de ce TP est de réaliser un logiciel de gestion de bibliothèque avec une interface graphique. L'interface proposera (au moins) deux types de rôles: l'emprunteur normal et l'administrateur de la bibliothèque. Les fonctionnalités attendues sont les suivantes:
- La bibliothèque **gère le prêt** de livres, objets physiques exemplaires d’une édition d’une œuvre intellectuelle. Il peut y avoir **plusieurs exemplaires d’un même livre, dans une ou plusieurs éditions.**
- **Une édition a comme attribut**:  
  - un nom d’éditeur,
  - une année d’édition et
  - un ISBN (International Standard Book Number) identifiant de manière unique chaque édition de chaque livre.
- **Une œuvre a**: 
  - un titre (des homonymes sont possibles),
  - un ou plusieurs auteurs et
  - une année de première parution.
- À chaque œuvre **est attachée une liste de 5 mots-clés**, ***dont le seul le premier doit être impérativement renseigné***. On ne gère pas le dictionnaire de ces mots-clés.
- **Les auteurs ont**:
  -  un prénom et
  - un nom (des homonymes sont possibles),
  - une année de naissance.
- Un même auteur peut avoir **participé à plusieurs œuvres**.
- **Les usagers et les gestionnaires de la bibliothèque ont**:
  - un prénom et
  - un nom (des homonymes sont possibles),
  - une adresse e-mail et
  - un numéro d’identification.
- Les usagers  peuvent emprunter **un ou plusieurs** livres **pour une durée limitée**.
- Chaque usager **appartient à une catégorie** ***qui fixe le nombre maximal d’emprunts en cours et la durée maximale des emprunts***. On veut **pouvoir en exploitation modifier** ces deux paramètres **sans avoir à modifier** les enregistrements de tous les usagers de la catégorie concernée. **Les gestionnaires de la bibliothèque constituent une catégorie**.
- **Un historique des emprunts** (date de l’emprunt, titre de l’œuvre, édition) est rattaché à chaque usager.
- Les usagers peuvent être **mis en liste rouge**, interdits d’emprunts. Ces événements **sont historisés**.

On doit pouvoir:
- **emprunter** un livre
- **consulter** la liste des emprunteurs
- **consulter** la liste des livres empruntés, ou non empruntés

Pour réaliser ces fonctionnalités, nous vous renvoyons vers les TPs précédents:
- Modélisation UML: vous avez travaillé les diagrammes de la bibliothèque: use case, classe, etc.
- TP de base de donnée: vous avez travaillé le modèle de donnée dans une BDD relationnel.
- TP de développement orientée objet (Java, Kotln): vous avez travaillé le modèle objet, et un peu l'interaction avec Spring boot d'une base JDBC
- Développement en JavaFX: vous avez travaillé la création d'interface graphique

Les spécifications ne sont pas plus précises que ce qui est écrit dans cette page (contrairement à tous les TPs précédents où le sujet est très précis). En effet, nous attendons que vous fassiez toute la démarche, de la spécification jusqu'à l'implémentation du logiciel de gestion de bibliothèque.

L'évaluation portera sur une courte présentation avec des slides et une petite démo, en début de semaine du projet d'intégration. Le code source devra être rendu via une livraison dans un dépôt git sur la plateforme gitlab-student.centralesupelec.fr. Merci de poster l'url de votre dépot dans le devoir associé. Vous penserez à commiter vos modifications régulièrement (et pas en une seule fois à la fin du TP). L'évaluation est individualisée. Merci d'ajouter Jean-François Lalande, Valérie Viet Triem Tong et Frédéric Tronel comme mainteneur de votre dépôt gitlab.