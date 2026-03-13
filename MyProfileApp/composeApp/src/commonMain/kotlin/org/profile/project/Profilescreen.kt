package org.profile.project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
    // Data profil (dalam app nyata, ini datang dari ViewModel)
    val profile = ProfileData(
        name = "M. Hafizurrahman Akbar",
        title = "Mahasiswa Teknik Informatika",
        bio = "Passionate game developer yang gemar membangun " +
                "game aneh walaupun tidak ada yang memainkannya.",
        email = "mhafizurrahman.123140123@student.itera.ac.id",
        phone = "+62 812-3456-7890",
        location = "Lampung, Indonesia",
        avatarInitials = "HA"
    )

    var isFollowing by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 24.dp)
    ) {
        // 1. Header dengan foto profil dan nama
        ProfileHeader(
            name = profile.name,
            title = profile.title,
            avatarInitials = profile.avatarInitials,
            isFollowing = isFollowing,
            onFollowClick = { isFollowing = !isFollowing }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 2. Bio / deskripsi singkat
        BioCard(bio = profile.bio)

        Spacer(modifier = Modifier.height(16.dp))

        // 3. List informasi kontak
        ContactInfoCard(
            email = profile.email,
            phone = profile.phone,
            location = profile.location
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 4. Tombol aksi
        ActionButtons(
            onMessageClick = { /* navigasi ke pesan */ },
            onShareClick = { /* share profil */ }
        )
    }
}