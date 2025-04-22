package com.example.grid_chapter3gg.data

import com.example.grid_chapter3gg.R
import com.example.grid_chapter3gg.model.Course

class DataSource  {
    fun getData(): List<Course>{
        return listOf<Course>(
            Course("Math", 58, imageResources = R.drawable.postcard, iconResources = R.drawable.postcard ),
            Course("Physics", 95, R.drawable.loading, R.drawable.loading),
            Course("Biology", 68, R.drawable.menugroup, R.drawable.menugroup),
            Course("Biology", 68, R.drawable.icons8_done_15__1_, R.drawable.icons8_done_15__1_),
            Course("Biology", 68, R.drawable.postcard, R.drawable.menugroup),
            Course("Biology", 68, R.drawable.ic_launcher_background, R.drawable.menugroup),
            Course("Physics", 95, R.drawable.loading, R.drawable.loading),
            Course("Biology", 68, R.drawable.menugroup, R.drawable.menugroup),
            Course("Biology", 68, R.drawable.icons8_done_15__1_, R.drawable.icons8_done_15__1_),
            Course("Biology", 68, R.drawable.postcard, R.drawable.menugroup),
            Course("Math", 58, imageResources = R.drawable.postcard, iconResources = R.drawable.postcard ),
            Course("Physics", 95, R.drawable.loading, R.drawable.loading),
            Course("Biology", 68, R.drawable.menugroup, R.drawable.menugroup),
            Course("Biology", 68, R.drawable.icons8_done_15__1_, R.drawable.icons8_done_15__1_),
            Course("Biology", 68, R.drawable.postcard, R.drawable.menugroup),
            Course("Biology", 68, R.drawable.ic_launcher_background, R.drawable.menugroup),
            Course("Physics", 95, R.drawable.loading, R.drawable.loading),
            Course("Biology", 68, R.drawable.menugroup, R.drawable.menugroup),
            Course("Biology", 68, R.drawable.icons8_done_15__1_, R.drawable.icons8_done_15__1_),
            Course("Biology", 68, R.drawable.postcard, R.drawable.menugroup),
            Course("Math", 58, imageResources = R.drawable.postcard, iconResources = R.drawable.postcard ),
            Course("Physics", 95, R.drawable.loading, R.drawable.loading),
            Course("Biology", 68, R.drawable.menugroup, R.drawable.menugroup),
            Course("Biology", 68, R.drawable.icons8_done_15__1_, R.drawable.icons8_done_15__1_),
            Course("Biology", 68, R.drawable.postcard, R.drawable.menugroup),
            Course("Biology", 68, R.drawable.ic_launcher_background, R.drawable.menugroup),
            Course("Physics", 95, R.drawable.loading, R.drawable.loading),
            Course("Biology", 68, R.drawable.menugroup, R.drawable.menugroup),
            Course("Biology", 68, R.drawable.icons8_done_15__1_, R.drawable.icons8_done_15__1_),
            Course("Biology", 68, R.drawable.postcard, R.drawable.menugroup)
        )
    }
}