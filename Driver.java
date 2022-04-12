import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.IOException;



public class Driver {
    static ArrayList<Emp> arrayList = new ArrayList<>();

    public static void main(String[] args) {
    	//information to put into file
    	Emp p1 = new Emp("1", "Cindy1", "1111111", "01/01/1994", "a@gmail.com");
    	Emp p2 = new Emp("2", "Cindy2", "2222222", "02/02/1995", "b@gmail.com");
    	Emp p3 = new Emp("3", "Cindy3", "3333333", "03/03/1996", "c@gmail.com");
    	Emp p4 = new Emp("4", "Cindy4", "4444444", "04/04/1997", "d@gmail.com");
    	Emp p5 = new Emp("5", "Cindy5", "5555555", "05/05/1998", "e@gmail.com");
    	Emp p6 = new Emp("6", "Cindy6", "6666666", "06/06/1999", "f@gmail.com");   
    	
        arrayList.add(p1);
        arrayList.add(p2);
        arrayList.add(p3);
        arrayList.add(p4);
        arrayList.add(p5);
        arrayList.add(p6);
        
        Driver osd = new Driver();
        //Creating scanner object
        Scanner sc = new Scanner(System.in);
        
        //loop menu
        while (menu()) {
            int choice = 0;
            System.out.print("Please Enter Your Selection : ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
				case 1:
					osd.addInformationIntoAFile(arrayList);
				    break;
				    
				case 2: { 
					try {
					osd.retreiveInformationFromAFile();
				        
					} catch (IOException ex) {
				    }
				} 
				break;
				case 3:
				       	System.out.print("Please Enter ID Number : ");
				       	String pIDNumber = sc.nextLine();
				       	Emp empDel = null;
				                    // Iterate arrayList.
	                    for (Emp st : arrayList) {
				                        //Find Person to be deleted by id.
				            if (st.getId().equalsIgnoreCase(pIDNumber)) {
	                            empDel = st;
	                            }
				        }
				         //If Person is null, then show error message,otherwise remove the Person from Person list.
		                if (empDel == null) {
		                	System.out.println("Invalid ID");
				        } 
		                else {
	                       arrayList.remove(empDel);
		                }
				        break;
				case 4:
	                    osd.addInformationIntoAFile(arrayList);
	                    break;
                case 5:
                	System.out.println("Thank you for using the program");
				    //exit 
                	System.exit(0);
                	break;
                default:
                    System.out.println("Enter valid choice ");
                    break;
				} 
        }
        sc.close();
    }
// set up menu
    public static boolean menu() {
        System.out.println(""
                + "\n1: Add information into a file."
                + "\n2: Retrieve information from a file and display them."
                + "\n3: Delete information."
                + "\n4: Update information."
                + "\n5: Exit."
                + "\n");
        System.out.print("Please Enter your Option: ");
        return true;
    }

    private void addInformationIntoAFile(ArrayList<Emp> arrayList) {
        try {
            FileOutputStream fos = new FileOutputStream(new File("emp.bin"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            /*add items*/
            oos.writeObject(arrayList);
            oos.close();
        } catch (IOException ex) {
            System.out.println("" + ex.getMessage());
        } 
    }

    //Throws IOE
    private void retreiveInformationFromAFile() throws IOException {
        ObjectInputStream os = null;
        ArrayList<Emp> retreivedData = null;
        try {
            FileInputStream is = new FileInputStream("emp.bin");
            os = new ObjectInputStream(is);
            retreivedData = (ArrayList<Emp>) os.readObject();
     
        } catch (EOFException e) {
            System.out.println("" + e.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("" + ex.getMessage());
        } finally {
            try {
                os.close();
            } catch (IOException iOException) {
                System.out.println("" + iOException.getMessage());
            }
        }
        for (Emp emp : retreivedData) {
            System.out.println(emp.toString());
        	} 
    }
}