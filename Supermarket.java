package office;

import java.io.*;
import java.util.*;

public class Supermarket {

	public static void main(String[] args) throws Exception {
		int ch = 0, quantity = 0;
		String name, date;
		ArrayList<Product> items = new ArrayList<>(); //arraylist for product
		
		File file = new File("product.txt");

		if (file.isFile()) {//reading data from the file
			ObjectInputStream datain = new ObjectInputStream(new FileInputStream(file));
			items = (ArrayList<Product>) datain.readObject();
			datain.close();
		}

		Scanner sc = new Scanner(System.in);
		

		do {

			System.out.println("welcome to supermarket -press for action");//menu
			System.out.println("1. view items ");
			System.out.println("2. add items");
			System.out.println("3. delete item");
			System.out.println("0. exit");
			ch = sc.nextInt();
			switch (ch) {

			case (1)://view items
				System.out.println("-------------------------------------");

				ListIterator<Product> it = items.listIterator();
				while (it.hasNext()) {
					System.out.println(it.next());
				}


				System.out.println("-------------------------------------\n");
				break;

			case (2)://add item
				System.out.println("-------------------------------------");

				System.out.println(" how many items to be added ");
				int n = sc.nextInt();

				for (int i = 1; i <= n; i++) {
					System.out.println("enter item name  ");
					name = sc.next();
					System.out.println("enter quantity ");
					quantity = sc.nextInt();
					System.out.println("enter date(dd/mm/yy) ");
					date = sc.next();
					Product item = new Product(name, quantity, date);
					items.add(item);
				}
				ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream(file));//write data to file
				data.writeObject(items);
				data.close();
				System.out.println("\n");
				break;
			case (3):// delete item by name
				boolean found=true;
				System.out.println("enter item to delete");
				String s = sc.next();
				ListIterator<Product> ti = items.listIterator();
				while (ti.hasNext()) {//match the product to be deleted

					Product p = (Product) ti.next();
					String t = p.getName();

					if (t.equals(s)) {
						ti.remove();
						found=true;
						
					}
					if(found) {
						
						 data = new ObjectOutputStream(new FileOutputStream(file)); //writing new data
							data.writeObject(items);
							data.close();
					}
					
					else {
						System.out.println("not found");
					}

				}

				break;

			}

		} while (ch != 0);
	}

}
