package io.dorum.actions;

import net.serenitybdd.core.steps.UIInteractions;

public class NavigateAction extends UIInteractions {
    public void toTheDuckDuckGoSearchPage() {
        openUrl("https://www.sauselab.com");
    }
}
