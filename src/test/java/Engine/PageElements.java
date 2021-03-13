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
        return "//img[@class='pony_express']";
    }


    public static String AlbumIdXpath()
    {
        return "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView[3]";
    }

    public static String AlbumsListId()
    {
        return "com.example.android.uamp.next:id/list";
    }
    public static String songsListId()
    {
        return "com.example.android.uamp.next:id/albumArt";
    }

    public static String jazzAndBluesXpath()
    {
        return "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]";
    }

    public static String theMessanger()
    {
        return "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]";
    }


}
