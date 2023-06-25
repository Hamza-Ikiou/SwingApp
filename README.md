# Pre-requis

- Java JDK 11+ (J'ai testé mon application sur la version 11 de java)

# Lancement de l'application

Après avoir extrait le fichier iHoover-master.zip

- Depuis un IDE :
    - Ouvrir le projet iHoover-master
    - Lancer le fichier main.java
  
- En ligne de commande :
    - Se placer dans le répertoire contenant le projet
    - cd /iHoover-master/src/
    - javac main.java
    - java main

# Fonctionnement de l'application

Après avoir lancer le main.java, une fenêtre apparait.
Il faut remplir les dimensions de la grille ainsi que la position de l'aspirateur.
Vous ne pouvez indiquer uniquement des nombres positifs dans les champs.
Vous ne pouvez pas indiquer des nombres strictement supérieurs à la grille dans la position de l'aspirateur.
Enfin, il faut sélectionner une orientation pour l'aspirateur (N/S/E/O).
Après avoir cliquer sur le bouton confirmer,
une nouvelle fenêtre s'ouvre avec les informations de la simulation.
Vous pouvez cliquer sur le bouton D pour changer l'orientation de l'aspirateur vers la droite
et le bouton G pour la changer vers la gauche. Le bouton A fera avancer l'aspirateur.
