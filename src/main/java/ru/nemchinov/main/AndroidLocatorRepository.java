package ru.nemchinov.main;

public class AndroidLocatorRepository {
    private static String ANDROID_WIDGET_XPATH_BEGINNING = "//";
    private static String ANDROID_WIDGET_XPATH_MIDDLE_PART = "[contains(";
    private static String ANDROID_WIDGET_XPATH_FINISH_PART = "')]";

    private static final String ANDROID_WIDGET_PACKAGE = "android.widget.";
    private static final String FRAME_LAYOUT_CLASS_NAME = getClassNameWithPackage("FrameLayout");
    private static final String EDIT_TEXT_CLASS_NAME = getClassNameWithPackage("EditText");
    private static final String TEXT_VIEW_CLASS_NAME = getClassNameWithPackage("TextView");
    private static final String LINEAR_LAYOUT_CLASS_NAME = getClassNameWithPackage("LinearLayout");
    public static final String IMAGE_VIEW_CLASS_NAME = getClassNameWithPackage("ImageView");
    private static final String SPINNER_CLASS_NAME = getClassNameWithPackage("Spinner");

    public static final String FIND_ICON_XPATH =
            getXPathByContentDesc(FRAME_LAYOUT_CLASS_NAME, "Поиск и интересное");

    public static final String ACTION_BAR_SEARCH_EDIT_TEXT_XPATH =
            getXPathByResourceId(EDIT_TEXT_CLASS_NAME, "action_bar_search_edit_text");

    public static final String ROW_SEARCH_USER_USERNAME_XPATH =
            getXPathByResourceId(TEXT_VIEW_CLASS_NAME, "row_search_user_username");

    public static final String ROW_PROFILE_HEADER_BUTTON_FOLLOW =
            getXPathByResourceId(TEXT_VIEW_CLASS_NAME, "row_profile_header_button_follow");

    public static final String MEDIA_SET_ROW_CONTENT_IDENTIFIER_XPATH =
            getXPathByResourceId(LINEAR_LAYOUT_CLASS_NAME, "media_set_row_content_identifier");

    public static final String ROW_FEED_BUTTON_LIKE_XPATH =
            getXPathByResourceId(IMAGE_VIEW_CLASS_NAME, "row_feed_button_like");

    public static final String PROFILE_ICON_XPATH =
            getXPathByContentDesc(FRAME_LAYOUT_CLASS_NAME, "Профиль");

    public static final String SPINNER_XPATH =
            getXPathByResourceId(SPINNER_CLASS_NAME, "spinner");

    public static final String ROW_USER_TEXTVIEW_XPATH =
            getXPathByResourceId(TEXT_VIEW_CLASS_NAME, "row_user_textview");

    private static String getClassNameWithPackage(String className) {
        return ANDROID_WIDGET_PACKAGE + className;
    }

    private static String getXPathByContentDesc(String className, String contentDesc) {
        return ANDROID_WIDGET_XPATH_BEGINNING +
                className + ANDROID_WIDGET_XPATH_MIDDLE_PART +
                "@content-desc, '" + contentDesc + ANDROID_WIDGET_XPATH_FINISH_PART;
    }

    private static String getXPathByResourceId(String className, String resourceId) {
        return ANDROID_WIDGET_XPATH_BEGINNING +
                className + ANDROID_WIDGET_XPATH_MIDDLE_PART +
                "@resource-id, '" + resourceId + ANDROID_WIDGET_XPATH_FINISH_PART;
    }
}
