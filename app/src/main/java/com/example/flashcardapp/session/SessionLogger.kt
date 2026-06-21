package com.example.flashcardapp.session

/**
 * A safe logging utility that delegates to [android.util.Log] when running on-device,
 * and falls back to [System.out.println] when running in JVM unit tests.
 *
 * This avoids the "Method ... not mocked" RuntimeException commonly thrown by
 * Android classes in local JUnit tests.
 */
object SessionLogger {

    fun i(tag: String, msg: String) {
        try {
            android.util.Log.i(tag, msg)
        } catch (e: RuntimeException) {
            println("[$tag] INFO: $msg")
        }
    }

    fun d(tag: String, msg: String) {
        try {
            android.util.Log.d(tag, msg)
        } catch (e: RuntimeException) {
            println("[$tag] DEBUG: $msg")
        }
    }

    fun w(tag: String, msg: String) {
        try {
            android.util.Log.w(tag, msg)
        } catch (e: RuntimeException) {
            println("[$tag] WARN: $msg")
        }
    }

    fun e(tag: String, msg: String, tr: Throwable? = null) {
        try {
            android.util.Log.e(tag, msg, tr)
        } catch (ex: RuntimeException) {
            println("[$tag] ERROR: $msg ${tr?.message ?: ""}")
            tr?.printStackTrace()
        }
    }
}
