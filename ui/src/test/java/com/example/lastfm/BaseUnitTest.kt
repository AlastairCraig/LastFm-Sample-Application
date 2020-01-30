package com.example.lastfm

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.functions.Function
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import java.util.concurrent.Callable

abstract class BaseUnitTest {

    private val mainScheduler = Function<Callable<Scheduler>, Scheduler> {
        Schedulers.trampoline()
    }
    private val scheduler = Function<Scheduler, Scheduler> {
        Schedulers.trampoline()
    }

    @Before
    internal fun setup() {

        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) {
                runnable.run()
            }

            override fun postToMainThread(runnable: Runnable) {
                runnable.run()
            }

            override fun isMainThread(): Boolean {
                return true
            }
        })

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(mainScheduler)

        RxJavaPlugins.setIoSchedulerHandler(scheduler)
        RxJavaPlugins.setNewThreadSchedulerHandler(scheduler)
        RxJavaPlugins.setComputationSchedulerHandler(scheduler)
    }

    @After
    internal fun tearDown() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()

        ArchTaskExecutor.getInstance().setDelegate(null)
    }
}