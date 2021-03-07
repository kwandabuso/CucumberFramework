package Engine;

public class PageElements {

    public static String txtUsernameID()
    {
        return "UserName";
    }

    public static String txtPasswordID()
    {
        return "Password";
    }

    public static String btnLoginID()
    {
        return "loginLink";
    }

    public static String txtLogoutXpath()
    {
        return "//a[contains(@href,'logout')]";
    }


    public static String btnLoginSubmitXpath()
    {
        return "//input[@value='Log in']";
    }

    public static String lnkEmployeeListXpath()
    {
        return "//div[@class='container']//a[text()='Employee List']";
    }

    public static String btnCreateNewXpath()
    {
        return "//a[@href='/Employee/Create']";
    }

    public static String txtNameID()
    {
        return "Name";
    }
    public static String txtSalaryID()
    {
        return "Salary";
    }
    public static String txtDurationWorkedID()
    {
        return "DurationWorked";
    }

    public static String txtGradeID()
    {
        return "Grade";
    }

    public static String txtEmailID()
    {
        return "Email";
    }
    public static String btnCreateXpath()
    {
        return "//input[@value='Create']";
    }
    public static String tblEmployeeListXpath()
    {
        return "//table";
    }
    public static String frmAddEmployeepath()
    {
        return "//form[@action='/Employee/Create']";
    }
    public static String newEmployeeByXpath(String Email)
    {
        return "//td[contains(text(),'"+Email+"')]";
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
