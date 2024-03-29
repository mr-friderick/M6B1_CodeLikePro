package ru.netology.nmedia

import ru.netology.nmedia.databinding.NetologyLayoutBinding
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

object PostService {
    fun formatNumberForViews(number: Long): String {
        val suffix = charArrayOf(' ', 'K', 'M', 'B', 'T', 'P', 'E')
        val value = floor(log10(number.toDouble())).toInt()
        val base = value / 3

        return if (value >= 3 && base < suffix.size) {
            DecimalFormat("#.#").format(number / 10.0.pow((base * 3).toDouble())) + suffix[base]
        } else {
            DecimalFormat("#,##0").format(number)
        }
    }

//    fun changeViewLikes(binding: NetologyLayoutBinding) {
//        binding.like.setImageResource(R.drawable.like_red)
//        binding.textLike.text = PostService.formatNumberForViews(post.likes)
//    }
}