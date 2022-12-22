package com.se.sample.dao.entity;


import org.springframework.util.StringUtils;

public abstract class Section extends BaseEntity{

    private String viewport;
    private String content;
    // Note: contents are pulled in by resolver (i.e. HeaderResolver)

    public Section(String brand, String environment, String locale, String currency) {
        super(brand, environment, locale, currency);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getViewport()
    {
        // FE will pass all lower cased - but capitalized in CMS
        return StringUtils.capitalize(viewport);
    }

    public void setViewport(String viewport)
    {
        this.viewport = viewport;
    }
}

