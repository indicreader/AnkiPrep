package com.example.flashcardapp.data.plugin

import com.google.gson.annotations.SerializedName

/**
 * Metadata extracted from plugin `@manifest` JSON block.
 */
data class PluginManifest(
    val id: String,
    val name: String,
    val version: String = "1.0.0",
    val author: String = "Community",
    @SerializedName("inputType", alternate = ["input_type", "type"])
    val inputType: String = "TEXT_PDF", // TEXT_PDF, RSS_ATOM, HTML_SCRAPE
    val description: String = ""
)

/**
 * Question object returned by QuickJS `parse(input)` JS execution.
 */
data class PluginParsedQuestion(
    val question: String = "",
    @SerializedName("option_a", alternate = ["optionA", "a", "A"])
    val optionA: String = "",
    @SerializedName("option_b", alternate = ["optionB", "b", "B"])
    val optionB: String = "",
    @SerializedName("option_c", alternate = ["optionC", "c", "C"])
    val optionC: String = "",
    @SerializedName("option_d", alternate = ["optionD", "d", "D"])
    val optionD: String = "",
    val answer: String = "A", // "A", "B", "C", "D"
    val explanation: String = "",
    val topic: String = "General",
    @SerializedName("sub_topic", alternate = ["subTopic", "subtopic", "section"])
    val subTopic: String = "General",
    @SerializedName("exam_raw_tag", alternate = ["examRawTag", "rawTag", "tag", "exam_tag"])
    val examRawTag: String = ""
)
