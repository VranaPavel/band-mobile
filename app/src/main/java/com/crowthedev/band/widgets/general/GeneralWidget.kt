package com.crowthedev.band.widgets.general

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.RemoteViews
import com.crowthedev.band.MainActivity
import com.crowthedev.band.R
import com.crowthedev.band.data.Name
import com.crowthedev.band.data.NameDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Implementation of App Widget functionality.
 */

class Birthday : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(
                context,
                appWidgetManager,
                appWidgetId
            )
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
) {
    val views = RemoteViews(context.packageName, R.layout.generalwidget)

    val pendingIntent: PendingIntent = PendingIntent.getActivity(
            context,
    0,
    Intent(context, MainActivity::class.java),
    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    var dataItems: List<Name> = emptyList()
    val nameDao = NameDatabase.getDatabase(context).nameDao()
    val listOfTextViews = listOf(R.id.name1, R.id.name2, R.id.name3, R.id.name4)
    val listOfViews = listOf(R.id.view1, R.id.view2, R.id.view3, R.id.view4)
    var viewC = 0

    // Collect flow in a coroutine
    GlobalScope.launch(Dispatchers.IO) {
        nameDao.readAllData().collect { names ->
            dataItems = names

            listOfViews.forEach {
                views.setViewVisibility(it, View.GONE)
            }

            dataItems.forEach {
                views.setTextViewText(listOfTextViews[viewC], it.nameInserted)
                views.setViewVisibility(listOfViews[viewC], View.VISIBLE)
                viewC++
            }

            if (dataItems[0].nameInserted == "") {
                views.setTextViewText(listOfTextViews[0], "None of your friends have a birthday today!")
            }
            if (dataItems[1].nameInserted == "") {
                views.setTextViewText(listOfTextViews[1], "None of your friends have a birthday tomorrow!")
            }
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}