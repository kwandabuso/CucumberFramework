package Engine;

public class PageElements {


    public static String tblUsers()
    {
        return "//table[contains(@class,'table table')]/tbody";
    }
    public static String btnAddUser()
    {
        return "//button[contains(text(),'Add User')]";
    }
    public static String mdlAddUser()
    {
        return "//div[@class = 'modal ng-scope']";
    }
    public static String txtFirstName()
    {
        return "FirstName";
    }
    public static String txtLastName()
    {
        return "LastName";
    }
    public static String txtUserName()
    {
        return "UserName";
    }
    public static String txtPassword()
    {
        return "Password";
    }
    public static String rdoCompanyAAA()
    {
        return "//label[text()='Company AAA']/.//input";
    }
    public static String rdoCompanyBBB()
    {
        return "//label[text()='Company BBB']/.//input";
    }
    public static String selRoleId()
    {
        return "RoleId";
    }
    public static String txtEmail()
    {
        return "Email";
    }
    public static String txtMobilePhone()
    {
        return "Mobilephone";
    }
    public static String btnSave()
    {
        return "//button[@ng-click='save(user)']";
    }

    public static String tdAddedEmail(String Email)
    {
        return "//td[text()='"+Email+"']";
    }
}
