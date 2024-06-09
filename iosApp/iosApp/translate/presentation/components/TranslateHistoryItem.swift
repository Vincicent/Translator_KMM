//
//  TranslateHistoryItem.swift
//  iosApp
//
//  Created by Vincent Erb on 09/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TranslateHistoryItem: View {
    let item: UiHistoryItem
    let onClick: () -> Void
    
    var body: some View {
        Button(action: onClick) {
            VStack(alignment: .leading) {
                HStack {
                    SmallLanguageIcon(language: item.fromLanguage)
                        .padding(.trailing)
                    Text(item.fromText)
                        .foregroundColor(.lightBlue)
                        .font(.body)
                }
                .padding(.bottom)
                .frame(maxWidth: .infinity, alignment: .leading)
                
                HStack {
                    SmallLanguageIcon(language: item.toLanguage)
                        .padding(.trailing)
                    Text(item.fromText)
                        .foregroundColor(.onSurface)
                        .font(.body.weight(.semibold))
                }
                .padding(.bottom)
                .frame(maxWidth: .infinity, alignment: .leading)
            }
            .padding()
            .frame(maxWidth: .infinity)
            .gradientSurface()
            .cornerRadius(15)
            .shadow(radius: 4)
        }
    }
}

#Preview {
    TranslateHistoryItem(
        item: UiHistoryItem(
            id: 123,
            fromText: "test",
            toText: "test",
            fromLanguage: UiLanguage(language: .french, imageName: "french"),
            toLanguage: UiLanguage(language: .english, imageName: "english")),
        onClick: {}
    )
}
