package com.live.lukastore.util

import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.*
import android.os.Build.VERSION.SDK_INT
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import java.io.Serializable
import java.util.*
import kotlin.random.Random


fun View.show(){
    visibility = View.VISIBLE
}
fun View.hide(){
    visibility = View.GONE
}
fun View.shouldShow(shouldShow:Boolean = true){
    visibility = if(shouldShow) View.VISIBLE else View.GONE
}
fun delay(delayMillis: Long, callback: () -> Unit) {
    val handler = Handler(Looper.getMainLooper())
    handler.postDelayed(callback, delayMillis)
}
inline fun <reified T : Serializable> Bundle.serializable(key: String): T? = when {
    SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getSerializable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getSerializable(key) as? T
}

inline fun <reified T : Serializable> Intent.serializable(key: String): T? = when {
    SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getSerializableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getSerializableExtra(key) as? T
}

fun ViewGroup.setColoredCard(
    width:Int = ViewGroup.LayoutParams.MATCH_PARENT,
    height: Int=50.toPixel(),
    cornerRadius: Float ,
    backgroundColor: Int
): View {
    val shapeDrawable = ShapeDrawable()
    shapeDrawable.shape = RoundRectShape(
        floatArrayOf(cornerRadius, cornerRadius, cornerRadius, cornerRadius,
            cornerRadius, cornerRadius, cornerRadius, cornerRadius),
        null,
        null
    )
    shapeDrawable.paint.color = backgroundColor

    val cardView = View(context)
    cardView.background = shapeDrawable

    val layoutParams = ViewGroup.LayoutParams(width, height)
    cardView.layoutParams = layoutParams

    val margin = 5//resources.getDimensionPixelSize(R.dimen.card_view_margin) // Adjust margin as desired
    val marginLayoutParams = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height)
    marginLayoutParams.setMargins(margin, margin, margin, margin)
    cardView.layoutParams = marginLayoutParams

    return cardView
}

fun Int.toPixel(): Int {
    return dpToPixels(this.toFloat())
}
fun pixelToDp(pixel: Int): Float {
    val r = Resources.getSystem()
    return pixel.toFloat() / r.displayMetrics.density
}
fun dpToPixels(dp: Float): Int {
    val r = Resources.getSystem()
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.displayMetrics).toInt()
}

fun Random.randomColor(): Int {
    val alpha = 255 // You can customize the alpha value if needed
    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)
    return Color.argb(alpha, red, green, blue)
}



