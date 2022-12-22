package com.se.sample.dao.entity;


public enum ContentTypeEnum {

    NOTFOUND_404("template_error_page"),
    HEADER("header"),
    FOOTER("footer"),
    HOMEPAGE("homepage"),
    CATEGORYPAGE_STANDARD("standard_collections"),
    PRODUCTPAGE_STANDARD("standard_product"),
    VANITY("vanity"),
    BANNERCODE("banner_codes"),
    RADIOHOST("radio_hosts"),
    CALENDAR("calendar"),
    GUIDEDNAVFORM("guided_nav_form"),
    URLFINDER("url_finder"), // global stack
    STORES("stores"),
    RECIPE("recipe"),
    HOLIDAYS("holidays"), // global stack
    SERVICE_HOLIDAYS("service_holidays"), // global stack
    OCCASIONS("occasions"), // global stack
    ADDON_GROUP("add_on_groups"),
    WRAP_UP_PRODUCTS("wrap_up_products"),
    MARKETING_SPOT("marketing_spots"),
    PRODUCT("product"), // global stack
    SAMEDAYCUTOFF("same_day_delivery_cutoff_window"), // brand
    FACET_GROUPS("facet_groups"),
    SMARTGIFTPAGE("template_page_smart_gift_shop"),
    PASSPORT_BUNDLE_PRODUCTS("passport_bundle_products"),
    UNDER_NAV_TEXT("undernavtext"),
    AB_TEST_REDIRECT("url_redirect_ab_testing"),
    FILTER_GROUPS("filter_groups"),
    FOOTER_V2("footer_v2"),
    DEPARTMENT("department"),
    BRAND_CONFIG("brand_configuration"),
    TEMPLATE_SEARCH_PAGE("template_search_page");;

    private String name;

    @SuppressWarnings("unused")
    private ContentTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static ContentTypeEnum fromString(String text) {
        ContentTypeEnum contentType = null;
        for (ContentTypeEnum type : ContentTypeEnum.values()) {
            if (type.getName().equalsIgnoreCase(text)) {
                contentType = type;
                break;
            }
        }
        return contentType;
    }
}
