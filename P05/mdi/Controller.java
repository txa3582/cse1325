import store.Customer;
import store.Store;
import store.Order;
public class Controller
{
    public Controller(String storeName)
    {
        this.store = store;
        this.view = view;
        this.in = in;
        this.isRunning = isRunning;
        this.output = output;
        this.mainMenu = mainMenu;

        // load menuItem instances into menu field / setup main menu

    }
    public void mdi()
    {
        while(isRunning == true)
        {
            
        }
    }

    private void exit()
    {
        isRunning = false;
    }
    private placeOrder()
    {

    }
    private newCustomer()
    {

    }
    private newTool()
    {

    }
    private newPlant()
    {

    }
    private switchView()
    {

    }
    //fields
    private Store store;
    private View view;
    private Menu mainMenu;
    private String output;
    private boolean isRunning;
    private Scanner in;


}