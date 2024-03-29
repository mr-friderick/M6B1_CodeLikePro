package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.nmedia.databinding.NetologyLayoutBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = NetologyLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Не понимаю почему не получается к ресурсу strings.xml обратиться корректно через
        // R.string.post_published или R.string.post_content.
        // При этом он возвращает int, я так понимаю это какой-то идентификатор
        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий",
            published = "21 мая в 18:36",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти\n" +
                    "студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть\n" +
                    "больше, целиться выше, бежать быстрее. Наша миссия\n" +
                    "— помочь встать на путь роста и начать цепочку\n" +
                    "перемен - http://netolo.gy/fyb"
        )

        with(binding) {
            // Считаю, что при открытии кол-во просмотров увеличивается на 1
            post.views += 1

            author.text    = post.author
            published.text = post.published
            content.text   = post.content
            textShare.text = PostService.formatNumberForViews(post.shared)
            textViews.text = PostService.formatNumberForViews(post.views)
            textLike.text  = PostService.formatNumberForViews(post.likes)

            if (post.likedByMe) {
                post.likes += 1
                like.setImageResource(R.drawable.like_red)
                textLike.text = PostService.formatNumberForViews(post.likes)
            }

            like.setOnClickListener {
                post.likedByMe = !post.likedByMe
                if (post.likedByMe) {
                    post.likes += 1
                    like.setImageResource(R.drawable.like_red)
                    textLike.text = PostService.formatNumberForViews(post.likes)
                } else {
                    post.likes -= 1
                    like.setImageResource(R.drawable.like)
                    textLike.text = PostService.formatNumberForViews(post.likes)
                }
            }

            share.setOnClickListener {
                post.shared += 1
                textShare.text = PostService.formatNumberForViews(post.shared)
            }
        }
    }
}