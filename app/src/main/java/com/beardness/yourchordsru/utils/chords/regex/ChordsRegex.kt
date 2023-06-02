package com.beardness.yourchordsru.utils.chords.regex

private const val OPEN_TAG = "<b>"
private const val CLOSE_TAG = "</b>"
private const val CHORD_PATTERN = "$OPEN_TAG.+?$CLOSE_TAG"


fun String.chordsTextToDistinctChordsByRegex(): List<String> =
    CHORD_PATTERN
        .toRegex()
        .findAll(input = this)
        .map { matchResult -> matchResult.value }
        .map { chord ->
            chord.replace(oldValue = OPEN_TAG, newValue = "")
                .replace(oldValue = CLOSE_TAG, newValue = "")
        }
        .toList()
        .distinct()
