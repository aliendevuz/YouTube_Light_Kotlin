package com.example.youtubelightkotlin.model

class Feed {
    var short2s = ArrayList<Short2>()
    var profile = 0
    var video = 0

    constructor(short2s: ArrayList<Short2>) {
        this.short2s = short2s
    }

    constructor(profile: Int, video: Int) {
        this.profile = profile
        this.video = video
    }
}
