//
//  GradientSurface.swift
//  iosApp
//
//  Created by Vincent Erb on 07/06/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct GradientSurface: ViewModifier {
    @Environment(\.colorScheme) var colorScheme
    
    func body(content: Content) -> some View {
        if colorScheme == .dark {
            let gradientStart = Color(hex: 0xFF23262E)
            let gradientEnd = Color(hex: 0xFF212329)
            content
                .background(
                    LinearGradient(
                        gradient: Gradient(colors: [gradientStart, gradientEnd]),
                        startPoint: .top,
                        endPoint: .bottom
                    )
                )
        } else {
            content.background(Color.surface)
        }
    }
}

extension View {
    func gradientSurface() -> some View {
        modifier(GradientSurface())
    }
}
