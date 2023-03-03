package com.example.transactionexample.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component
import org.springframework.transaction.support.TransactionTemplate

@Component
class CoroutineTransactionHandler(
    private val transactionManager: TransactionTemplate,
) {

    suspend fun <R> getWithReadOnly(block: () -> R?): R? {
        return transactionManager.runWithResult {
            transactionManager.isReadOnly = true
            block()
        }
    }

    suspend fun <R> runWithResult(block: () -> R?): R? {
        return transactionManager.runWithResult {
            block()
        }
    }

    suspend fun <R> run(block: () -> R) {
        return transactionManager.run {
            block()
        }
    }

}

suspend fun <R> TransactionTemplate.runWithResult(
    block: () -> R?,
): R? {
    return withContext(Dispatchers.Default) {
        this@runWithResult.execute {
            block()
        }
    }
}

suspend fun <R> TransactionTemplate.run(
    block: () -> R,
) {
    return withContext(Dispatchers.Default) {
        this@run.execute {
            block()
        }
    }
}