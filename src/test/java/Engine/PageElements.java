package Engine;

public class PageElements {

    public static String txtUsernameID()
    {
        return "user-name";
    }

    public static String txtPasswordID()
    {
        return "password";
    }

    public static String btnLoginID()
    {
        return "login-button";
    }

    public static String btnAddToCartXpath()
    {
        return "(//button[@class= 'btn_primary btn_inventory'])[1]";
    }

    public static String CartItemsXpath()
    {
        return "//span[@class='fa-layers-counter shopping_cart_badge']";
    }


    public static String btnCartXpath()
    {
        return "//div[@id='shopping_cart_container']//a";
    }

    public static String lblInventoryItemPriceXpath()
    {
        return "//div[@class='inventory_item_price']";
    }

    public static String btnCheckoutXpath()
    {
        return "//a[@class='btn_action checkout_button']";
    }

    public static String txtNameID()
    {
        return "first-name";
    }
    public static String txtLastNameID()
    {
        return "last-name";
    }
    public static String txtPostalCode()
    {
        return "postal-code";
    }

    public static String btnContinueXpath()
    {
        return "//input[@value='CONTINUE']";
    }
    public static String lstCartItemXpath()
    {
        return "//div[@class='cart_item']";
    }
    public static String btnFinishXpath()
    {
        return "//a[@class='btn_action cart_button']";
    }
    public static String lblErrorXpath()
    {
        return "//h3[@data-test='error']";
    }
    public static String hdrProductsXpath()
    {
        return "//div[@class='product_label']";
    }

    public static String imgPonyExpressXpath()
    {
        return "//div[@id='checkout_complete_container']";
    }


    public static String genresAccessXpath()
    {
        return "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout";
    }

    public static String jazzAndBluesXpath()
    {
        return "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[3]";
    }

    public static String songXpath()
    {
        return "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[1]";
    }
    public static String playingSongID()
    {
        return "com.instantappsample.uamp:id/fragment_playback_controls";
    }
    public static String songsListID()
    {
        return "com.instantappsample.uamp:id/list_view";
    }

    public static String genresListID()
    {
        return "com.instantappsample.uamp:id/list_view";
    }



}
