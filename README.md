# 🌀 Naruto Universe - TP3

Application Android développée avec **Jetpack Compose**, utilisant **Room (SQLite)**, **MVVM** et **DataStore**.

---

## 🎯 Thème

Application basée sur l’univers de **Naruto & Boruto**.

Elle permet de gérer une base de données de ninjas avec :
- Nom
- Village
- Chakra
- Image

---

## 🚀 Fonctionnalités

### 📦 Base de données (Room)
- Stockage local avec Room
- Données persistantes

### 🔁 CRUD complet
- ➕ Ajouter une liste de ninjas
- 📖 Lire les ninjas
- ✏️ Modifier le chakra (+ / -)
- ❌ Supprimer un ninja
- 🧹 Supprimer tous les ninjas

### 🔍 Recherche
- Recherche dynamique par nom

### 🎨 UI (Jetpack Compose)
- LazyColumn avec Cards
- Images des personnages
- Barre de chakra (ProgressBar)
- Animation des cartes
- Background personnalisé (Konoha)

### 🌗 Mode sombre
- Switch pour activer/désactiver
- Sauvegardé avec DataStore

---

## 🧠 Architecture

Architecture **MVVM** :

- UI → Compose
- ViewModel → logique
- Repository → accès aux données
- Room → base de données

---

## 💾 DataStore

Stocke :
- Mode sombre

---

## 🛠️ Technologies utilisées

- Kotlin
- Jetpack Compose
- Material 3
- Room (SQLite)
- ViewModel
- DataStore
- Coroutines + Flow

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
