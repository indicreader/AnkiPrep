package com.example.flashcardapp.data.backup

import android.content.Context
import android.util.Log
import com.example.flashcardapp.data.AppDatabase
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream

object BackupRestoreUtils {
    private const val TAG = "BackupRestoreUtils"

    fun exportBackup(context: Context, outputStream: OutputStream): Boolean {
        return try {
            // Close database cleanly
            AppDatabase.closeInstance()

            ZipOutputStream(outputStream).use { zos ->
                // 1. Pack Database Files
                val dbDir = context.getDatabasePath("ankiprep_cache.db").parentFile
                if (dbDir != null && dbDir.exists()) {
                    val dbFiles = listOf(
                        "ankiprep_cache.db",
                        "ankiprep_cache.db-wal",
                        "ankiprep_cache.db-shm"
                    )
                    for (fileName in dbFiles) {
                        val file = File(dbDir, fileName)
                        if (file.exists()) {
                            zos.putNextEntry(ZipEntry("db/$fileName"))
                            FileInputStream(file).use { fis ->
                                fis.copyTo(zos)
                            }
                            zos.closeEntry()
                        }
                    }
                }

                // 2. Pack Card Images
                val imagesDir = File(context.filesDir, "card_images")
                if (imagesDir.exists() && imagesDir.isDirectory) {
                    val files = imagesDir.listFiles()
                    if (files != null) {
                        for (file in files) {
                            if (file.isFile) {
                                zos.putNextEntry(ZipEntry("card_images/${file.name}"))
                                FileInputStream(file).use { fis ->
                                    fis.copyTo(zos)
                                }
                                zos.closeEntry()
                            }
                        }
                    }
                }
            }
            true
        } catch (e: Exception) {
            Log.e(TAG, "Failed to export backup", e)
            false
        }
    }

    fun importBackup(context: Context, inputStream: InputStream): Boolean {
        return try {
            // Close database cleanly first
            AppDatabase.closeInstance()

            val dbDir = context.getDatabasePath("ankiprep_cache.db").parentFile ?: return false
            if (dbDir.exists()) {
                val dbFiles = listOf(
                    "ankiprep_cache.db",
                    "ankiprep_cache.db-wal",
                    "ankiprep_cache.db-shm"
                )
                for (fileName in dbFiles) {
                    val file = File(dbDir, fileName)
                    if (file.exists()) {
                        file.delete()
                    }
                }
            } else {
                dbDir.mkdirs()
            }

            val imagesDir = File(context.filesDir, "card_images")
            if (!imagesDir.exists()) {
                imagesDir.mkdirs()
            }

            ZipInputStream(inputStream).use { zis ->
                var entry: ZipEntry?
                while (zis.nextEntry.also { entry = it } != null) {
                    val name = entry!!.name
                    if (name.startsWith("db/")) {
                        val fileName = name.substringAfter("db/")
                        val destFile = File(dbDir, fileName)
                        FileOutputStream(destFile).use { fos ->
                            zis.copyTo(fos)
                        }
                    } else if (name.startsWith("card_images/")) {
                        val fileName = name.substringAfter("card_images/")
                        val destFile = File(imagesDir, fileName)
                        FileOutputStream(destFile).use { fos ->
                            zis.copyTo(fos)
                        }
                    }
                    zis.closeEntry()
                }
            }
            true
        } catch (e: Exception) {
            Log.e(TAG, "Failed to import backup", e)
            false
        }
    }
}
