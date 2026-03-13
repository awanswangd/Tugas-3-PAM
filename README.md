# 📱 My Profile App

Aplikasi profil pengguna yang dibangun menggunakan **Compose Multiplatform**, berjalan di Android dan Desktop dari satu codebase Kotlin.

> Tugas Praktikum Minggu 3 — IF25-22017 Pengembangan Aplikasi Mobile  
> Program Studi Teknik Informatika, Institut Teknologi Sumatera

---

## ✨ Fitur

- 👤 **Header Profil** — Avatar circular, nama, title, dan tombol Follow/Following
- 📝 **Bio Card** — Deskripsi singkat pengguna
- 📋 **Informasi Kontak** — Email, nomor telepon, dan lokasi
- 🔘 **Action Buttons** — Kirim Pesan dan Bagikan Profil
- 🔄 **Interaktif** — Tombol Follow berubah state secara real-time

---

## 🗂️ Struktur Project

```
MyProfileApp/
├── composeApp/
│   └── src/
│       ├── commonMain/
│       │   └── kotlin/org/profile/project/
│       │       ├── App.kt                 # Entry point & MaterialTheme
│       │       ├── Platform.kt            # expect declaration
│       │       ├── ProfileScreen.kt       # Halaman utama
│       │       ├── ProfileHeader.kt       # Reusable Composable #1
│       │       ├── InfoItem.kt            # Reusable Composable #2
│       │       └── ProfileComponents.kt   # Reusable Composable #3 + models
│       ├── androidMain/
│       │   └── kotlin/org/profile/project/
│       │       └── Platform.android.kt    # actual Android implementation
│       └── iosMain/
│           └── kotlin/org/profile/project/
│               └── Platform.ios.kt        # actual iOS implementation
└── build.gradle.kts
```

---

## 🧩 Composable Functions

Terdapat **3 custom composable reusable** sesuai ketentuan tugas:

### 1. `ProfileHeader`
```kotlin
@Composable
fun ProfileHeader(
    name: String,
    title: String,
    avatarInitials: String,
    photoUrl: String? = null,
    isFollowing: Boolean = false,
    onFollowClick: () -> Unit = {}
)
```
Menampilkan bagian hero profil dengan avatar circular, nama, title, dan tombol Follow.

---

### 2. `InfoItem`
```kotlin
@Composable
fun InfoItem(
    icon: ImageVector,
    label: String,
    value: String,
    tint: Color = Color.Unspecified
)
```
Satu baris informasi dengan icon, label kategori, dan nilai. Dipakai berulang untuk Email, Phone, dan Location.

---

### 3. `ProfileCard`
```kotlin
@Composable
fun ProfileCard(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
)
```
Card wrapper generik dengan judul section. Digunakan oleh `BioCard` dan `ContactInfoCard`.

---

## 🎨 Komponen UI yang Digunakan

| Komponen | Lokasi Penggunaan |
|----------|-------------------|
| `Column` | `ProfileScreen`, `ProfileHeader`, `ProfileComponents` |
| `Row` | `InfoItem`, `ActionButtons` |
| `Box` | Avatar circular di `ProfileHeader` (gradient background) |
| `Card` | `ProfileCard` wrapper dengan elevasi |
| `Text` | Nama, bio, label, nilai kontak |
| `Button` | Follow, Kirim Pesan |
| `OutlinedButton` | Following state, Bagikan |
| `Icon` | Email, Phone, LocationOn, Share |
| `Divider` | Pemisah antar `InfoItem` |
| `Surface` | Lingkaran latar icon di `InfoItem` |

---

## 🛠️ Setup & Menjalankan

### Prasyarat
- Android Studio Hedgehog atau lebih baru
- JDK 17+
- Kotlin 1.9+

### Dependensi (`build.gradle.kts`)
```kotlin
kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.ui)
        }
    }
}
```

### Menjalankan di Android
```bash
./gradlew :composeApp:assembleDebug
```

### Menjalankan di Desktop
```bash
./gradlew :composeApp:run
```

## 📚 Referensi

- [Compose Multiplatform Docs](https://www.jetbrains.com/compose-multiplatform/)
- [Material 3 Components](https://m3.material.io/components)
- [Coil Image Loading](https://coil-kt.github.io/coil/)
- [State and Jetpack Compose](https://developer.android.com/jetpack/compose/state)

---

## Screenshot Aplikasi

<img src='./Screenshot/Screenshot 2026-03-13 150310.png'>
