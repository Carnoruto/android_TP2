# 🌀 L'Univers de Naruto App

Application Android développée en **Jetpack Compose** avec **Material 3**.

---

## 🎯 Thème choisi

L’application est basée sur l’univers de **Naruto & Boruto**.

Elle affiche deux listes distinctes :
- 🌀 Personnages de Naruto
- ⚡ Personnages de Boruto

Chaque personnage contient :
- Une image
- Un nom
- Un sous-titre
- Une barre de chakra animée
- Des boutons pour augmenter / diminuer le chakra

---

## 🚀 Fonctionnalités

- LazyColumn avec 6+ éléments par liste
- Deux listes dynamiques (Naruto / Boruto)
- Cards animées (expand au clic)
- Gestion individuelle du chakra
- Barre de progression animée
- Désactivation du bouton "-" à 0
- Thème clair / sombre (Material 3)
- Images locales dans le dossier drawable

---

## 🌗 Mode Clair / Sombre

Un **Switch** permet de basculer entre thème clair et sombre.

📍 Emplacement du Switch :  
En haut de l’écran principal, à droite du texte **"Mode sombre"**, sous le titre *Naruto Universe*.

Le changement de thème est dynamique et modifie :
- Les couleurs principales
- Le fond
- Les cartes
- Les éléments Material 3

---

## 🛠️ Technologies utilisées

- Kotlin
- Jetpack Compose
- Material 3
- LazyColumn
- Animations (animateFloatAsState, animateContentSize)
- Gestion d’état avec `remember`

---

## 📁 Structure principale

com.tonpackage/
│
├── MainActivity.kt
├── NarutoApp.kt
├── model/Ninja.kt
└── ui/theme/
    ├── Color.kt
    ├── Theme.kt
    └── Type.kt

---
## Étapes pour lancer le projet

1. Cloner le dépôt :

```bash
git clone <https://github.com/Carnoruto/android_TP2.git>
```

2. Ouvrir le projet dans Android Studio 

3. Attendre la synchronisation Gradle

4. Lancer l’application sur :

> un émulateur Android
ou
> un appareil physique
