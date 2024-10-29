import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Contact{
    private String name;
    private String phoneNumber;

    public Contact (String name, String phoneNumber){
        this .name= name;
        this.phoneNumber= phoneNumber;

    }
    //for get method name value
    public String getName(){
        return name;

    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    @Override
// overrde the toSting methode
    public String toString(){
        return name+" -"+ phoneNumber;
    }
}

class MyFrame extends JFrame implements ActionListener{

    private DefaultListModel<String> listModel;
    private JList<String> contactList;

    JPanel inputPanel,mainPanel,buttonPanel;
    JLabel nameLabel,phoneLabel;
    JTextField nameField,phoneField;
    JButton addButton,deleteButton;



    MyFrame(){
        listModel= new DefaultListModel<>();
        contactList = new JList<>(listModel);

        
        inputPanel = new JPanel(new GridLayout(2,2));
        nameLabel= new JLabel("Name : ");
        phoneLabel = new JLabel("Phone Number: ");

        nameField = new JTextField();
        phoneField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);

        addButton = new JButton("Add contact");
        deleteButton = new JButton("Delete contact");

        addButton.addActionListener(this);
        deleteButton.addActionListener(this);

        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);




        mainPanel= new JPanel(new BorderLayout());
        mainPanel.add(inputPanel,BorderLayout.NORTH);

        mainPanel.add(new JScrollPane(contactList),BorderLayout.CENTER);

        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        this.add(mainPanel);
        





    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addButton){
            String name= nameField.getText();
            String phoneNumber= phoneField.getText();

            Contact contact = new Contact(name, phoneNumber);
            listModel.addElement(contact.toString());

            nameField.setText("");
            phoneField.setText("");

        }
        if(e.getSource()==deleteButton){
            int selectINdex= contactList.getSelectedIndex();
            if(selectINdex  != -1){
                listModel.remove(selectINdex);
            }

            
        }

    }





}
class cont{
   public static void main(String[]args){
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.setTitle("Contact Managment System");
        frame.setSize(400,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



   }
}