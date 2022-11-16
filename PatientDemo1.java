import java.util.*;
import java.io.*;
class Patient implements Serializable
{
	int id;
	String name,disease;

	Patient(int id,String name,String disease)
	{
		this.id = id;
		this.name = name;
		this.disease = disease;
	}
	public String toString()
	{
		return id + " " + name + " " + disease;
	}
}
class PatientDemo1
{
	public static void main(String[] args) 
	{
		int ch;
		
		Scanner sc = new Scanner(System.in);

		ArrayList<Patient> al = new ArrayList<Patient>();

		do
		{
			System.out.println(" 1) For Insert :");
			System.out.println(" 2) For Display :");
			System.out.println(" 3) For Search :");
			System.out.println(" 4) For Update :");
			System.out.println(" 5) For Delete :");
            System.out.println(" 6) For Import :");
            System.out.println(" 7) For Export :");
			System.out.println(" 0) For Exit :");
			System.out.print("Enter Your Choise : ");	
			ch = sc.nextInt();

			switch(ch)
			{
				case 1: //Insert
					System.out.print("Enter The Patient Id :");
					int id = sc.nextInt();

					System.out.print("Enter The Patient Name :");
					String name = sc.next();

					System.out.print("Enter The Patient Disease :");
					String dis = sc.next();

					al.add(new Patient(id,name,dis));

					break;
				case 2: //Display
					Iterator<Patient> i = al.iterator();
					System.out.println("----------------");
					while(i.hasNext())
					{
						Patient p = i.next();
						System.out.println(p);
					}
					System.out.println("----------------");
					break;
				case 3: //Seach
					boolean flag = false;

					System.out.print("Enter The Patient ID to Search :");
					int s = sc.nextInt();

					i = al.iterator();
					System.out.println("----------------");
					while(i.hasNext())
					{
						Patient p = i.next();
						if(p.id == s)
						{
							System.out.println(p);	
							flag = true;
						}
					}
					if(!flag)
					{
						System.out.println("The Patient Can't Seach in this ID...");
					}
					System.out.println("----------------");
					break;
				case 4: //Update
						flag = false;

					System.out.print("Enter The Patient ID to Update :");
					int upd = sc.nextInt();

					ListIterator<Patient> li = al.listIterator();
					System.out.println("----------------");
					while(li.hasNext())
					{
						Patient p = li.next();
						if(p.id == upd)
						{
							System.out.print("Enter The Patient Name :");
							String newname = sc.next();

							System.out.print("Enter The Patient Disease :");
							String newdis = sc.next();

							li.set(new Patient(p.id,newname,newdis));	
							flag = true;
						}
					}
					if(!flag)
					{
						System.out.println("The Patient Can't Found this ID...");
					}
					else
					{
						System.out.println("Record Updated SuccessFully...");
					}
					System.out.println("----------------");
					break;
				case 5: //Delete
					flag = false;

					System.out.print("Enter The Patient ID to Delete :");
					int del = sc.nextInt();

					i = al.iterator();
					System.out.println("----------------");
					while(i.hasNext())
					{
						Patient p = i.next();
						if(p.id == del)
						{
							i.remove();
							flag = true;
						}	
					}
					if(!flag)
					{
						System.out.println("The Patient Can't Found this ID...");
					}
					else
					{
						System.out.println("Record Deleted SuccessFully...");
					}
					System.out.println("----------------");
					break;
				case 6:// Impoert The Data
					try
					{
						FileOutputStream fos = new FileOutputStream("Patientdemo.txt");
						ObjectOutputStream oos = new ObjectOutputStream(fos);

						oos.writeObject(al);
						oos.flush();
						oos.close();
					}catch(Exception e)
					{
						System.out.println(e);
					}
					break;
				case 7:
					try
					{
						FileInputStream fis = new FileInputStream("Patientdemo.txt");
						ObjectInputStream ois = new ObjectInputStream(fis);

						al = (ArrayList<Patient>)ois.readObject();
						System.out.println(al);
					}catch(Exception e)
					{
						System.out.println(e);
					}
					break;
			}
		}while(ch != 0);
	}
}