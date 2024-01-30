package com.sanjoo.todoapplication.data

import com.google.gson.annotations.SerializedName
import com.google.gson.internal.LinkedTreeMap

data class LinkData(
    @SerializedName("recent_links")
    var recentLinks: ArrayList<RecentLinks> = arrayListOf(),
    @SerializedName("top_links")
    var topLinks: ArrayList<TopLinks> = arrayListOf(),
    @SerializedName("favourite_links")
    var favouriteLinks: ArrayList<String> = arrayListOf(),
    @SerializedName("overall_url_chart")
    var overallUrlChart: LinkedTreeMap<String, Long>? = LinkedTreeMap()

)
