package ru.netology.nmedia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.NetologyLayoutBinding
import ru.netology.nmedia.viewmodel.PostViewModel
import ru.netology.nmedia.viewmodel.PostService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = NetologyLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                textShare.text = PostService.formatNumberForViews(post.shared)
                textViews.text = PostService.formatNumberForViews(post.views)
                textLike.text  = PostService.formatNumberForViews(post.likes)

                like.setImageResource(
                    if (post.likedByMe) R.drawable.like_red else R.drawable.like
                )

                like.setOnClickListener {
                    viewModel.like()
                }

                share.setOnClickListener {
                    viewModel.share()
                }
            }
        }
    }
}