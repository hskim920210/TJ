package Chatting;

import javax.swing.*;

public class ConList {
	
	ConList(JTextArea Area) {
		for(int i = 0 ; i < ClientList.getClientSize() ; i ++) {
			Area.append(ClientList.getClient(i).toString());
		}
	}
}
