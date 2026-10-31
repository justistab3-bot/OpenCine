package com.opencapture.monitorui.settings

import com.opencapture.monitorui.operatorText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key

/** Source-interpreted connection facts; no transport or credential storage ownership. */
@Composable
fun MonitorConnectionSettings(
    transport: String, transportHelp: String, phase: String, phaseHelp: String,
    network: String? = null, networkHelp: String = "",
) {
    MonitorSettingsRowCard(title = operatorText("Connection")) {
        MonitorSettingsInlineRow(title = operatorText("Current Transport"), help = transportHelp, showTopDivider = false) {
            MonitorSettingsValueText(transport)
        }
        MonitorSettingsInlineRow(title = operatorText("Phase"), help = phaseHelp) { MonitorSettingsValueText(phase) }
        if (network != null) {
            MonitorSettingsInlineRow(title = operatorText("Camera Wi-Fi"), help = networkHelp) { MonitorSettingsValueText(network) }
        }
    }
}

data class MonitorSavedCameraSummary(val id: String, val name: String, val detail: String, val network: String? = null)

/** Read-only summaries; pairing remains the host's cameras flow. */
@Composable
fun MonitorSavedCameraSettings(cameras: List<MonitorSavedCameraSummary>, emptyHelp: String) {
    MonitorSettingsRowCard(title = operatorText("Your cameras")) {
        if (cameras.isEmpty()) {
            MonitorSettingsInlineRow(title = operatorText("Saved"), help = emptyHelp, showTopDivider = false) {
                MonitorSettingsValueText("None")
            }
        } else {
            cameras.forEachIndexed { index, camera ->
                key(camera.id) {
                    MonitorSettingsInlineRow(title = camera.name, help = camera.detail, showTopDivider = index > 0) {
                        MonitorSettingsValueText(camera.network ?: "Saved")
                    }
                }
            }
        }
    }
}
