package ru.netology.nmedia.viewmodel

import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

object PostService {
    fun formatNumberForViews(number: Long): String {
        val suffix = charArrayOf(' ', 'K', 'M', 'B', 'T', 'P', 'E')
        val value = floor(log10(number.toDouble())).toInt()
        val base = value / 3

        val df = when {
            value == 4 || value == 5 -> DecimalFormat("#")
            value >= 3 -> DecimalFormat("#.#")
            else -> DecimalFormat("#,##0")
        }
        df.roundingMode = RoundingMode.DOWN

        return if (value >= 3)
            df.format(number / 10.0.pow((base * 3).toDouble())) + suffix[base]
        else df.format(number)
    }
}