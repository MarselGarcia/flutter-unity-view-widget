package com.xraph.plugin.flutter_unity_widget

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.Configuration
import android.util.Log
import android.view.InputDevice
import android.view.MotionEvent
import com.unity3d.player.IUnityPlayerLifecycleEvents
import com.unity3d.player.UnityPlayer

@SuppressLint("NewApi")
class CustomUnityPlayer(context: Activity, upl: IUnityPlayerLifecycleEvents?) : UnityPlayer(context, upl) {

    companion object {
        internal const val LOG_TAG = "CustomUnityPlayer"
    }

    override fun cleanupResourcesForDestroy(): Unit {
        Log.i(LOG_TAG, "cleanupResourcesForDestroy")
        return super.cleanupResourcesForDestroy()
    }

    override fun onOrientationChanged(p0: Int, p1: Int): Unit {
        Log.i(LOG_TAG, "onOrientationChanged")
        return super.onOrientationChanged(p0, p1)
    }

    override fun getGfxView(): View! {
        Log.i(LOG_TAG, "getGfxView")
        return super.getGfxView()
    }

    override fun handleFocus(p0: Boolean): Boolean {
        Log.i(LOG_TAG, "handleFocus")
        return super.handleFocus(p0)
    }

    override fun setMainSurfaceViewAspectRatio(p0: Float): Unit {
        Log.i(LOG_TAG, "setMainSurfaceViewAspectRatio")
        return super.setMainSurfaceViewAspectRatio(p0)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        Log.i(LOG_TAG, "ORIENTATION CHANGED")
        super.onConfigurationChanged(newConfig)
    }

    override fun onAttachedToWindow() {
        Log.i(LOG_TAG, "onAttachedToWindow")
        super.onAttachedToWindow()
        UnityPlayerUtils.resume()
        UnityPlayerUtils.pause()
        UnityPlayerUtils.resume()
    }

    override fun onDetachedFromWindow() {
        Log.i(LOG_TAG, "onDetachedFromWindow")
        // todo: fix more than one unity view, don't add to background.
//        UnityPlayerUtils.addUnityViewToBackground()
        super.onDetachedFromWindow()
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        ev.source = InputDevice.SOURCE_TOUCHSCREEN
        return super.dispatchTouchEvent(ev)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean{
        if (event == null) return false

        event.source = InputDevice.SOURCE_TOUCHSCREEN
        return super.onTouchEvent(event)
    }

}