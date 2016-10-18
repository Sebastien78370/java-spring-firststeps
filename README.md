Etapes à suivre :
1. Structure du projet :
    - Consulter les fichiers suivants : 'WEB-INF/web.xml' & 'WEB-INF/mvc-dispatcher-servlet.xml'. 
        Ces fichiers permettent à l'application de fonctionner et définissent les règles de gestion.
    - Observer la classe 'com.springapp.mvc.HelloController', saisissez un message puis lancer via tomcat l'application.
        Votre message doit apparaitre dans le navigateur
2. Service & WS REST :
    - Une interface Animal accompagnée de sa classe abstraite sont présentes et définissent une architecture d'objets
        Créer au moins trois implémentations différentes de la classe Animal en se basant sur la classe abstraite AbstractAnimal. 
        Veillez à définir les objets via leur constructeur par défaut en utilisant le constructeur parent et que ces objets soient managés par Spring (@Component)
    - Implémenter la classe ZooService de manière à ce que l'implémentation soit un service Spring avec l'injection d'une liste des classes Animal précédement définis
    - Réalisez l'implémentation de toute les méthodes de la manière la plus performante possible (API Java 8 - Stream + Optional)
    - Créer un controller REST 'ZooWebServiceController' définissant l'API cliente pour accéder au ZooService. Testez votre API via le navigateur web
3. Exceptions & tests unitaires
    - Assurez-vous que la méthode 'retrieveAnimal' du ZooService renvoie une 'UnknownAnimalException' en cas d'échec. 
        L'endpoint doit renvoyer le code d'erreur 404 et non 500.
    - Rendez vos objets sérialisables en XML et vérifiez le en ajoutant des tests de sérialisations et désérialisations.
4. Appels à une API externe
    - Consulter la classe PixaBayService et comprenez son fonctionnement
    - Ajouter à toutes vos instances d'Animal après la construction de l'objet (@PostConstuct) une previewUrl en appelant le service PixaBayService 
        Attention vos objets doivent rester sérialisables (transient)
5. Front
    - Reprendre la page hello.jsp pour définir une app AngularJS
    - Créer les controllers/services nécessaires pour communiquer avec l'API en place
    - Depuis l'interface, il doit être possible :
        - Lister l'ensemble des animaux du zoo avec leurs caractéristiques
        - Rechercher un animal en particulier
        - Afficher le plus jeune/vieux des animaux
        - Connaître la liste des herbivores/carnivores du zoo
        - Savoir comment un animal peut dire bonjour !
