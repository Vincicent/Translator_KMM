//
//  VoiceRecorderButton.swift
//  iosApp
//
//  Created by Vincent Erb on 11/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct VoiceRecorderButton: View {
    var displayState: DisplayState
    var onClick: () -> Void
    
    var body: some View {
        Button(action: onClick) {
            ZStack {
                Circle()
                    .foregroundColor(.primaryColor)
                    .padding()
                icon
                    .foregroundColor(.onPrimary)
            }
        }.frame(maxWidth: 100, maxHeight: 100)
    }
    
    var icon: some View {
        switch displayState {
        case .waitingToTalk:
            return Image(uiImage: UIImage(named: "mic")!)
        case .displayingResults:
            return Image(systemName: "checkmark")
        default:
            return Image(systemName: "stop.fill")
        }
    }
}

#Preview {
    VoiceRecorderButton(
        displayState: .speaking,
        onClick: {}
    )
}
