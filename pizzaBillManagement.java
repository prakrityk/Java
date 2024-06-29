import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class pizzaBillManagement extends Frame {

    TextField customerNameField;
    TextField toppingsField;
    CheckboxGroup sizeGroup;
    Checkbox small, medium, large;
    TextArea billArea;
    Button enterButton, displayButton, searchButton, exitButton;
    ArrayList<PizzaOrder> orders;

    public pizzaBillManagement() {
        // Setting layout manager
        setLayout(new FlowLayout());
        
        orders = new ArrayList<>();

        // Customer name field
        Label nameLabel = new Label("Customer Name:");
        customerNameField = new TextField(20);
        add(nameLabel);
        add(customerNameField);

        // Number of toppings field
        Label toppingsLabel = new Label("Number of Toppings:\n");
        toppingsField = new TextField(2);
        add(toppingsLabel);
        add(toppingsField);

        // Size checkbox group
        sizeGroup = new CheckboxGroup();
        small = new Checkbox("Small", sizeGroup, false);
        medium = new Checkbox("Medium", sizeGroup, true);
        large = new Checkbox("Large", sizeGroup, false);

        add(new Label("Size:"));
        add(small);
        add(medium);
        add(large);

        // Enter button
         enterButton = new Button("Enter");
        //Other buttons
         displayButton=new Button("Display All");
         exitButton= new Button("Exit");
      

        // TextArea to display the bill
        billArea = new TextArea(10, 40);
        billArea.setText("Customer Name\t \t Garments \t \t  Size\n ---------------------------------------------------------------------------------------------------\n");
        add(billArea);
        add(enterButton);
        add(displayButton);
        add(exitButton);
        // Adding event listener to the button
        exitButton.addActionListener( new ActionListener()
        		{
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        		});
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBill();
            }
        });

        // Window settings
        setTitle("Pizza Order Management System");
        setSize(450, 300);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
    private void addOrder() {
        String name = customerNameField.getText();
        String toppings = toppingsField.getText();
        String size = sizeGroup.getSelectedCheckbox().getLabel();

        PizzaOrder order = new PizzaOrder(name, toppings, size);
        orders.add(order);
        
    }

    private void displayBill() {
        String name = customerNameField.getText();
        String toppings = toppingsField.getText();
        String size = sizeGroup.getSelectedCheckbox().getLabel();

        billArea.append( name + "\t ");
        billArea.append( "\t"+toppings + "\t");
        billArea.append("\t"+size + "\n");
    }

    public static void main(String[] args) {
        new pizzaBillManagement(); // creating an object
    }
}

class PizzaOrder {
    private String customerName;
    private String toppings;
    private String size;

    public PizzaOrder(String customerName, String toppings, String size) {
        this.customerName = customerName;
        this.toppings = toppings;
        this.size = size;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getToppings() {
        return toppings;
    }

    public String getSize() {
        return size;
    }
}
