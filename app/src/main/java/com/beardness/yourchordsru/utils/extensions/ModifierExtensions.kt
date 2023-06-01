package com.beardness.yourchordsru.utils.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.semantics.Role

fun Modifier.clickableHaptic(
    action: () -> Unit,
    enabled: Boolean = true,
    role: Role? = null,
) = composed {
    val haptic = LocalHapticFeedback.current

    this.clickable(
        enabled = enabled,
        role = role,
        onClick = {
            action()
            haptic.performLongClick()
        }
    )
}

fun Modifier.clickableHapticNoRipple(
    action: () -> Unit,
    enabled: Boolean = true,
    role: Role? = null,
) =
    composed {
        val haptic = LocalHapticFeedback.current

        this.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            enabled = enabled,
            role = role,
        ) {
            action()
            haptic.performLongClick()
        }
    }

private fun HapticFeedback.performLongClick() {
    this.performHapticFeedback(HapticFeedbackType.LongPress)
}