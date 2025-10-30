# L’odyssée de Pi
Voici un programme proposant quelques fonctions

```java
class Cercle extends Program{
    double circonference(double rayon) {
        return 3.14 * diametre(rayon);
    }
    double diametre(double rayon) {
        return 2 * rayon;
    }
    double aire(double rayon) {
        return 3.14 * rayon * rayon;
    }
    double volume(double rayon) {
        return 4.0/3.0 * 3.14 * rayon * rayon *rayon;
    }
}
```

- Améliorez ce code en y intégrant deux constantes globales, l’une pour éviter la redondance d’une même valeur (`PI`), l’autre pour éviter un calcul à chaque appel de la fonction `volume` (`QUATRE_TIERS_DE_PI`).
- Pour des calculs plus précis, on souhaite une valeur de PI avec 5 décimales après la virgule, modifiez votre programme dans ce sens.
- Écrivez un `void algorithm()` qui pour des rayons allant de 1 à 15 affiche la circonférence, l’aire et le volume, puis indique le nombre de multiplications effectuées au total. Pour ce faire, vous utiliserez une variable globale `nombreDeMultiplications` que vous mettrez à jour dans chaque fonction réalisant des multiplications.

N'oubliez pas de tester votre programme à l'aide de la commande `test` d'`ijava` !
