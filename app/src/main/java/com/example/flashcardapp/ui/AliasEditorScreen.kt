package com.example.flashcardapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.entities.AliasEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AliasEditorScreen(
    aliases: List<AliasEntity>,
    onBack: () -> Unit,
    onAddAlias: (name: String, alias: String) -> Unit,
    onDeleteAlias: (AliasEntity) -> Unit,
    onModifyAlias: (oldAlias: AliasEntity, newName: String, newAlias: String) -> Unit
) {
    var showAddDialog by remember { mutableStateOf(false) }
    var editAlias by remember { mutableStateOf<AliasEntity?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Alias Matrix Editor", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Outlined.ArrowBack, "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showAddDialog = true }) {
                Icon(Icons.Outlined.Add, "Add Alias")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Table Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp))
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Target Word",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Alias Configurations",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1.5f)
                )
                Text(
                    text = "Actions",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(100.dp)
                )
            }

            // List of Aliases
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(aliases) { aliasEntity ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = aliasEntity.name,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = aliasEntity.alias,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.weight(1.5f)
                            )
                            Row(
                                modifier = Modifier.width(100.dp),
                                horizontalArrangement = Arrangement.End
                            ) {
                                IconButton(onClick = { editAlias = aliasEntity }) {
                                    Icon(Icons.Outlined.Edit, "Edit", tint = MaterialTheme.colorScheme.primary)
                                }
                                IconButton(onClick = { onDeleteAlias(aliasEntity) }) {
                                    Icon(Icons.Outlined.Delete, "Delete", tint = MaterialTheme.colorScheme.error)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    if (showAddDialog || editAlias != null) {
        val isEdit = editAlias != null
        var nameInput by remember { mutableStateOf(editAlias?.name ?: "") }
        var aliasInput by remember { mutableStateOf(editAlias?.alias ?: "") }

        AlertDialog(
            onDismissRequest = { 
                showAddDialog = false
                editAlias = null
            },
            title = { Text(if (isEdit) "Modify Alias" else "Add New Alias") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = nameInput,
                        onValueChange = { nameInput = it },
                        label = { Text("Target Word") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = aliasInput,
                        onValueChange = { aliasInput = it },
                        label = { Text("Alias Configurations") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (nameInput.isNotBlank() && aliasInput.isNotBlank()) {
                            if (isEdit) {
                                onModifyAlias(editAlias!!, nameInput, aliasInput)
                            } else {
                                onAddAlias(nameInput, aliasInput)
                            }
                            showAddDialog = false
                            editAlias = null
                        }
                    }
                ) {
                    Text("Save")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { 
                        showAddDialog = false
                        editAlias = null
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}
