package karthyks.gamer

import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

abstract class BaseActivity : AppCompatActivity() {
    private val job: Job = Job()
    val uiScope: CoroutineScope = CoroutineScope(job + Dispatchers.Main)

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }


    inline fun callAfter(millis: Long, crossinline callback: () -> Unit) {
        uiScope.launch(Dispatchers.Default) {
            delay(millis)
            launch(Dispatchers.Main) {
                callback()
            }
        }
    }
}