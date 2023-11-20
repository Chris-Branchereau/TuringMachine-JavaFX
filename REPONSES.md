# ATLG3 - TD2

## 1
### 1.1


    (3.0, 6.0) - FF0000FF
    x: 3.0
    color : FF0000FF



### 1.2


    java: cannot find symbol
        symbol:   method getColor()
            location: variable p of type be.g60127.td2.Point

la ligne 10.    
non, car simplement, il n'y a pas de fonction getColor() dans Point.



### 1.3

non, car Point est le parent de ColoredPoint

### 1.4
non, car x et y sont private dans la classe parente 

### 1.5
    java: cyclic inheritance

### 1.6
    java: cannot inherit from final
car, on ne peut pas hériter d'une classe final

## 2
### 2.1
Oui, car la classe Object est parente à toute classe en java.

### 2.2
Oui, même raison que 2.1

### 2.3
Oui, car cette méthode vient de la classe Object et est publique. 

## 3 
### 3.1
    java: call to super must be first statement in constructor
### 3.2
    java: constructor Point in class be.g60127.td2.Point cannot be applied to given types;
        required: double,double
        found:    no arguments
        reason: actual and formal argument lists differ in length
Elle sert à hériter du constructeur de la classe Parent : Point

### 3.3
Non

## 4
### 4.1
    constructor of A
    constructor of B
    constructor of C

### 4.2
    constructor of A
    constructor of B

### 4.4
Il n'y a qu'un constructeur vide


## 5
### 5.1
    (0.0, 0.0) - not pinned
    (1.0, 1.0) - pinned
### 5.2
Celle de PinnablePoint 
### 5.3
    java: move(double,double) in be.g60127.td2.PinnablePoint cannot override move(double,double) in be.g60127.td2.Point
    overridden method does not throw java.lang.Exception
On ne peut pas l'override si celle de Point n'est pas modifié avec Exception

### 5.4
Non

# ATLG3 - TD3

##  Question 1
### 1.1
Cela change la taille de la scène

### 1.2
Cela retire les bords de la

    StageStyle.DECORATED
    StageStyle.UNDECORATED
    StageStyle.TRANSPARENT
    StageStyle.UTILITY

### 1.3
Cela place l'élément sur les différentes parties de la scène (Haut, bas, gauche, droite)


## Question 2
### 2.1
First : Il est déjà sélectionné au début

Second : Il est indéterminé uniquement au début (Il ne peut plus l'être une fois changer)

Third : Il est désélectionné au début et permet l'indétermination

### 2.2
First : se place en haut à gauche (plus au centre)

Second : se place en haut à droite (idem)

## Question 3
### 3.1
Cela cache les caractères

### 3.2
La zone de texte n'est plus modifiable et le texte est centré

## Question 4
Le texte présent dans la zone est affiché dans la console

## Question 5
    ObservableList<Node>

Grouper Les "nodes" dans une liste

## Question 6
### 6.3
Il va falloir redimensionné les éléments nous même s'ils dépassent la taille de la boite

    setClip(Node)

## Question 7


# ATLG3 - TD5

## Question 1
    java: incompatible types: java.lang.Double cannot be converted to java.lang.Integer

## Question 2
    'Integer(int)' is deprecated and marked for removal 

## Question 3
Non

## Question 4
    java: incompatible types: be.g60127.td5.Box<java.lang.Integer> cannot be converted to be.g60127.td5.Box<java.lang.Object>

## Question 5
    java: incompatible types: java.lang.Double cannot be converted to java.lang.Integer

## Question 6
    java: incompatible types: java.lang.Integer cannot be converted to capture#1 of ?

## Question 7
    java: cannot find symbol
    symbol:   method compareTo(T)
    location: variable first of type T

## Question 8
    java: type argument java.lang.Number is not within bounds of type-variable T
Car Number n'implémente pas Comparable



