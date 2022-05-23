package com.ticket.app

import android.app.Application
import com.ticket.app.domain.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class TicketApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TicketApp)
            modules(appModule)
        }
    }
}
