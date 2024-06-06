//
//  SwapLanguageButton.swift
//  iosApp
//
//  Created by Vincent Erb on 06/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct SwapLanguageButton: View {
    var onClick: () -> Void
    var body: some View {
        Button(action: onClick) {
            Image(uiImage: UIImage(named: "swap_languages")!)
                .padding()
                .background(Color.primaryColor)
                .clipShape(/*@START_MENU_TOKEN@*/Circle()/*@END_MENU_TOKEN@*/)
        }
    }
}

#Preview {
    SwapLanguageButton(
        onClick: {}
    )
}
