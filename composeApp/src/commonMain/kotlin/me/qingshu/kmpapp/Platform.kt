package me.qingshu.kmpapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform