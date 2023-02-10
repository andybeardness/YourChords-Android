package com.beardness.yourchordsru.utils.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback

fun Modifier.clickableHaptic(action: () -> Unit) =
    composed {
        val haptic = LocalHapticFeedback.current

        this.clickable {
            action()
            haptic.performLongClick()
        }
    }

fun Modifier.clickableWithoutRipple(action: () -> Unit) =
    composed {
        val haptic = LocalHapticFeedback.current

        this.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            action()
            haptic.performLongClick()
        }
    }

private fun HapticFeedback.performLongClick() {
    this.performHapticFeedback(HapticFeedbackType.LongPress)
}