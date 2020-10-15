package com.wix.detox.common.proxy

import android.os.SystemClock
import android.util.Log
import com.wix.detox.common.collect.SimpleEvictingQueue

internal data class CallInfo(var inTime: Long? = null, var outTime: Long? = null) {

    fun open(inTime: Long = SystemClock.uptimeMillis()): CallInfo {
        this.inTime = inTime
        this.outTime = null
        return this
    }

    fun close(outTime: Long = SystemClock.uptimeMillis()): CallInfo {
        this.outTime = outTime
        return this
    }

    override fun toString() = "$inTime -> $outTime"
}

class MethodCallJournal(private val dbgName: String, private val histDepth: Int = 3) {
    private val methodHistories = mutableMapOf<String, SimpleEvictingQueue<CallInfo>>()

    fun onBeforeCall(methodName: String) {
        Log.d(LOG_TAG, "[$dbgName] onBefore")
        historyOf(methodName).add(CallInfo().open())
    }

    fun onAfterCall(methodName: String) {
        Log.d(LOG_TAG, "[$dbgName] onAfter")
        historyOf(methodName).peek()?.close()
    }

    /**
     * Calculate call-time delta between latest call and call at depth (which is 1-based, not 0-based).
     *
     * @return Delta time, or null if calls are N/A compared to recorded history
     */
    fun callDeltaTime(methodName: String, depth: Int): Long? {
        val history = methodHistories[methodName]
        if (history == null || history.size < depth - 1) {
            return null
        }

        val latest = history.getAt(0)
        val oldest = history.getAt(depth - 1)
        if (latest != null && oldest != null) {
            val inTime = oldest.inTime
            val outTime = latest.outTime
            if (inTime != null && outTime != null) {
                return outTime - inTime
            }
        }
        return null
    }

    fun dumpToLog() {
        for ((methodName, history) in methodHistories.entries) {
            Log.d(LOG_TAG, "[$dbgName] method $methodName: $history")
        }
    }

    private fun historyOf(key: String) =
        methodHistories.getOrPut(key) {
            SimpleEvictingQueue(histDepth)
        }

    companion object {
        private const val LOG_TAG = "DetoxCallJournal"
    }
}
