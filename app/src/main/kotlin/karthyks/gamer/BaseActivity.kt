package karthyks.gamer

import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseActivity: AppCompatActivity() {
    private val job: Job = Job()
    val uiScope: CoroutineScope = CoroutineScope(job + Dispatchers.Main)

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}