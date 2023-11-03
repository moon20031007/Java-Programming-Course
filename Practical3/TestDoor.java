import java.util.Scanner;
class Door {
	protected boolean isOpen = false;
	void openDoor() {
		if (isOpen == false) {
			System.out.println("Door opened");
			isOpen = true;
		}
		else {
			System.out.println("Door already open!");
		}
	}
	void closeDoor() {
		if (isOpen == false) {
			System.out.println("Door already closed!");
		}
		else {
			System.out.println("Door closed");
			isOpen = false;
		}
	}
}
class DoorWithLock extends Door {
	protected boolean isLocked = false;
	void openDoor() {
		if (isOpen == false) {
			System.out.println("Door opened");
			isOpen = true;
		}
		else if (isOpen == false && isLocked == true) {
			System.out.println("Door is locked and cannot be opened!");
		}
		else {
			System.out.println("Door already open!");
		}
	}
	void loclDoor() {
		if (isOpen == true) {
			System.out.println("Open door cannot be locked!");
		}
		else if (isOpen == false && isLocked == true) {
			System.out.println("Door already locked!");
		}
		else if (isOpen == false && isLocked == false) {
			System.out.println("Door locked");
			isLocked = true;
		}
	}
	void unlockDoor() {
		if (isLocked == false) {
			System.out.println("Door is not locked!");
		}
		else if (isLocked == true) {
			System.out.println("Door unlocked");
			isLocked = false;
		}
	}
}
class DoorWithCodeLock extends DoorWithLock {
	Scanner input = new Scanner(System.in);
	protected int password  = 0;
	void loclDoor() {
		if (isOpen == true) {
			System.out.println("Open door cannot be locked!");
		}
		else if (isOpen == false && isLocked == true) {
			System.out.println("Door already locked!");
		}
		else if (isOpen == false && isLocked == false) {
			System.out.println("Door locked");
			isLocked = true;
			System.out.println("Please set a password: "); password = input.nextInt();
		}
	}
	void unlockDoor() {
		if (isLocked == false) {
			System.out.println("Door is not locked!");
		}
		else if (isLocked == true) {
			System.out.println("Please enter the password: "); int enter_password = input.nextInt();
			if (enter_password == password) {
				System.out.println("Door unlocked");
			isLocked = false;
			}
			else {
				System.out.println("Invalid code!");
			}
		}
	}
}
public class TestDoor {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DoorWithCodeLock myDoor = new DoorWithCodeLock();
		boolean x = true;
		while (x == true) {
			System.out.print("Enter 1 to open the door, 2 to close the door, 3 to lock door, 4 to unlock door, 5 to exit the loop:"); int choose = input.nextInt();
			switch(choose) {
				case 1:
					myDoor.openDoor();
					break;
				case 2:
					myDoor.closeDoor();
					break;
				case 3:
					myDoor.loclDoor();
					break;
				case 4:
					myDoor.unlockDoor();
					break;
				case 5:
					x = false;
					break;
				default:
					System.out.println("Invalid option!");
					break;
			}
		}
	}
}