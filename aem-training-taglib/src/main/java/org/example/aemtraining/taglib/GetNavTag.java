package org.example.aemtraining.taglib;

import com.cqblueprints.taglib.CqSimpleTagSupport;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.squeakysand.jsp.tagext.annotations.JspTag;
import com.squeakysand.jsp.tagext.annotations.JspTagAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import java.io.IOException;

/**
 * Created by Ihar_Zhavarankau on 6/25/2014.
 */
@JspTag
public class GetNavTag extends CqSimpleTagSupport {
    private static final Logger LOG = LoggerFactory.getLogger(GetNavTag.class);
    private static final String FIRST_LVL_PROP = "root";
    private static final String SECOND_LVL_PROP = "multiTab";


    private String var;


    public String getVar() {
        return var;
    }
    @JspTagAttribute(required = true)
    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            NavBean navBean = new NavBean();
            PageManager pm = getPageManager();
            Integer i = 1;
            String strFirst = getCurrentStyle().get(FIRST_LVL_PROP + i, String.class);
            while (strFirst != null){
                try {
                    Page p = pm.getPage(strFirst);
                    navBean.getFirstLevel().add(p);
                    strFirst = getCurrentStyle().get(FIRST_LVL_PROP + ++i, String.class);
                } catch (Exception e) {
                    strFirst = null;
                    LOG.info("End of first lvl", e);
                }
            }
            try {
                String[] secondLevel = null;
                try {
                    secondLevel = getCurrentStyle().get(SECOND_LVL_PROP + getCurrentPage().getTitle(), String[].class);
                    navBean.setCurrentFirstLevel(getCurrentPage());
                } catch (Exception e) {
                    LOG.info("", e);
                }
                if (secondLevel == null) {
                    secondLevel = getCurrentStyle().get(SECOND_LVL_PROP + getCurrentPage().getParent().getTitle(), String[].class);
                    navBean.setCurrentFirstLevel(getCurrentPage().getParent());
                }
                for (String strSecond : secondLevel) {
                    navBean.getSecondLevel().add(pm.getPage(strSecond));
                }
            }catch (Exception e) {
                LOG.info("", e);
            }
            setPageAttribute(var, navBean);
        } catch (Exception e) {
            LOG.warn("", e);
        }
    }
}
