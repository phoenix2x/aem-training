package org.example.aemtraining.services.osgi.i18n;

import com.day.cq.i18n.I18n;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * library for client side i18n:
 * /etc/clientlibs/granite/utils/source/I18n.js
 */

public class I18nTest {
    public void fromPageLocale(Page page, SlingHttpServletRequest request) {
        Locale locale = page.getLanguage(false);
        ResourceBundle resourceBundle = request.getResourceBundle(locale);
        I18n i18n = new I18n(resourceBundle);
        //message can have placeholders like this {0}, {1}
        //they will be replaced by 3 and 4 param of i18n.get
        //comment is used when we have two different translation for the same word(key)
        //Eg. "Request" "noun" - Запрос vs "Request" "verb" - Запросить
        //
        String message = i18n.get("component-name.btn.submit.title", "comment", "item to placeholder");
    }

    //can be used for Author interfaces
    public void fromUserLocale(Page page, SlingHttpServletRequest request) {
        I18n i18n = new I18n(request);
    }
}
