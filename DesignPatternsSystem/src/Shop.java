public class Shop {
    private boolean open;
    private String description;
    private static Shop uniqueInstance;

    private Shop(){
        open = false;
        description = "Shop Closed";
    }

    public static Shop getInstance(){
        if(uniqueInstance == null){
            System.out.println("Creating Instance of Phone Shop");
            uniqueInstance = new Shop();
        }
        System.out.println("Returning instance of Phone Shop");
        return uniqueInstance;
    }

    public void openShop(){
        if(!open)
        {
            open = true;
            description = "Shop is Opened";
            System.out.print(description);
        }
    }

    public void closedForLunch()
    {
        if(open = true)
        {
            open = false;
            description = "Closed for lunch...back soon";
            System.out.print(description);
        }
    }

    public void closeShop()
    {
        if(open = true)
        {
            open = false;
            description = "Shop is Closed";
            System.out.print(description);
        }
    }

    public boolean shopStatus() {
        return open;
    }

    public String shopDescription() {
        return description;
    }

}
