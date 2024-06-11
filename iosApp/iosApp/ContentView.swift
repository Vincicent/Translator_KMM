import SwiftUI
import shared

struct ContentView: View {
    
    let appModule: AppModule
    
    var body: some View {
        NavigationView {
            ZStack {
                Color.background
                    .ignoresSafeArea()
                TranslateScreen(
                    historyDataSource: appModule.historyDataSource,
                    translateUseCase: appModule.translateUseCase,
                    parser: appModule.voiceParser
                )
            }
        }
    }
}

public extension View {
    func transparentScrolling() -> some View {
        if #available(iOS 16.0, *) {
            return scrollContentBackground(.hidden)
        } else {
            return onAppear {
                UITextView.appearance().backgroundColor = .clear
            }
        }
    }
}
