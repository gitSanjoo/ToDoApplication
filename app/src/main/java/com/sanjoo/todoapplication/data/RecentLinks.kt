package com.sanjoo.todoapplication.data

import com.google.gson.annotations.SerializedName

data class RecentLinks(
    @SerializedName("url_id")
    var urlId: Int? = null,
    @SerializedName("web_link")
    var webLink: String? = null,
    @SerializedName("smart_link")
    var smartLink: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("total_clicks")
    var totalClicks: Int? = null,
    @SerializedName("original_image")
    var originalImage: String? = null,
    @SerializedName("thumbnail")
    var thumbnail: String? = null,
    @SerializedName("times_ago")
    var timesAgo: String? = null,
    @SerializedName("created_at")
    var createdAt: String? = null,
    @SerializedName("domain_id")
    var domainId: String? = null,
    @SerializedName("url_prefix")
    var urlPrefix: String? = null,
    @SerializedName("url_suffix")
    var urlSuffix: String? = null,
    @SerializedName("app")
    var app: String? = null,
    @SerializedName("is_favourite")
    var isFavourite: Boolean? = null

)
