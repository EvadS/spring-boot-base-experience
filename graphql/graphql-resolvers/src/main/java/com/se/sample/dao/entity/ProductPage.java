package com.se.sample.dao.entity;

import org.apache.commons.lang3.StringUtils;

public class ProductPage extends Section{

    private String url;
    private String id;
    private String partNumber;
    private String categoryId;
    private PricingOptions pricingOptions;

    // note: product is pulled in by resolver

    private String contentType;

    public ProductPage(String brand, String environment, String locale, String currency) {
        super(brand, environment, locale, currency);
    }


    public ProductPage(String brand, String environment, String locale, String currency, String url, String categoryId, String contentType) {
        super(brand, environment, locale, currency);
        setUrl(url);
        setCategoryId(categoryId);
        setContentType(contentType);
    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public String getContentType()
    {
        return StringUtils.defaultIfBlank(contentType, ContentTypeEnum.PRODUCTPAGE_STANDARD.getName());
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }


    public String getCategoryId()
    {
        return categoryId;
    }


    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getPartNumber()
    {
        return partNumber;
    }

    public void setPartNumber(String partNumber)
    {
        this.partNumber = partNumber;
    }


    public PricingOptions getPricingOptions() {
        return pricingOptions;
    }


    public void setPricingOptions(PricingOptions pricingOptions) {
        this.pricingOptions = pricingOptions;
    }


    @Override
    public String toString() {
        return "ProductPage{" +
                "url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}